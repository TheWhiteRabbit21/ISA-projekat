package ISA.projekat.Controller;

import ISA.projekat.DTOs.AdminDTO;
import ISA.projekat.DTOs.ComplaintDTO;
import ISA.projekat.Model.Complaint;
import ISA.projekat.Service.AdminService;
import ISA.projekat.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ComplaintService complaintService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity CreateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.create(adminDTO.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/unanswered", produces = "application/json")
    @ResponseBody
    public ResponseEntity GetAllUnanswered(){
        List<ComplaintDTO> complaints = new ArrayList<ComplaintDTO>();
        for(Complaint complaint : complaintService.getAllUnanswered()){
            complaints.add(new ComplaintDTO(complaint.getId(),complaint.getText()));
        }
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }
    @PostMapping(value = "/answer")
    @ResponseBody
    @Transactional
    public ResponseEntity Answer(@RequestBody ComplaintDTO complaintDTO){
        complaintService.setResponse(complaintDTO.response, complaintDTO.id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/changedPassword",produces = "application/json")
    @ResponseBody
    public ResponseEntity CheckIfPasswordChanged(){
        boolean flag = adminService.checkIfPasswordChanged(6);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
    @PostMapping(value = "/changePassword")
    @ResponseBody
    public ResponseEntity ChangePassword(@RequestBody String password){
        adminService.changePassword(6, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
