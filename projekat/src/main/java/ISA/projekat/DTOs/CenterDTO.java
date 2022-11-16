package ISA.projekat.DTOs;

public class CenterDTO {
    public String name;
    public String city;
    public String country;
    public String street;
    public String number;
    public String description;
    public CenterDTO(){

    }
    public CenterDTO(String name, String city, String country, String street, String number, String description) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.description = description;
    }
}
