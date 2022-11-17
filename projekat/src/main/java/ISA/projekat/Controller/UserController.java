package ISA.projekat.Controller;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.DTOs.RegisteredUser2DTO;
import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService _addressService;

    @PutMapping(value = "/edit")
    public ResponseEntity<RegisteredUser2DTO> saveUser(@RequestBody RegisteredUser2DTO userDTO) {

        RegisteredUser user = userService.findByEmail(userDTO.getEmail());
        Address address = _addressService.findById(userDTO.getAddress().getId());
        address.setCity(userDTO.getAddress().getCity());
        address.setCountry(userDTO.getAddress().getCountry());
        address.setNumber(userDTO.getAddress().getNumber());
        address.setStreet(userDTO.getAddress().getStreet());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress().getId());
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
    }
    
    @PostMapping(produces = "application/json", value = "add")
    @ResponseBody
    public String RegisterUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        userService.RegisterUser(registeredUserDTO);
        return "Dosao";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<RegisteredUser2DTO>> getAllUsers() {

        List<RegisteredUser> users = userService.findAll();

        // convert users to DTOs
        List<RegisteredUser2DTO> usersDTO = new ArrayList<>();

        for (RegisteredUser u : users) {
            Address address = _addressService.findOne(u.getAddress());
            usersDTO.add(new RegisteredUser2DTO(u.getEmail(),u.getPassword(),u.getName(),u.getSurname(),address,u.getPhoneNumber(),u.getJmbg(),u.getGender(),u.getProfession(),u.getInfoInstitution(),String.valueOf(u.getPoints()),String.valueOf(u.getUserCatagory())));

        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<RegisteredUser2DTO> getUserById(@PathVariable("id") Integer id) {

        RegisteredUser u = userService.findOneById(id);

        // user must exist
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        Address address = _addressService.findOne(u.getAddress());
        RegisteredUser2DTO  userDTO = new RegisteredUser2DTO(u.getEmail(),u.getPassword(),u.getName(),u.getSurname(),address,u.getPhoneNumber(),u.getJmbg(),u.getGender(),u.getProfession(),u.getInfoInstitution(),String.valueOf(u.getPoints()),String.valueOf(u.getUserCatagory()));


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
    
    
    
    
    
    
    
    
    
    


}
