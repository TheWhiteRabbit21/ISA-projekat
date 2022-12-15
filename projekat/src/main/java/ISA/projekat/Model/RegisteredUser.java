package ISA.projekat.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;


@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("1")
public class RegisteredUser extends User {

	
	@Column(nullable = true)
	private Double points;
	
	@Column(nullable = true)
	private String userPerks;
	
	@Column(nullable = true)
	private String infoInstitution;
	
	@Column(nullable = true)
	private String profession;
	
	@Column(nullable = true)
	private UserCategory userCatagory;

	@OneToOne(mappedBy = "Appointment")
	private Appointment appointment;
	
	public RegisteredUser() {
		super();
	}
	
	
	
	public RegisteredUser(String email, String password, String name, String surname, Gender gender, int jmbg,
			Address address, String phoneNumber, Double points, String userPerks, String infoInstitution, String profession,
			UserCategory userCatagory) {
		super(email, password, name, surname, gender, jmbg, address, phoneNumber);
		this.points = points;
		this.userPerks = userPerks;
		this.infoInstitution = infoInstitution;
		this.profession = profession;
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
