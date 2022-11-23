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
	
	@Column(nullable = false)
	private boolean bloodPast;
	
	@Column(nullable = false)
	private boolean everRejected;
	
	@Column(nullable = false)
	private boolean feelHealthy;
	
	@Column(nullable = false)
	private boolean ateSomething;
	
	@Column(nullable = false)
	private boolean haveDangerousJob;
	
	@Column(nullable = false)
	private boolean regularlyTakeMedicine;
	
	@Column(nullable = false)
	private boolean takenMedicineInLast3Days;
	
	@Column(nullable = false)
	private boolean AspirinLast5Days;
	
	@Column(nullable = false)
	private boolean hospitalEverOrNow;
	
	@Column(nullable = false)
	private boolean takenToothOutInLast7Days;

	public BloodDonorInfo() {
		super();
	}

	public BloodDonorInfo(int id, boolean bloodPast, boolean everRejected, boolean feelHealthy, boolean ateSomething,
			boolean haveDangerousJob, boolean regularlyTakeMedicine, boolean takenMedicineInLast3Days,
			boolean aspirinLast5Days, boolean hospitalEverOrNow, boolean takenToothOutInLast7Days) {
		super();
		this.id = id;
		this.bloodPast = bloodPast;
		this.everRejected = everRejected;
		this.feelHealthy = feelHealthy;
		this.ateSomething = ateSomething;
		this.haveDangerousJob = haveDangerousJob;
		this.regularlyTakeMedicine = regularlyTakeMedicine;
		this.takenMedicineInLast3Days = takenMedicineInLast3Days;
		AspirinLast5Days = aspirinLast5Days;
		this.hospitalEverOrNow = hospitalEverOrNow;
		this.takenToothOutInLast7Days = takenToothOutInLast7Days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBloodPast() {
		return bloodPast;
	}

	public void setBloodPast(boolean bloodPast) {
		this.bloodPast = bloodPast;
	}

	public boolean isEverRejected() {
		return everRejected;
	}

	public void setEverRejected(boolean everRejected) {
		this.everRejected = everRejected;
	}

	public boolean isFeelHealthy() {
		return feelHealthy;
	}

	public void setFeelHealthy(boolean feelHealthy) {
		this.feelHealthy = feelHealthy;
	}

	public boolean isAteSomething() {
		return ateSomething;
	}

	public void setAteSomething(boolean ateSomething) {
		this.ateSomething = ateSomething;
	}

	public boolean isHaveDangerousJob() {
		return haveDangerousJob;
	}

	public void setHaveDangerousJob(boolean haveDangerousJob) {
		this.haveDangerousJob = haveDangerousJob;
	}

	public boolean isRegularlyTakeMedicine() {
		return regularlyTakeMedicine;
	}

	public void setRegularlyTakeMedicine(boolean regularlyTakeMedicine) {
		this.regularlyTakeMedicine = regularlyTakeMedicine;
	}

	public boolean isTakenMedicineInLast3Days() {
		return takenMedicineInLast3Days;
	}

	public void setTakenMedicineInLast3Days(boolean takenMedicineInLast3Days) {
		this.takenMedicineInLast3Days = takenMedicineInLast3Days;
	}

	public boolean isAspirinLast5Days() {
		return AspirinLast5Days;
	}

	public void setAspirinLast5Days(boolean aspirinLast5Days) {
		AspirinLast5Days = aspirinLast5Days;
	}

	public boolean isHospitalEverOrNow() {
		return hospitalEverOrNow;
	}

	public void setHospitalEverOrNow(boolean hospitalEverOrNow) {
		this.hospitalEverOrNow = hospitalEverOrNow;
	}

	public boolean isTakenToothOutInLast7Days() {
		return takenToothOutInLast7Days;
	}

	public void setTakenToothOutInLast7Days(boolean takenToothOutInLast7Days) {
		this.takenToothOutInLast7Days = takenToothOutInLast7Days;
	}
	
	
	
}
