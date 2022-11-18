package ISA.projekat.Service;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.Staff;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterAdminRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterAdminService {
	
    private final CenterAdminRepository centerAdminRepository;
    private final AddressRepository addressRepository;

    public CenterAdminService(CenterAdminRepository centerAdminRepository, AddressRepository addressRepository) {
        this.centerAdminRepository = centerAdminRepository;
        this.addressRepository = addressRepository;
    }

    
    public void CreateCenterAdmin(CenterAdminDTO centerAdminDTO){
        Address address = addressRepository.save(new Address(centerAdminDTO.country, centerAdminDTO.city, centerAdminDTO.street, centerAdminDTO.number));
        centerAdminRepository.save(new Staff(centerAdminDTO.email,centerAdminDTO.password,centerAdminDTO.name,
                centerAdminDTO.surname, parseGender(centerAdminDTO.gender), centerAdminDTO.jmbg, address.getId(),centerAdminDTO.phoneNumber));
    }
    public List<CenterAdminDTO> GetAvailableAdmins(){
        List<CenterAdminDTO> admins = new ArrayList<CenterAdminDTO>();
        for(Staff admin : centerAdminRepository.findAllByBloodBankCenterIsNull()){
            admins.add(new CenterAdminDTO(admin.getId(),admin.getName(),admin.getSurname()));
        }
        return admins;
    }

    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }

	public Staff findOne(int id) {
		return centerAdminRepository.findById(id).orElseGet(null);
	}

	public Staff Update(CenterAdminDTO centerAdminDTO, Staff staff) {
		
		Gender gender;
		
		if(centerAdminDTO.gender.equalsIgnoreCase("male")) {
			gender = Gender.MALE;
		}
		else if(centerAdminDTO.gender.equalsIgnoreCase("female")) {
			gender = Gender.FEMALE;
		}
		else {gender = Gender.OTHER;}
		
		Staff temp = new Staff(staff.getId(), centerAdminDTO.email, staff.getPassword(), centerAdminDTO.name, centerAdminDTO.surname,
			 gender, centerAdminDTO.jmbg, staff.getAddress(), centerAdminDTO.phoneNumber);
		
		return centerAdminRepository.save(temp);
		
	}

	public List<Staff> findAll() {
		return centerAdminRepository.findAll();
	}
    
}
