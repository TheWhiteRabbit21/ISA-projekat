package ISA.projekat.DTOs;

public class CenterDTO {
	public String id;
    public String name;
    public String city;
    public String country;
    public String street;
    public String number;
    public String description;
    
    
    public CenterDTO(){

    }
    
    public CenterDTO(String id, String name, String city, String country, String street, String number, String description) {
        this.id = id;
    	this.name = name;
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.description = description;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
    
}
