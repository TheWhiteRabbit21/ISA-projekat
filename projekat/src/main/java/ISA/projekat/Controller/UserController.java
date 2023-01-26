package ISA.projekat.Controller;

import java.util.ArrayList;
import java.util.List;

import ISA.projekat.DTOs.*;
import ISA.projekat.Service.AdminService;
import ISA.projekat.Service.CenterAdminService;
import ISA.projekat.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.RegisteredUserService;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping(value = "api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private RegisteredUserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CenterAdminService centerAdminService;

    @Autowired
    private AddressService _addressService;


    @PutMapping(value = "/edit")
    public ResponseEntity<RegisteredUser2DTO> saveUser(@RequestBody RegisteredUser2DTO userDTO) {

    	User user1 = userService.findByUsername(userDTO.getEmail());
        RegisteredUser user = userService.findOneById(user1.getJmbg());
        Address address = _addressService.findById(userDTO.getAddress().getId());
        address.setCity(userDTO.getAddress().getCity());
        address.setCountry(userDTO.getAddress().getCountry());
        address.setNumber(userDTO.getAddress().getNumber());
        address.setStreet(userDTO.getAddress().getStreet());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setJmbg(userDTO.getJmbg());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setGender(userDTO.getGender());
        user.setInfoInstitution(userDTO.getEstablishmentInfo());
        user.setPoints(Double.parseDouble(userDTO.getPoints()));
        user.setProfession(userDTO.getOccupation());
        user.setUserCatagory(userDTO.getUser_catagory());
        user = userService.save(user);
        address = _addressService.save(address);
        return new ResponseEntity<>(HttpStatus.CREATED);


        //user = userService.save(user);


    }
    
   /* @PostMapping(produces = "application/json", value = "add")
    @ResponseBody
    public ResponseEntity<RegisteredUserDTO> RegisterUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        
    	Address address = new Address(registeredUserDTO.getState(), registeredUserDTO.getCity(), registeredUserDTO.getStreet(), registeredUserDTO.getNumber());
    	userService.RegisterUser(registeredUserDTO, address);
    	
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PostMapping(value = "/all")
    public ResponseEntity<List<RegisteredUser2DTO>> getAllUsers(@RequestBody PageDTO pageDTO) {

        List<RegisteredUser> users = userService.findAll(pageDTO.pageIndex, pageDTO.pageSize);

        // convert users to DTOs
        List<RegisteredUser2DTO> usersDTO = new ArrayList<>();

        for (RegisteredUser u : users) {
            Address address = _addressService.findOne(u.getAddress().getId());
            usersDTO.add(new RegisteredUser2DTO(u.getId(), u.getUsername(), u.getPassword(), u.getName(), u.getSurname(), address, u.getPhoneNumber(), u.getJmbg(), 
            		u.getGender(), u.getProfession(), u.getInfoInstitution(), String.valueOf(u.getPoints()), String.valueOf(u.getUserCatagory())));

        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);

    }
    
    @GetMapping(value = "/data")
    public ResponseEntity<UserDTO> getUserData(HttpServletRequest request) {

        String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
        int id = userService.findIdByUsername(username);
        if(id != 0){
            UserDTO userDataDTO = new UserDTO();
            userDataDTO.id = id;
            userDataDTO.role = 2;
            return new ResponseEntity<>(userDataDTO, HttpStatus.OK);
        }
        id = adminService.findIdByUsername(username);
        if(id != 0){
            UserDTO userDataDTO = new UserDTO();
            userDataDTO.id = id;
            userDataDTO.role = 3;
            return new ResponseEntity<>(userDataDTO, HttpStatus.OK);
        }
        id = centerAdminService.findIdByUsername(username);
        if(id != 0){
            UserDTO userDataDTO = new UserDTO();
            userDataDTO.id = id;
            userDataDTO.role = 1;
            return new ResponseEntity<>(userDataDTO, HttpStatus.OK);
        }
        UserDTO userDataDTO = new UserDTO();
        return new ResponseEntity<>(userDataDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<RegisteredUser2DTO> getUserById(@PathVariable("id") int id) {

        RegisteredUser u = userService.findOneById(id);

        // user must exist
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        Address address = _addressService.findOne(u.getAddress().getId());
        RegisteredUser2DTO  userDTO = new RegisteredUser2DTO(u.getId(), u.getUsername(), u.getPassword(), u.getName(), u.getSurname(), address, u.getPhoneNumber(), u.getJmbg(), 
        		u.getGender(), u.getProfession(), u.getInfoInstitution(), String.valueOf(u.getPoints()), String.valueOf(u.getUserCatagory()));


        return new ResponseEntity<>(userDTO , HttpStatus.OK);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<UserDTO> updateCenter(@RequestBody UserDTO userDTO){
    	
    	//TODO
//    	System.out.println(userDTO.getName());
//    	System.out.println(userDTO.getId());
//    	System.out.println(userDTO);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping(value = "/penaltyAddById", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<UserDTO> addUsersPenal(@RequestBody int id){
    	
    	userService.IncreaseUsersPenalty(id);

    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    @PostMapping(produces = "application/json", value = "/search")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAllUsersByNameAndSurname(@RequestBody SearchUserDTO searchUserDTO) {
        return new ResponseEntity<>(userService.findByNameAndSurnameAllIgnoringCase(searchUserDTO.getName().toLowerCase(), searchUserDTO.getSurname().toLowerCase()),HttpStatus.OK);
    }
    /*public static String getEmailFromRequest(HttpServletRequest req) {
        String authorizationHeader = req.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String token = authorizationHeader.substring("Bearer ".length());
                DecodedJWT decodedJWT = getVerifier().verify(token);
                return decodedJWT.getSubject();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }*/
}
