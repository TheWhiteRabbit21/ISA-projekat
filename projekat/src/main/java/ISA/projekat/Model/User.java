package ISA.projekat.Model;

import java.io.Serializable;

import javax.persistence.*;

import ISA.projekat.Model.enums.Gender;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String password;
	
	@Column(nullable = true)
	private String name;
	
	@Column(nullable = true)
	private String surname;
	
	@Column(nullable = true)
	private Gender gender;
	
	@Column(nullable = true)
	private Integer jmbg;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	
	@Column(nullable = true)
	private String phoneNumber;


	
	public User() {
		super();
	}
	
	public User(String email, String password, String name, String surname, Gender gender, Integer jmbg,

			Address address, String phoneNumber) {

		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	
	
	public User(Integer id, String email, String password, String name, String surname, Gender gender, int jmbg,
			Address address, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;

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
	public Integer getJmbg() {
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
				+ surname + ", gender=" + gender + ", jmbg=" + jmbg + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
