package ISA.projekat.Controller;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Service.CenterAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/center-admins/")
public class CenterAdminController {

    @Autowired
    private CenterAdminService centerAdminService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public void CreateAdmin(@RequestBody CenterAdminDTO centerAdminDTO){
        centerAdminService.CreateCenterAdmin(centerAdminDTO);
    }
}
