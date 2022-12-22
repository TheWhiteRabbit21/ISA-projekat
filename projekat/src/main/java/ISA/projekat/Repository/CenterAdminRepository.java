package ISA.projekat.Repository;

//import ISA.projekat.Model.BloodBankCenter;
//import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterAdminRepository extends JpaRepository<Staff, Integer> {
    public List<Staff> findAllByBloodBankCenterIsNull();


    public Staff findStaffById(int id);
}
