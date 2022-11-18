package ISA.projekat.Service;

import ISA.projekat.Model.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Model.Staff;
import ISA.projekat.Model.User;
import ISA.projekat.Repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	
	public Address findOne(int address) {
		return addressRepository.findById(address).orElseGet(null);
	}

	public Address Update(CenterDTO centerDTO, BloodBankCenter bbCenter) {
		
		Address address = new Address(bbCenter.getAddress(), centerDTO.getCountry(), 
				centerDTO.getCity(), centerDTO.getStreet(), centerDTO.getNumber());
		
		return addressRepository.save(address);
		
	}

	public Address findById(int id){
		return addressRepository.findById(id).get();
	}
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	public Address Update(CenterAdminDTO centerAdminDTO, Staff staff) {
		
		Address address = new Address(staff.getAddress(), centerAdminDTO.country, 
				centerAdminDTO.city, centerAdminDTO.street, centerAdminDTO.number);
		
		return addressRepository.save(address);
		
		
	}
	


}
