package ISA.projekat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
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

}
