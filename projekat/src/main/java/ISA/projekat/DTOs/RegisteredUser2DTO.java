package ISA.projekat.DTOs;

import ISA.projekat.Model.Address;
import ISA.projekat.Model.enums.Gender;

public class RegisteredUser2DTO {

	private int id;
    private String email;
    private String password;
    private String name;
    private String surname;

    private Address address;
    private String phoneNumber;
    private Integer jmbg;
    private Gender gender;
    private String occupation;
    private String establishmentInfo;
    private String points;
    private String user_catagory;

    public RegisteredUser2DTO() {
        super();
    }

    public RegisteredUser2DTO(int id, String email, String password, String name, String surname, Address address, String phoneNumber, Integer jmbg, Gender gender, String occupation,
                             String establishmentInfo, String points,String user_catagory) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.occupation = occupation;
        this.establishmentInfo = establishmentInfo;
        this.points = points;
        this.user_catagory = user_catagory;
    }

    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
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

    public String getPoints() {
        return points;
    }

    public String getUser_catagory() {
        return user_catagory;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setUser_catagory(String user_catagory) {
        this.user_catagory = user_catagory;
    }
}
