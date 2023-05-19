package ISA.projekat.Repository;

import ISA.projekat.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

    @Query("select a.passwordChanged from Administrator a where a.id = ?1")
    public boolean checkIfPasswordChanged(int id);

    Administrator findByUsername(String username);
}
