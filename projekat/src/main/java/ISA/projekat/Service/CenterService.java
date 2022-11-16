package ISA.projekat.Service;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    private final CenterRepository centerRepository;
    private final AddressRepository addressRepository;
    
    public CenterService(CenterRepository centerRepository, AddressRepository addressRepository) {
        this.centerRepository = centerRepository;
        this.addressRepository = addressRepository;
    }
    
    public void Create(CenterDTO centerDTO){
        Address address = addressRepository.save(new Address(centerDTO.country, centerDTO.city, centerDTO.street, centerDTO.number));
        centerRepository.save(new BloodBankCenter(centerDTO.name, address.getId(), centerDTO.description));
    }
    
    public List<BloodBankCenter> findAll(){
        return centerRepository.findAll();
    }
    
	public BloodBankCenter findOne(Integer id) {
		return centerRepository.findById(id).orElseGet(null);
	}

	public BloodBankCenter Update(CenterDTO centerDTO, BloodBankCenter bbCenter) {
		
		BloodBankCenter temp = new BloodBankCenter(bbCenter.getId(), centerDTO.getName(), bbCenter.getAddress(), centerDTO.getDescription(), bbCenter.getAverageRating());
		
		return centerRepository.save(temp);
	}
}
