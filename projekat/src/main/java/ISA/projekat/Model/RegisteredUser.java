package ISA.projekat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

import ISA.projekat.Model.enums.UserCategory;

@Entity
@SuppressWarnings("serial")
public class RegisteredUser extends User {

	
	@Column(nullable = false)
	private Double points;
	
	@Column(nullable = false)
	private String userPerks;
	
	@Column(nullable = false)
	private String infoInstitution;
	
	@Column(nullable = false)
	private String profession;
	
	@Column(nullable = false)
	private UserCategory userCatagory;
	
	public RegisteredUser() {
		super();
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
	public void setUserCatagory(UserCategory userCatagory) {
		this.userCatagory = userCatagory;
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
				+ ", profession=" + profession + ", userCatagory=" + userCatagory + "]";
	}
	
	
	
	
	
	
}
