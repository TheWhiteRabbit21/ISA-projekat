package ISA.projekat.DTOs;

import ISA.projekat.Model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {
    private String date;
    private String time;
    private int duration;
    private int adminId;

    public AppointmentDTO() { super(); }

    public AppointmentDTO(String date, String time, int duration, int adminId) {
        super();
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.adminId = adminId;
    }
    public Appointment toModel(){
        String day = date.split("/")[0];
        String month = this.date.split("/")[1];
        String year = this.date.split("/")[2];
        LocalDate lDate =  LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        String hours = this.time.split(":")[0];
        String minutes = this.time.split(":")[1];
        LocalTime lTime =  LocalTime.of(Integer.parseInt(hours),Integer.parseInt(minutes));
        return new Appointment(lDate, lTime, duration);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
