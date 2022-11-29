package ISA.projekat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ISA.projekat.Model.BloodDonorInfo;
import ISA.projekat.Service.BloodDonorInfoService;

@RestController
@RequestMapping(value = "api/bloodDonorInfo")
public class BloodDonorInfoController {

	@Autowired
    private BloodDonorInfoService bloodDonorInfoService;
	
	 @GetMapping(value = "/all")
	    public ResponseEntity<List<BloodDonorInfo>> getBloodDonorInfo() {

	        List<BloodDonorInfo> bloodBankCenters = bloodDonorInfoService.findAll();

	        return new ResponseEntity<>(bloodBankCenters, HttpStatus.OK);
	 }
	 
	@PostMapping(produces = "application/json", value = "add")
    @ResponseBody
	    public ResponseEntity<BloodDonorInfo> CreateBloodDonorInfo(@RequestBody BloodDonorInfo bloodDonorInfo){
	        
		bloodDonorInfoService.Create(bloodDonorInfo);
	    	
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
