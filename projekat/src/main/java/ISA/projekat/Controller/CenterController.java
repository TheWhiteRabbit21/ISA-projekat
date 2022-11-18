package ISA.projekat.Controller;

import ISA.projekat.DTOs.BloodCenterListDTO;
import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.CenterAdminService;
import ISA.projekat.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;
    @Autowired
    private CenterAdminService centerAdminService;
    @Autowired
    private AddressService addressService;
    
    @PostMapping(produces = "application/json")
    @ResponseBody
    public String CreateCenter(@RequestBody CenterDTO centerDTO){
        centerService.Create(centerDTO);
        return "Dosao";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BloodCenterListDTO>> getAllBloodCenters() {

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address address = addressService.findOne(c.getAddress());
        	bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/getAdmins")
    public ResponseEntity<List<CenterAdminDTO>> getAllAvailabelAdmins() {
        return new ResponseEntity<>(centerAdminService.GetAvailableAdmins(),HttpStatus.OK);
    }
    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<CenterDTO> updateCenter(@RequestBody CenterDTO centerDTO) {
    	
    	BloodBankCenter bbCenter = centerService.findOne(Integer.parseInt(centerDTO.getId()));
    	
    	Address address = addressService.findOne(bbCenter.getAddress());
    	
    	
    	if (bbCenter == null || address == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    	
    	addressService.Update(centerDTO, bbCenter);
    	centerService.Update(centerDTO, bbCenter);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/search_name/{name}")
    public ResponseEntity<List<BloodCenterListDTO>>  searchByName(@PathVariable("name") String name){

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            if(!c.getName().toLowerCase().contains(name.toLowerCase())){
                continue;
            }
            Address address = addressService.findOne(c.getAddress());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/search_city/{city}")
    public ResponseEntity<List<BloodCenterListDTO>>  searchByCity(@PathVariable("city") String city){

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address ad = addressService.findById(c.getAddress());
            if(!ad.getCity().toLowerCase().contains(city.toLowerCase())){
                continue;
            }
            Address address = addressService.findOne(c.getAddress());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/filter_country/{country}")
    public ResponseEntity<List<BloodCenterListDTO>>  searchByCountry(@PathVariable("country") String country){

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address ad = addressService.findById(c.getAddress());
            if(!ad.getCountry().toLowerCase().contains(country.toLowerCase())){
                continue;
            }
            Address address = addressService.findOne(c.getAddress());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }
}
