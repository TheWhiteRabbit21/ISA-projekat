package ISA.projekat.Repository;

import ISA.projekat.Model.Administrator;
import ISA.projekat.Model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

    @Query("select a.passwordChanged from Administrator a where a.id = ?1")
    public boolean checkIfPasswordChanged(int id);

}
