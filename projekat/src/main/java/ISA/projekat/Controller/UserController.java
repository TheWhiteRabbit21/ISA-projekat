package ISA.projekat.Controller;

import ISA.projekat.DTOs.SearchUserDTO;
import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.UserCategory;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AddressService addressService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        //user = userService.save(user);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(produces = "application/json", value = "add")
    @ResponseBody
    public ResponseEntity<RegisteredUserDTO> RegisterUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        
    	Address address = new Address(registeredUserDTO.getState(), registeredUserDTO.getCity(), registeredUserDTO.getStreet(), registeredUserDTO.getNumber());
    	addressService.save(address);
    	userService.RegisterUser(registeredUserDTO, address.getId());
    	
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserDTO> usersDTO = userService.findAll();

//        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    	return null;
    }

    @GetMapping(value = "/{jmbg}")
    public ResponseEntity<UserDTO> getUserByJmbg(@PathVariable Integer jmbg) {

        User user = userService.findOneByJmbg(jmbg);

        // user must exist
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
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
    @PostMapping(produces = "application/json", value = "/search")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAllUsersByNameAndSurname(@RequestBody SearchUserDTO searchUserDTO) {
        return new ResponseEntity<>(userService.findByNameAndSurnameAllIgnoringCase(searchUserDTO.getName(), searchUserDTO.getSurname()),HttpStatus.OK);
    }
}
