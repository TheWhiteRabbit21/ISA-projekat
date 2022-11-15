package ISA.projekat.Controller;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping(produces = "application/json")
    @ResponseBody
    public String helloWorld(@RequestBody CenterDTO center){
        return "Hello World!";
    }
}
