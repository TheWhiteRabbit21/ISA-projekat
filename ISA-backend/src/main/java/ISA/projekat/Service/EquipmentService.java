package ISA.projekat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.projekat.Model.Equipment;
import ISA.projekat.Repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	
	public void updateEquipment(String kolicinaKrviDataML, String brojIgala) {

		List<Equipment> equipment = new ArrayList<>();
		equipment = equipmentRepository.findAll();
		
		for(Equipment e : equipment) {
			
			int bloodQuantity = e.getBloodQuantity();
			bloodQuantity += Integer.parseInt(kolicinaKrviDataML);
			e.setBloodQuantity(bloodQuantity);
			
			int needles = e.getNeedles();
			needles -= Integer.parseInt(brojIgala);
			e.setNeedles(needles);
			
			equipmentRepository.save(e);
		}
		
	}

}
