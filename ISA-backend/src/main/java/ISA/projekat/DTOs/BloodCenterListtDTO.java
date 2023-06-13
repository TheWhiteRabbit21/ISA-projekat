package ISA.projekat.DTOs;

public class BloodCenterListtDTO {
    public int id;
    public String name;
    public double averagePoints;
    public String city;
    public String country;
    public String description;

    public BloodCenterListtDTO() {
    }

    public BloodCenterListtDTO(int id, String name, double averagePoints, String city, String country, String description) {
        this.id = id;
        this.name = name;
        this.averagePoints = averagePoints;
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
