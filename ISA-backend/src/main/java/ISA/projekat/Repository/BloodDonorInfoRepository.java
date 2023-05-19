package ISA.projekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISA.projekat.Model.BloodDonorInfo;

@Repository
public interface BloodDonorInfoRepository extends JpaRepository<BloodDonorInfo, Integer> {

}
