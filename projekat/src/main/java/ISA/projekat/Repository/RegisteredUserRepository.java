package ISA.projekat.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ISA.projekat.Model.RegisteredUser;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

	// User findByUsername(String username);

    public RegisteredUser findOneById(int id);

    RegisteredUser findByUsername(String username);

    @Query("select u from RegisteredUser u where u.surname = ?1")
    public List<RegisteredUser> findAllUsersBySurname(String surname);

    @Query("select u from RegisteredUser u where u.name = ?1")
    public List<RegisteredUser> findAllUsersByName(String name);
    public RegisteredUser findByPassword(String password);

    @Query("select u from RegisteredUser u where lower(u.name) like %?1% and lower(u.surname) like %?2% ")
    public List<RegisteredUser> findAllByNameAndSurnameIgnoreCase(String name, String surname);

    public Page<RegisteredUser> findAll(Pageable pageable);

}
