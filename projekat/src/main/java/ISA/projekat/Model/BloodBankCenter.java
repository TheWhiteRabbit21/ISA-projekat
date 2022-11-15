package ISA.projekat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class BloodBankCenter implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String addressId;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double averageRating;
	
	
	//private WorkingHours workingHours;
	
	//private HashMap<String, Integer> blood;
	
	//private Set<Administrator> administrators;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdressId() {
		return addressId;
	}
	public void setAdressId(String adress) {
		this.addressId = adress;
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
	
	
	
}
