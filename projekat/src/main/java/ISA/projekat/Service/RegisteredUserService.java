package ISA.projekat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.DTOs.UserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;
import ISA.projekat.Repository.RegisteredUserRepository;


@Service
public class RegisteredUserService {

    @Autowired
    private RegisteredUserRepository userRepository;

    public int findIdByUsername(String username){
		if(userRepository.findByUsername(username) != null){
            return userRepository.findByUsername(username).getId();
        }
        return 0;
	}
    
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
    	userRepository.save(new RegisteredUser(registeredUserDTO.getEmail(), registeredUserDTO.getPassword(), registeredUserDTO.getName(), registeredUserDTO.getSurname(), registeredUserDTO.getGender(), registeredUserDTO.getJmbg(), address, registeredUserDTO.getPhoneNumber(), 0.00, "", registeredUserDTO.getEstablishmentInfo(), registeredUserDTO.getOccupation(), UserCategory.BRONZE, 0));
    }

    public RegisteredUser findByJmbg(int jmbg) {
        return userRepository.findByJmbg(jmbg);

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


    public List<RegisteredUser> findAll(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex*pageSize, (pageIndex+1)*pageSize);
        return userRepository.findAll(pageable).toList();
    }

   public RegisteredUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }
	public RegisteredUser findById(Integer id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

   
	public void IncreaseUsersPenalty(int id) {

		RegisteredUser u = userRepository.findById(id).get();
		
		int tempPenal = u.getPenals() + 1;
		u.setPenals(tempPenal);
		
		userRepository.save(u);
	}
	
    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }

}
