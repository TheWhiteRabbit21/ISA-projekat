package ISA.projekat.DTOs;

public class AppointmentCalendarDTO {
    public int Id;
    public String Subject;
    public String StartTime;
    public String EndTime;

    public AppointmentCalendarDTO() {
    }

    public AppointmentCalendarDTO(int id, String subject, String startTime, String endTime) {
        Id = id;
        Subject = subject;
        StartTime = startTime;
        EndTime = endTime;
    }
}
