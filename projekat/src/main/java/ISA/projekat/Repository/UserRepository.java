package ISA.projekat.Repository;


import ISA.projekat.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findOneByJmbg(Integer jmbg);


    @Query("select u from User u where u.surname = ?1")
    public List<User> findAllUsersBySurname(String surname);

    @Query("select u from User u where u.name = ?1")
    public List<User> findAllUsersByName(String name);
    public User findByPassword(String password);

    public List<User> findByNameAndSurnameAllIgnoringCase(String name, String surname);

    public Page<User> findAll(Pageable pageable);

}
