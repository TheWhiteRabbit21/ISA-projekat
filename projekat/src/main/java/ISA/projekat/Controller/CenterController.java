package ISA.projekat.Controller;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public String CreateCenter(@RequestBody CenterDTO centerDTO){
        centerService.Create(centerDTO);
        return "Dosao";
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<BloodBankCenter> helloWorld(){
        return centerService.findAll();
    }
}
