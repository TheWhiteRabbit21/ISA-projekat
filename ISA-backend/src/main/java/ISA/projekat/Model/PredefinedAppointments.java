package ISA.projekat.Model;

import ISA.projekat.Model.enums.Availability;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class PredefinedAppointments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private LocalDate date;

    @Column(nullable = true)
    private LocalTime time;

    @Column(nullable = true)
    private int duration;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private int centerId;

    @Column(nullable = true)
    private Availability availability;

    public PredefinedAppointments() {}

    public PredefinedAppointments(LocalDate date, LocalTime time, int duration, String username, int centerId, Availability availability) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.username = username;
        this.centerId = centerId;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
