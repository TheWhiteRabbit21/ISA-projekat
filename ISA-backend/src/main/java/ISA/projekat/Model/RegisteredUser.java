package ISA.projekat.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;

import java.util.List;


@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("1")
public class RegisteredUser extends User {

	
	@Column(nullable = true)
	private Double points;
	
	@Column(nullable = true)
	private int penals;

	@Column(nullable = true)
	private String userPerks;
	
	@Column(nullable = true)
	private String infoInstitution;
	
	@Column(nullable = true)
	private String profession;
	
	@Column(nullable = true)
	private UserCategory userCatagory;
	
	@OneToOne(mappedBy = "user")
	private Appointment appointment;

	@OneToOne(mappedBy = "registeredUser")
	private Complaint complaint;

	public RegisteredUser() {
		super();
	}
	
	
	public RegisteredUser(String username, String password, String name, String surname, Gender gender, String jmbg,
						  Address address, String phoneNumber, Double points, String userPerks, String infoInstitution, String profession,
						  UserCategory userCatagory, int penals) {
		super(username, password, name, surname, gender, jmbg, address, phoneNumber);
		this.points = points;
		this.userPerks = userPerks;
		this.infoInstitution = infoInstitution;
		this.profession = profession;
		this.userCatagory = userCatagory;
		this.penals = penals;
		}

	public RegisteredUser(String username, String password, String name, String surname, Gender gender, String jmbg,
						  Address address, String phoneNumber, List<Role> roles, Double points, String userPerks, String infoInstitution, String profession,
						  UserCategory userCatagory, int penals) {
		super(username, password, name, surname, gender, jmbg, address, phoneNumber, roles);
		this.points = points;
		this.userPerks = userPerks;
		this.infoInstitution = infoInstitution;
		this.profession = profession;
		this.userCatagory = userCatagory;
		this.penals = penals;
	}



	public int getPenals() {
		return penals;
	}



	public void setPenals(int penals) {
		this.penals = penals;
	}



	public Appointment getAppointment() {
		return appointment;
	}



	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	public void setUserCatagory(UserCategory userCatagory) {
		this.userCatagory = userCatagory;
	}



	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	public UserCategory getUserCatagory() {
		return userCatagory;
	}
	public void setUserCatagory(String userCatagory) {
		if(userCatagory.equals("BRONZE")){
			this.userCatagory = UserCategory.BRONZE;
		} else if(userCatagory.equals("SILVER")){
			this.userCatagory = UserCategory.SILVER;
		} else {
		this.userCatagory = UserCategory.GOLD;
		}

	}
	public String getUserPerks() {
		return userPerks;
	}
	public void setUserPerks(String userPerks) {
		this.userPerks = userPerks;
	}
	public String getInfoInstitution() {
		return infoInstitution;
	}
	public void setInfoInstitution(String infoInstitution) {
		this.infoInstitution = infoInstitution;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "RegisteredUser [points=" + points + ", userPerks=" + userPerks + ", infoInstitution=" + infoInstitution
				+ ", profession=" + profession + ", userCatagory=" + userCatagory + ", name="+  "]";
	}
	
	
	
	
	
	
}
