package ISA.projekat.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import ISA.projekat.Model.enums.UserCategory;
import org.hibernate.annotations.DiscriminatorFormula;

import java.io.Serial;
import java.io.Serializable;

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
