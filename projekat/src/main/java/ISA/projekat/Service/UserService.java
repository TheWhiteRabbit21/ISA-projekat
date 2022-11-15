package ISA.projekat.Service;

import ISA.projekat.Model.User;
import ISA.projekat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findByLastName(String surname) {
        return userRepository.findAllUsersBySurname(surname);
    }

    public List<User> findAllUsersBySurname(String surname) {
        return userRepository.findAllUsersBySurname(surname);
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
