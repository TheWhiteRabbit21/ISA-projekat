package ISA.projekat.Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BloodBankCenter implements Serializable{

	private String name;
	private String adress;
	private String description;
	private double averageRating;
	private int[] idAdministrators;
	private WorkCalendar workCalendar;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public int[] getIdAdministrators() {
		return idAdministrators;
	}
	public void setIdAdministrators(int[] idAdministrators) {
		this.idAdministrators = idAdministrators;
	}
	public WorkCalendar getWorkCalendar() {
		return workCalendar;
	}
	public void setWorkCalendar(WorkCalendar workCalendar) {
		this.workCalendar = workCalendar;
	}
	
	
}
