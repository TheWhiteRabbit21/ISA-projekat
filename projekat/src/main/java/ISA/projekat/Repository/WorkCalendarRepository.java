package ISA.projekat.Repository;

import ISA.projekat.DTOs.ReservationDTO;
import ISA.projekat.Model.Appointment;
import ISA.projekat.Model.BloodBankCenter;
import ISA.projekat.Model.WorkCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface WorkCalendarRepository extends JpaRepository<WorkCalendar, Integer> {
    public WorkCalendar findByBloodBankCenter(BloodBankCenter bloodBankCenter);

}
