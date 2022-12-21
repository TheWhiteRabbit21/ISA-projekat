package ISA.projekat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;
import ISA.projekat.Repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}*/
    
    private List<UserDTO> parseList(List<RegisteredUser> registeredUsers){
        List<UserDTO> users = new ArrayList<UserDTO>();
        for(RegisteredUser user : registeredUsers){
            users.add(new UserDTO(user, user.getAddress()));
        }
        return users;
    }

    public List<RegisteredUser> findByLastName(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public List<RegisteredUser> findAllUsersBySurname(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }
    
    public void RegisterUser(RegisteredUserDTO registeredUserDTO, Address address){
    	userRepository.save(new RegisteredUser(registeredUserDTO.getEmail(), registeredUserDTO.getPassword(), registeredUserDTO.getName(), registeredUserDTO.getSurname(), registeredUserDTO.getGender(), registeredUserDTO.getJmbg(), address, registeredUserDTO.getPhoneNumber(), 0.00, "", registeredUserDTO.getEstablishmentInfo(), registeredUserDTO.getOccupation(), UserCategory.BRONZE));
    }

    public RegisteredUser findOneById(int jmbg) {
        return userRepository.findOneById(jmbg);

    }

    public RegisteredUser findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public List<UserDTO> findByNameAndSurnameAllIgnoringCase(String name, String surname) {
        return parseList(userRepository.findAllByNameAndSurnameIgnoreCase(name, surname));

    }

    public List<RegisteredUser> findAllUsersByName(String name) {
        return userRepository.findAllUsersByName(name);
    }

    public RegisteredUser save(RegisteredUser user) {
        return userRepository.save(user);
    }


    public List<RegisteredUser> findAll() {
        return userRepository.findAll();
    }

    public RegisteredUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }

}
