package ISA.projekat.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class BloodBankCenter implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = true)
	private double averageRating;
	//private WorkingHours workingHours;
	
	//private HashMap<String, Integer> blood;

	@OneToMany(mappedBy = "bloodBankCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Staff> staff = new HashSet<Staff>();

	public BloodBankCenter() {
		super();
	}
	
	public BloodBankCenter(String name, Address address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}

	public BloodBankCenter(Integer id, String name, Address address, String description, double averageRating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageRating = averageRating;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Staff> getAdministrators() {
		return staff;
	}

	public void setAdministrators(Set<Staff> stuff) {
		this.staff = stuff;
	}
}
