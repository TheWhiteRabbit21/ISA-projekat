package ISA.projekat.DTOs;

public class BloodCenterListDTO {
    public String name;
    public double averagePoints;
    public String city;
    public String country;
    public String description;
    
    public BloodCenterListDTO() {}

	public BloodCenterListDTO(String name, double averagePoints, String city, String country, String description) {
		super();
		this.name = name;
		this.averagePoints = averagePoints;
		this.city = city;
		this.country = country;
		this.description = description;
	}
    
    
}
