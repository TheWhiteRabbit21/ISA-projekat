package ISA.projekat.DTOs;

import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.User;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Model.enums.UserCategory;

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

    private double points;

    private UserCategory user_catagory;
    public UserDTO() {

    }

    public UserDTO(RegisteredUser user) {
        this(user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getGender(), user.getJmbg(), user.getAddress(), user.getCity(), user.getState(), user.getPhoneNumber(), user.getPoints(),user.getUserCatagory());
    }

    public UserDTO(String email, String password, String name, String surname, Gender gender, Integer jmbg, int address, String city, String state, String phoneNumber, double points, UserCategory user_catagory) {
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
        this.points = points;
        this.user_catagory = user_catagory;
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

    public double getPoints() {return  points;}

    public UserCategory getCatagory(){ return user_catagory;}
}
