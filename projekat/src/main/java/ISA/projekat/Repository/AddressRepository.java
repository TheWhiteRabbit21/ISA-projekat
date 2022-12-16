package ISA.projekat.Repository;

import ISA.projekat.Model.Address;
//import ISA.projekat.Model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findById(int id);
}
