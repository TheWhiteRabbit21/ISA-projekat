package ISA.projekat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISA.projekat.Model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{

	public List<Equipment> findAll();
	
	
	
	
	
	
	
	
	
}
