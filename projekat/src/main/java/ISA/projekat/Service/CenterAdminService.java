package ISA.projekat.Service;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.Staff;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterAdminRepository;
import org.springframework.stereotype.Service;

@Service
public class CenterAdminService {
    private final CenterAdminRepository centerAdminRepository;
    private final AddressRepository addressRepository;

    public CenterAdminService(CenterAdminRepository centerAdminRepository, AddressRepository addressRepository) {
        this.centerAdminRepository = centerAdminRepository;
        this.addressRepository = addressRepository;
    }
//    public void CreateCenterAdmin(CenterAdminDTO centerAdminDTO){
//        Address address = addressRepository.save(new Address(centerAdminDTO.country, centerAdminDTO.city, centerAdminDTO.street, centerAdminDTO.number));
//        centerAdminRepository.save(new Staff(centerAdminDTO.email,centerAdminDTO.password,centerAdminDTO.name,
//                centerAdminDTO.surname, parseGender(centerAdminDTO.gender), centerAdminDTO.jmbg, address.getId(),centerAdminDTO.phoneNumber));
//    }
    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }
}
