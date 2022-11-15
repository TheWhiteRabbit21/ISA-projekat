package ISA.projekat.Service;

import ISA.projekat.DTOs.CenterDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.Center;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterRepository;
import org.springframework.stereotype.Service;

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
        centerRepository.save(new Center(centerDTO.name, address.getId(), centerDTO.description));
    }
}
