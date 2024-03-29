package ISA.projekat.Repository;


import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Model.WorkCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkCalendarRepository extends JpaRepository<WorkCalendar, Integer> {

    WorkCalendar findByBloodBankCenter(BloodBankCenter bloodBankCenter);

}
