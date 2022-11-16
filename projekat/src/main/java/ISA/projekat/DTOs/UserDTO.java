package ISA.projekat.DTOs;

import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;

public class UserDTO {
    private Integer jmbg;
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    private int address;
    private String city;
    private String state;
    private String password;
    private String phoneNumber;


    public UserDTO() {

    }

    public UserDTO(User user) {
        this(user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getGender(), user.getJmbg(), user.getAddress(), user.getCity(), user.getState(), user.getPhoneNumber());
    }

    public UserDTO(String email, String password, String name, String surname, Gender gender, Integer jmbg, int address, String city, String state, String phoneNumber) {
        this.email=email;
        this.password=password;
        this.name =  name;
        this.surname = surname;
        this.gender = gender;
        this.jmbg = jmbg;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
