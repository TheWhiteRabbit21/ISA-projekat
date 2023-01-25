package ISA.projekat.Controller;

import ISA.projekat.DTOs.BloodCenterListDTO;
import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.DTOs.SearchCenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Service.AddressService;
import ISA.projekat.Service.CenterAdminService;
import ISA.projekat.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/centers")
@CrossOrigin
public class CenterController {

    @Autowired
    private CenterService centerService;
    @Autowired
    private CenterAdminService centerAdminService;
    @Autowired
    private AddressService addressService;

    @SuppressWarnings("rawtypes")
	@PostMapping(produces = "application/json")
    @ResponseBody

    public ResponseEntity CreateCenter(@RequestBody CenterDTO centerDTO){

        centerService.Create(centerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<BloodCenterListDTO>> getAllBloodCenters() {

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address address = addressService.findOne(c.getAddress().getId());
        	bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAdmins")
    public ResponseEntity<List<CenterAdminDTO>> getAllAvailabelAdmins() {
        return new ResponseEntity<>(centerAdminService.GetAvailableAdmins(), HttpStatus.OK);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<CenterDTO> updateCenter(@RequestBody CenterDTO centerDTO) {

    	
    	BloodBankCenter bbCenter = centerService.findOne(Integer.parseInt(centerDTO.getId()));
    	
    	Address address = addressService.findOne(bbCenter.getAddress().getId());
    	
    	
    	if (bbCenter == null || address == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    	
    	address = addressService.Update(centerDTO, bbCenter);
    	bbCenter = centerService.Update(centerDTO, bbCenter, address);    	
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/search_name/{name}")
    public ResponseEntity<List<BloodCenterListDTO>> searchByName(@PathVariable("name") String name) {

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            if (!c.getName().toLowerCase().contains(name.toLowerCase())) {
                continue;
            }
            Address address = addressService.findOne(c.getAddress().getId());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/search_city/{city}")
    public ResponseEntity<List<BloodCenterListDTO>> searchByCity(@PathVariable("city") String city) {

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address ad = addressService.findById(c.getAddress().getId());
            if(!ad.getCity().toLowerCase().contains(city.toLowerCase())){

                continue;
            }
            Address address = addressService.findOne(c.getAddress().getId());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/filter_country/{country}")
    public ResponseEntity<List<BloodCenterListDTO>> searchByCountry(@PathVariable("country") String country) {

        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address ad = addressService.findById(c.getAddress().getId());
            if(!ad.getCountry().toLowerCase().contains(country.toLowerCase())){
                continue;
            }
            Address address = addressService.findOne(c.getAddress().getId());
            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), address.getCity(), address.getCountry(), c.getDescription()));
        }

        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/filter_avgPoints/{avgPoints}")
    public ResponseEntity<List<BloodCenterListDTO>> searchByAvgPoints(@PathVariable("avgPoints") String avgPoints) {
        double first = Double.parseDouble(String.valueOf(avgPoints.charAt(0)));
        double last =  Double.parseDouble(String.valueOf(avgPoints.charAt(2)));
        List<BloodBankCenter> bloodBankCenters = centerService.findAll();

        // convert users to DTOs
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : bloodBankCenters) {
            Address ad = addressService.findById(c.getAddress().getId());
            if (c.getAverageRating() >= first && c.getAverageRating() <= last) {

                bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), ad.getCity(), ad.getCountry(), c.getDescription()));
            }

        }
        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }
    @PostMapping(value = "/search_name_city", produces = "application/json")
    @ResponseBody()
    public ResponseEntity<List<BloodCenterListDTO>> findByNameAndCity(@RequestBody SearchCenterDTO searchCenterDTO){
        List<BloodCenterListDTO> bloodBankcentersDTO = new ArrayList<>();
        for (BloodBankCenter c : centerService.findAllByNameAndCity(searchCenterDTO.name.toLowerCase(), searchCenterDTO.city.toLowerCase() )) {
            Address ad = addressService.findById(c.getAddress().getId());

            bloodBankcentersDTO.add(new BloodCenterListDTO(c.getName(), c.getAverageRating(), ad.getCity(), ad.getCountry(), c.getDescription()));


        }
        return new ResponseEntity<>(bloodBankcentersDTO, HttpStatus.OK);
    }
}