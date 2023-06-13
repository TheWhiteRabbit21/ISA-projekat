package ISA.projekat.Service;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Model.Staff;
//import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterAdminRepository;
import ISA.projekat.Repository.CenterRepository;
import ISA.projekat.Repository.PredefinedAppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    private final CenterRepository centerRepository;
//    private final AddressRepository addressRepository;

    private final CenterAdminRepository centerAdminRepository;
    
    public CenterService(CenterRepository centerRepository, AddressRepository addressRepository, CenterAdminRepository centerAdminRepository) {
        this.centerRepository = centerRepository;
//        this.addressRepository = addressRepository;
        this.centerAdminRepository = centerAdminRepository;
    }
    
    public void Create(CenterDTO centerDTO){
        Address address = new Address(centerDTO.country, centerDTO.city, centerDTO.street, centerDTO.number);
        BloodBankCenter bloodBankCenter = centerRepository.save(new BloodBankCenter(centerDTO.name, address, centerDTO.description));
        for(int id : centerDTO.admins){
            Staff staff = centerAdminRepository.findById(id).get();
            staff.setBloodBankCenter(bloodBankCenter);
            centerAdminRepository.save(staff);
        }
    }
    
    public Page<BloodBankCenter> findAll(int pageIndex, int pageSize){
        Page<BloodBankCenter> centers = centerRepository.findAll(PageRequest.of(pageIndex, pageSize));
        return centers;
    }

    public List<BloodBankCenter> findAll(){
        return centerRepository.findAll();
    }
    
	public BloodBankCenter findOne(Integer id) {
		return centerRepository.findById(id).orElseGet(null);
	}

	public BloodBankCenter Update(CenterDTO centerDTO, BloodBankCenter bbCenter, Address address) {
		
		BloodBankCenter temp = new BloodBankCenter(bbCenter.getId(), centerDTO.getName(), address, 
				centerDTO.getDescription(), bbCenter.getAverageRating());
		
		return centerRepository.save(temp);
	}

    public List<BloodBankCenter> findAllByNameAndCity(String name, String city){
        return centerRepository.findAllByNameAndCity(name,city);
    }
}
