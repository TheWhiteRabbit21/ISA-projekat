package ISA.projekat.Repository;


import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<RegisteredUser, Integer> {

    public RegisteredUser findOneById(Integer id);

    Optional<RegisteredUser> findByEmail(String email);

    @Query("select u from User u where u.surname = ?1")
    public List<RegisteredUser> findAllUsersBySurname(String surname);

    @Query("select u from User u where u.name = ?1")
    public List<RegisteredUser> findAllUsersByName(String name);
    public RegisteredUser findByPassword(String password);

    public List<RegisteredUser> findByNameAndSurnameAllIgnoringCase(String name, String surname);

    public Page<RegisteredUser> findAll(Pageable pageable);

}
