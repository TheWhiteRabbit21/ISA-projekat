package ISA.projekat.Repository;

import ISA.projekat.Model.BloodBankCenter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<BloodBankCenter, Integer> {
	public Page<BloodBankCenter> findAll(Pageable pageable);

	@Query("select b from BloodBankCenter b where b.name like %?1% and b.address.city like %?2%")
	public List<BloodBankCenter> findAllByNameAndCity(String name,String city);

}
