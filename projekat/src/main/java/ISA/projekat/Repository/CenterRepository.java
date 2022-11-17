package ISA.projekat.Repository;

import ISA.projekat.Model.BloodBankCenter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<BloodBankCenter, Integer> {
	public Page<BloodBankCenter> findAll(Pageable pageable);
}
