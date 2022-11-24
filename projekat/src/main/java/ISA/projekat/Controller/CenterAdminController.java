package ISA.projekat.Controller;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.Staff;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.CenterAdminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/center-admins")
public class CenterAdminController {


    @Autowired
    private CenterAdminService centerAdminService;

    @Autowired
    private AddressService addressService;
    
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<CenterAdminDTO>> getAllCenterAdmins() {

        List<Staff> staffs = centerAdminService.findAll();

        // convert users to DTOs
        List<CenterAdminDTO> centerAdminDTO = new ArrayList<>();
        for (Staff s : staffs) {
            Address address = addressService.findOne(s.getAddress().getId());
            centerAdminDTO.add(new CenterAdminDTO(s.getId(), s.getName(), s.getSurname(), address.getCity(), address.getCountry(), address.getStreet(), 
            		address.getNumber(), s.getGender().toString(), s.getEmail(), s.getPassword(), s.getJmbg(), s.getPhoneNumber()));
        }

        return new ResponseEntity<>(centerAdminDTO, HttpStatus.OK);
    }
    
    
    
    @PostMapping(produces = "application/json")
    @ResponseBody
    public void CreateAdmin(@RequestBody CenterAdminDTO centerAdminDTO){
        centerAdminService.CreateCenterAdmin(centerAdminDTO);
    }
    
    
    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<CenterAdminDTO> updateCenterAdmin(@RequestBody CenterAdminDTO centerAdminDTO){

    	Staff staff = centerAdminService.findOne(centerAdminDTO.id);
    	
    	Address address = addressService.findOne(staff.getAddress().getId());
    	
    	if (staff == null || address == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    	
    	addressService.Update(centerAdminDTO, staff);
    	centerAdminService.Update(centerAdminDTO, staff);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
}

