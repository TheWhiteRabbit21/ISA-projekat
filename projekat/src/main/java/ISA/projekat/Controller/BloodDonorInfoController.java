package ISA.projekat.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ISA.projekat.DTOs.AppointmentBloodDonorInfoDTO;
import ISA.projekat.DTOs.AppointmentInfoDTO;
import ISA.projekat.Model.AppointmentHistory;
import ISA.projekat.Model.BloodDonorInfo;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Service.BloodDonorInfoService;
import ISA.projekat.Service.RegisteredUserService;

@RestController
@RequestMapping(value = "api/bloodDonorInfo")
public class BloodDonorInfoController {

	@Autowired
    private BloodDonorInfoService bloodDonorInfoService;
	@Autowired
	private RegisteredUserService userService;
	
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
	
	
	@GetMapping(produces = "application/json", value = "findByDonorId/{id}")
		public ResponseEntity<List<AppointmentBloodDonorInfoDTO>> GetBloodDonorInfo(@PathVariable("id") int id){
		
		RegisteredUser u = userService.findById(id);
		
		BloodDonorInfo bdi = bloodDonorInfoService.findByDonorId(id);
				
		AppointmentBloodDonorInfoDTO temp = new AppointmentBloodDonorInfoDTO(u, bdi);
		
		List<AppointmentBloodDonorInfoDTO> dto = new ArrayList<AppointmentBloodDonorInfoDTO>();
		dto.add(temp);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(produces = "application/json", value = "findAppointmentHistoryById/{id}")
	public ResponseEntity<List<AppointmentInfoDTO>> GetAppointmentHistory(@PathVariable("id") int id){
		
		List<AppointmentHistory> lah = new ArrayList<>();
		lah = bloodDonorInfoService.findAppointmentHistoryById(id);
		
		List<AppointmentInfoDTO> dto = new ArrayList<AppointmentInfoDTO>();

		for(AppointmentHistory ah : lah) {
			dto.add(new AppointmentInfoDTO(ah));
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	
	
	
	
}
