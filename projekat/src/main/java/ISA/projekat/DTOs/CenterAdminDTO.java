package ISA.projekat.DTOs;

public class CenterAdminDTO {
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
    public int jmbg;
    public String phoneNumber;

    public CenterAdminDTO(String name, String surname, String city, String country, String street, String number, String gender, String email, String password, int jmbg, String phoneNumber) {
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

    public CenterAdminDTO(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public CenterAdminDTO() {
    }
}
