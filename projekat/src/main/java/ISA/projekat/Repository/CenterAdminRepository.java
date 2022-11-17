package ISA.projekat.Repository;

import ISA.projekat.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterAdminRepository extends JpaRepository<Staff, Integer> {

}
