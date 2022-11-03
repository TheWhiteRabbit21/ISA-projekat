package ISA.projekat.Model;

import ISA.projekat.Model.enums.UserCategory;

@SuppressWarnings("serial")
public class RegisteredUser extends User {

	private String points;
	private UserCategory userCatagory;
	private String userPerks;
	private String infoInstitution;
	private String profession;
	
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
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
	
	
}
