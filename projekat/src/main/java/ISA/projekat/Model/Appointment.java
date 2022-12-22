package ISA.projekat.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Appointment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private LocalTime time;

	@Column(nullable = false)
	private int duration;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	private RegisteredUser user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = true)
	private Staff staff;

	@Column(nullable = false)
	private boolean taken;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "workCalendar_id")
	private WorkCalendar workCalendar;

	public Appointment() {
		super();
	}
	
	public Appointment(LocalDate date, LocalTime time, int duration) {
		super();
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.taken = false;
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
	public int getId() {
		return id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public RegisteredUser getUser() {
		return user;
	}
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkCalendar getWorkCalendar() {
		return workCalendar;
	}

	public void setWorkCalendar(WorkCalendar workCalendar) {
		this.workCalendar = workCalendar;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"date=" + date +
				", time=" + time +
				", duration=" + duration +
				", user=" + user +
				", taken=" + taken +
				'}';
	}
}
