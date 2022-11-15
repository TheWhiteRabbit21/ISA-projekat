package ISA.projekat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import ISA.projekat.Model.enums.Gender;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private Gender gender;
	
	@Column(nullable = false)
	private int jmbg;
	
	@Column(nullable = false)
	private String adress;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	
	public User() {
		super();
	}
	
	public User(String email, String password, String name, String surname, Gender gender, int jmbg,
			String adress, String city, String state, String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
	}

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
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", gender=" + gender + ", jmbg=" + jmbg + ", adress=" + adress + ", city=" + city
				+ ", state=" + state + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
	
}
