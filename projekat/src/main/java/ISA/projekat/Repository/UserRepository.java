package ISA.projekat.Repository;


import ISA.projekat.Model.RegisteredUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<RegisteredUser, Integer> {


    public RegisteredUser findOneById(int id);

    Optional<RegisteredUser> findByEmail(String email);


    @Query("select u from RegisteredUser u where u.surname = ?1")
    public List<RegisteredUser> findAllUsersBySurname(String surname);

    @Query("select u from RegisteredUser u where u.name = ?1")
    public List<RegisteredUser> findAllUsersByName(String name);
    public RegisteredUser findByPassword(String password);

    @Query("select u from RegisteredUser u where lower(u.name) like %?1% and lower(u.surname) like %?2% ")
    public List<RegisteredUser> findAllByNameAndSurnameIgnoreCase(String name, String surname);

    public Page<RegisteredUser> findAll(Pageable pageable);

    Optional<RegisteredUser> findById(int donorId);
    
}
