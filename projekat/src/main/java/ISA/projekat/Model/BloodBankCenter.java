package ISA.projekat.Model;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class BloodBankCenter implements Serializable{

	private String name;
	private String adress;
	private String description;
	private double averageRating;
	private int[] idAdministrators;
	private WorkingHours workingHours;
	private HashMap<String, Integer> blood;
	
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
	public WorkingHours getWorkCalendar() {
		return workingHours;
	}
	public void setWorkCalendar(WorkingHours workCalendar) {
		this.workingHours = workCalendar;
	}
	public HashMap<String, Integer> getBlood() {
		return blood;
	}
	public void setBlood(HashMap<String, Integer> blood) {
		this.blood = blood;
	}
	
	
}
