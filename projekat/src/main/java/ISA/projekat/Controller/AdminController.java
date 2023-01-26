package ISA.projekat.Controller;

import ISA.projekat.DTOs.AdminDTO;
import ISA.projekat.DTOs.ComplaintDTO;
import ISA.projekat.DTOs.PasswordDTO;
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
    public ResponseEntity Answer(@RequestBody ComplaintDTO complaintDTO){
        complaintService.setResponse(complaintDTO.response, complaintDTO.id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/changedPassword",produces = "application/json")
    @ResponseBody
    public ResponseEntity CheckIfPasswordChanged(@RequestBody int id){
        boolean flag = adminService.checkIfPasswordChanged(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
    @PostMapping(value = "/changePassword")
    @ResponseBody
    public ResponseEntity ChangePassword(@RequestBody PasswordDTO passwordDTO){
        adminService.changePassword(passwordDTO.id, passwordDTO.password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
