package ISA.projekat.Repository;

import ISA.projekat.Model.PredefinedAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredefinedAppointmentsRepository extends JpaRepository<PredefinedAppointments, Integer> {
}
