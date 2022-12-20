package ISA.projekat.Controller;

import ISA.projekat.DTOs.AdminDTO;
import ISA.projekat.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity CreateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.create(adminDTO.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity CheckIfPasswordChanged(){
        boolean flag = adminService.checkIfPasswordChanged(2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
