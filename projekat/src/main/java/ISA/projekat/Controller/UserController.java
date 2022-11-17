package ISA.projekat.Controller;

import ISA.projekat.DTOs.UserDTO;
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


    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        //user = userService.save(user);
        //return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
        return null;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        //return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        return null;
    }

    @GetMapping(value = "/{jmbg}")
    public ResponseEntity<UserDTO> getUserByJmbg(@PathVariable Integer jmbg) {

        User user = userService.findOneByJmbg(jmbg);

        // user must exist
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }


}
