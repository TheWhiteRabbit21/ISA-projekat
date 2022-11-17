package ISA.projekat.Controller;

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

        user = userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(produces = "application/json", value = "add")
    @ResponseBody
    public ResponseEntity<RegisteredUserDTO> RegisterUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        
    	Address address = new Address(registeredUserDTO.getState(), registeredUserDTO.getCity(), registeredUserDTO.getStreet(), registeredUserDTO.getNumber());
    	addressService.save(address);
    	userService.RegisterUser(registeredUserDTO, address.getId());
    	
        return new ResponseEntity<>(HttpStatus.OK);
    }

	@GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

//        List<User> users = userService.findAll();

        // convert users to DTOs
//        List<UserDTO> usersDTO = new ArrayList<>();
//        for (User u : users) {
//            usersDTO.add(new UserDTO(u));
//        }

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
    
    
    
    
    
    
    
    
    
    
    
    
    


}
