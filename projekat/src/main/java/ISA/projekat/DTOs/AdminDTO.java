package ISA.projekat.DTOs;

import ISA.projekat.Model.Address;
import ISA.projekat.Model.Administrator;
import ISA.projekat.Model.enums.Gender;

public class AdminDTO {
    public int id;
    public String name;
    public String surname;
    public String city;
    public String country;
    public String street;
    public String number;
    public String gender;
    public String email;
    public String password;
    public Integer jmbg;
    public String phoneNumber;

    public AdminDTO(String name, String surname, String city, String country, String street, String number, String gender, String email, String password, Integer jmbg, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.jmbg = jmbg;
        this.phoneNumber = phoneNumber;
    }

    public AdminDTO() {

    }
    public Administrator toModel(){
        return new Administrator(this.email, this.password, this.name, this.surname, parseGender(this.gender),
        this.jmbg, new Address(this.country, this.city, this.street, this.number), this.phoneNumber, false);
    }
    public Gender parseGender(String gender){
        if(gender.equals("Male"))return Gender.MALE;
        else return Gender.FEMALE;
    }

}
