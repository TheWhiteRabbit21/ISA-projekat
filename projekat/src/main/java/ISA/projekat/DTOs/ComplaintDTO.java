package ISA.projekat.DTOs;

public class ComplaintDTO {
    public Integer id;
    public String complaint;
    public String response;

    public ComplaintDTO() {
    }

    public ComplaintDTO(Integer id, String complaint) {
        this.id = id;
        this.complaint = complaint;
    }

}
