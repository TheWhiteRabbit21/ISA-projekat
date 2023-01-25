package ISA.projekat.DTOs;

import ISA.projekat.Model.enums.Gender;

public class RegisteredUserDTO {
		private Long id;
		private String email;
		private String password;
	    private String name;
	    private String surname;
	    private String street;
	    private String number;
	    private String city;
	    private String state;
	    private String phoneNumber;
	    private Integer jmbg;
	    private Gender gender;
	    private String occupation;
	    private String establishmentInfo;
	    
		public RegisteredUserDTO() {
			super();
		}

		public RegisteredUserDTO(String email, String password, String name, String surname, String street, String number,
				String city, String state, String phoneNumber, Integer jmbg, Gender gender, String occupation,
				String establishmentInfo) {
			super();
			this.email = email;
			this.password = password;
			this.name = name;
			this.surname = surname;
			this.street = street;
			this.number = number;
			this.city = city;
			this.state = state;
			this.phoneNumber = phoneNumber;
			this.jmbg = jmbg;
			this.gender = gender;
			this.occupation = occupation;
			this.establishmentInfo = establishmentInfo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
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

		public Integer getJmbg() {
			return jmbg;
		}

		public void setJmbg(Integer jmbg) {
			this.jmbg = jmbg;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public String getEstablishmentInfo() {
			return establishmentInfo;
		}

		public void setEstablishmentInfo(String establishmentInfo) {
			this.establishmentInfo = establishmentInfo;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
    
}
