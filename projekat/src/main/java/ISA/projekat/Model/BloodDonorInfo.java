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
	private boolean weight;
	
	@Column(nullable = false)
	private boolean skinIssues;
	
	@Column(nullable = false)
	private boolean feelHealthy;
	
	@Column(nullable = false)
	private boolean bloodPressure;
	
	@Column(nullable = false)
	private boolean menstruation;
	
	@Column(nullable = false)
	private boolean toothOutLast7Days;
	
	@Column(nullable = false)
	private boolean takenMedicineInLast7Days;
	
	@Column(nullable = false)
	private boolean piercingLast6Months;
	
	@Column(nullable = false)
	private boolean operationOrTransfusionLast6Months;
	
	@Column(nullable = false)
	private boolean tattooLast6Months;

	public BloodDonorInfo() {
		super();
	}

	public BloodDonorInfo(int id, boolean weight, boolean skinIssues, boolean feelHealthy, boolean bloodPressure,
			boolean menstruation, boolean toothOutLast7Days, boolean takenMedicineInLast7Days,
			boolean piercingLast6Months, boolean operationOrTransfusionLast6Months, boolean tattooLast6Months) {
		super();
		this.id = id;
		this.weight = weight;
		this.skinIssues = skinIssues;
		this.feelHealthy = feelHealthy;
		this.bloodPressure = bloodPressure;
		this.menstruation = menstruation;
		this.toothOutLast7Days = toothOutLast7Days;
		this.takenMedicineInLast7Days = takenMedicineInLast7Days;
		this.piercingLast6Months = piercingLast6Months;
		this.operationOrTransfusionLast6Months = operationOrTransfusionLast6Months;
		this.tattooLast6Months = tattooLast6Months;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isWeight() {
		return weight;
	}

	public void setWeight(boolean weight) {
		this.weight = weight;
	}

	public boolean isSkinIssues() {
		return skinIssues;
	}

	public void setSkinIssues(boolean skinIssues) {
		this.skinIssues = skinIssues;
	}

	public boolean isFeelHealthy() {
		return feelHealthy;
	}

	public void setFeelHealthy(boolean feelHealthy) {
		this.feelHealthy = feelHealthy;
	}

	public boolean isBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(boolean bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isMenstruation() {
		return menstruation;
	}

	public void setMenstruation(boolean menstruation) {
		this.menstruation = menstruation;
	}

	public boolean isToothOutLast7Days() {
		return toothOutLast7Days;
	}

	public void setToothOutLast7Days(boolean toothOutLast7Days) {
		this.toothOutLast7Days = toothOutLast7Days;
	}

	public boolean isTakenMedicineInLast7Days() {
		return takenMedicineInLast7Days;
	}

	public void setTakenMedicineInLast7Days(boolean takenMedicineInLast7Days) {
		this.takenMedicineInLast7Days = takenMedicineInLast7Days;
	}

	public boolean isPiercingLast6Months() {
		return piercingLast6Months;
	}

	public void setPiercingLast6Months(boolean piercingLast6Months) {
		this.piercingLast6Months = piercingLast6Months;
	}

	public boolean isOperationOrTransfusionLast6Months() {
		return operationOrTransfusionLast6Months;
	}

	public void setOperationOrTransfusionLast6Months(boolean operationOrTransfusionLast6Months) {
		this.operationOrTransfusionLast6Months = operationOrTransfusionLast6Months;
	}

	public boolean isTattooLast6Months() {
		return tattooLast6Months;
	}

	public void setTattooLast6Months(boolean tattooLast6Months) {
		this.tattooLast6Months = tattooLast6Months;
	}
}
