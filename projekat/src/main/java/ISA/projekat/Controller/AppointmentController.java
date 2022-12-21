package ISA.projekat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.projekat.DTOs.AppointmentInfoDTO;
import ISA.projekat.Service.EquipmentService;

@RestController
@RequestMapping(value = "api/appointments")
public class AppointmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<AppointmentInfoDTO> addAppointmentHistory(@RequestBody AppointmentInfoDTO appointmentInfoDTO)
	{
		equipmentService.updateEquipment(appointmentInfoDTO.getKolicinaKrviDataML(), appointmentInfoDTO.brojIgala);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
