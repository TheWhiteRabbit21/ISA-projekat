package ISA.projekat.Service;

import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<RegisteredUser> findByLastName(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public List<RegisteredUser> findAllUsersBySurname(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public RegisteredUser findOneByJmbg(Integer jmbg) {
        return userRepository.findOneByJmbg(jmbg);
    }

    public RegisteredUser findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public List<RegisteredUser> findByNameAndSurnameAllIgnoringCase(String name, String surname) {
        return userRepository.findByNameAndSurnameAllIgnoringCase(name, surname);
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

    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }
}
