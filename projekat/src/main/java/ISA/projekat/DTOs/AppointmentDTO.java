package ISA.projekat.DTOs;

public class AppointmentDTO {
    public int Id;
    public String Subject;
    public String StartTime;
    public String EndTime;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int id, String subject, String startTime, String endTime) {
        Id = id;
        Subject = subject;
        StartTime = startTime;
        EndTime = endTime;
    }
}
