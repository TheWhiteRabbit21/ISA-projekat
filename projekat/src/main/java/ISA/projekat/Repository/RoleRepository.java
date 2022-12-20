package ISA.projekat.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ISA.projekat.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByName(String name);
}
