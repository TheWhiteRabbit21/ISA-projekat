package ISA.projekat.Repository;

import ISA.projekat.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    @Query("select c from Complaint c where c.response is null")
    Collection<Complaint> findByResponseIsNull();



    @Modifying
    @Query("update Complaint c set c.response = ?1 where c.id = ?2")
    void setResponse(String response, Integer id);
}
