package ISA.projekat.Service;

import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;

import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;
import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;


    public List<UserDTO> findAll(){
       return parseList(userRepository.findAll());
    }
    private List<UserDTO> parseList(List<RegisteredUser> registeredUsers){
        List<UserDTO> users = new ArrayList<UserDTO>();
        for(RegisteredUser user : registeredUsers){
            Address address = addressRepository.findById(user.getAddress()).get();
            users.add(new UserDTO(user, address));
        }
        return users;
    }
    public List<RegisteredUser> findByLastName(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public List<RegisteredUser> findAllUsersBySurname(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }
    
    public void RegisterUser(RegisteredUserDTO registeredUserDTO, int addressId){
    	userRepository.save(new RegisteredUser(registeredUserDTO.getEmail(), registeredUserDTO.getPassword(), registeredUserDTO.getName(), registeredUserDTO.getSurname(), registeredUserDTO.getGender(), registeredUserDTO.getJmbg(), addressId, registeredUserDTO.getPhoneNumber(), 0.00, "", registeredUserDTO.getEstablishmentInfo(), registeredUserDTO.getOccupation(), UserCategory.BRONZE));
    }

    public RegisteredUser findOneByJmbg(Integer jmbg) {
        return userRepository.findOneByJmbg(jmbg);
    }

    public RegisteredUser findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public List<UserDTO> findByNameAndSurnameAllIgnoringCase(String name, String surname) {
        return parseList(userRepository.findByNameAndSurnameAllIgnoringCase(name, surname));
    }

    public List<RegisteredUser> findAllUsersByName(String name) {
        return userRepository.findAllUsersByName(name);
    }

    public RegisteredUser save(RegisteredUser user) {
        return userRepository.save(user);
    }
}
