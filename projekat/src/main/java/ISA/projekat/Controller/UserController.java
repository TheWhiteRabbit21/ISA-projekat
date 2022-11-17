package ISA.projekat.Controller;

import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
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


    @PostMapping("/edit")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        RegisteredUser user = new RegisteredUser();
        user.setName(userDTO.name);
        user.setSurname(userDTO.surname);

        user = userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<RegisteredUser> users = userService.findAll();

        // convert users to DTOs
        List<UserDTO> usersDTO = new ArrayList<>();

        for (RegisteredUser u : users) {
            usersDTO.add(new UserDTO(u));

        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{jmbg}")
    public ResponseEntity<UserDTO> getUserByJmbg(@PathVariable("jmbg") Integer jmbg) {

        RegisteredUser user = userService.findOneByJmbg(jmbg);

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
    
    
    
    
    
    
    
    
    
    


}
