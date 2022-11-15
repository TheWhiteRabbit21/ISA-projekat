package ISA.projekat.Repository;

import ISA.projekat.Model.BloodBankCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<BloodBankCenter, Integer> {
}
