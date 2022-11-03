package ISA.projekat.Model;

import java.io.Serializable;

import ISA.projekat.Model.enums.Gender;

@SuppressWarnings("serial")
public class User implements Serializable{

	private String name;
	private String surname;
	private String password;
	private String adress;
	private String city;
	private String state;
	private String phoneNumber;
	private String email;
	private int jmbg;
	private Gender gender;
	private String profession;
	private String infoInstitution;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getJmbg() {
		return jmbg;
	}
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getInfoInstitution() {
		return infoInstitution;
	}
	public void setInfoInstitution(String infoInstitution) {
		this.infoInstitution = infoInstitution;
	}
	
	
	
	
	
	
}
