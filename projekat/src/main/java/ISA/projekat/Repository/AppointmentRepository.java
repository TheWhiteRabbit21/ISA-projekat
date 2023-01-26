package ISA.projekat.Repository;

import ISA.projekat.DTOs.ReservationDTO;
import ISA.projekat.Model.Appointment;
import ISA.projekat.Model.WorkCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    public Appointment findByDateAndTime(String date, String time);
}
