package ISA.projekat.Model;

import java.io.Serializable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class BloodBankCenter implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int address;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = true)
	private double averageRating;

	//private WorkingHours workingHours;
	
	//private HashMap<String, Integer> blood;

	//@OneToMany(mappedBy = "bloodBankCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Set<Staff> administrators = new HashSet<Staff>();

	public BloodBankCenter(String name, int address, String description) {
		this.name = name;
		this.address = address;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
