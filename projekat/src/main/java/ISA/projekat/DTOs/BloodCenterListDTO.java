package ISA.projekat.DTOs;

public class BloodCenterListDTO {
    public String name;
    public double averagePoints;
    public int address;
    public String description;
    
    public BloodCenterListDTO() {}

	public BloodCenterListDTO(String name, double averagePoints, int address, String description) {
		super();
		this.name = name;
		this.averagePoints = averagePoints;
		this.address = address;
		this.description = description;
	}
    
    
}
