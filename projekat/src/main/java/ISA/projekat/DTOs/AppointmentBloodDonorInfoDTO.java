package ISA.projekat.DTOs;

import ISA.projekat.Model.BloodDonorInfo;
import ISA.projekat.Model.RegisteredUser;

public class AppointmentBloodDonorInfoDTO {

	public String name;
	public String surname;
	public String gender;
	
	public String weight;
	public String healthy;
	public String skinIssues;
	public String bloodPressure;
	public String underMedicationLast7Days;
	public String femalePeriod;
	public String toothOutLast7Days;
	public String piercingLast6Months;
	public String operationOrTransfusionLast6Months;
	public String tattooLast6Months;
	
	
	public AppointmentBloodDonorInfoDTO() {
		
	}


	public AppointmentBloodDonorInfoDTO(RegisteredUser u, BloodDonorInfo bdi) {

		this.name = u.getName();
		this.surname = u.getSurname();
		this.gender = u.getGender().toString();
		
		if(bdi.isWeight()) {this.weight = "Yes";}
		else {this.weight = "No";}
		
		if(bdi.isFeelHealthy()) {this.healthy = "Yes";}
		else {this.healthy = "No";}
		
		if(bdi.isSkinIssues()) {this.skinIssues = "Yes";}
		else {this.skinIssues = "No";}
		
		if(bdi.isBloodPressure()) {this.bloodPressure = "Yes";}
		else {this.bloodPressure = "No";}
		
		if(bdi.isTakenMedicineInLast7Days()) {this.underMedicationLast7Days = "Yes";}
		else {this.underMedicationLast7Days = "No";}

		if(bdi.isMenstruation()) {this.femalePeriod = "Yes";}
		else {this.femalePeriod = "No";}
		
		if(bdi.isToothOutLast7Days()) {this.toothOutLast7Days = "Yes";}
		else {this.toothOutLast7Days = "No";}

		if(bdi.isPiercingLast6Months()) {this.piercingLast6Months = "Yes";}
		else {this.piercingLast6Months = "No";}
		
		if(bdi.isOperationOrTransfusionLast6Months()) {this.operationOrTransfusionLast6Months = "Yes";}
		else {this.operationOrTransfusionLast6Months = "No";}
		
		if(bdi.isTattooLast6Months()) {this.tattooLast6Months = "Yes";}
		else {this.tattooLast6Months = "No";}
	}
	
	
	
}
