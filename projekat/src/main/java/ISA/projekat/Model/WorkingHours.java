package ISA.projekat.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class WorkingHours implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime workHourBegin;
	
	@Column(nullable = false)
	private LocalDateTime workHourEnd;

	/*@Column(nullable = false)
	private Set<Appointment> appointment;*/

	public WorkingHours() {
		super();
	}
	
	
	
	
	public LocalDateTime getWorkHourBegin() {
		return workHourBegin;
	}

	public void setWorkHourBegin(LocalDateTime workHourBegin) {
		this.workHourBegin = workHourBegin;
	}

	public LocalDateTime getWorkHourEnd() {
		return workHourEnd;
	}

	public void setWorkHourEnd(LocalDateTime workHourEnd) {
		this.workHourEnd = workHourEnd;
	}

	@Override
	public String toString() {
		return "WorkingHours [workHourBegin=" + workHourBegin + ", workHourEnd=" + workHourEnd + "]";
	}

	/*public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}*/
	
	
	
	
	
	
}
