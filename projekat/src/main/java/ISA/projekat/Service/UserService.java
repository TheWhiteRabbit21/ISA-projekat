package ISA.projekat.Service;


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

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public List<User> findByLastName(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public List<User> findAllUsersBySurname(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }
    
    public void RegisterUser(RegisteredUserDTO registeredUserDTO){
        //addressRepository.save(new Address(registeredUserDTO.getState(), registeredUserDTO.getCity(), registeredUserDTO.getStreet(), registeredUserDTO.getNumber()));
        userRepository.save(new RegisteredUser(registeredUserDTO.getEmail(), registeredUserDTO.getPassword(), registeredUserDTO.getName(), registeredUserDTO.getSurname(), Gender.MALE, registeredUserDTO.getJmbg(), 500, registeredUserDTO.getPhoneNumber(), 0.00, "", registeredUserDTO.getEstablishmentInfo(), registeredUserDTO.getOccupation(), UserCategory.BRONZE));
    }

    public User findOneByJmbg(Integer jmbg) {
        return userRepository.findOneByJmbg(jmbg);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public List<User> findByNameAndSurnameAllIgnoringCase(String name, String surname) {
        return userRepository.findByNameAndSurnameAllIgnoringCase(name, surname);
    }

    public List<User> findAllUsersByName(String name) {
        return userRepository.findAllUsersByName(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
