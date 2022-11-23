package ISA.projekat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodDonorInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true)
	private boolean bloodPast;
	
	@Column(nullable = true)
	private boolean everRejected;
	
	@Column(nullable = true)
	private boolean feelHealthy;
	
	@Column(nullable = true)
	private boolean ateSomething;
	
	@Column(nullable = true)
	private boolean haveDangerousJob;
	
	@Column(nullable = true)
	private boolean regularlyTakeMedicine;
	
	@Column(nullable = true)
	private boolean takenMedicineInLast3Days;
	
	@Column(nullable = true)
	private boolean AspirinLast5Days;
	
	@Column(nullable = true)
	private boolean hospitalEverOrNow;
	
	@Column(nullable = true)
	private boolean takenToothOutInLast7Days;
}
