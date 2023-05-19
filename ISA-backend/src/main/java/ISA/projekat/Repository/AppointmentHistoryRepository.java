package ISA.projekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISA.projekat.Model.AppointmentHistory;

@Repository
public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Integer> {

}
