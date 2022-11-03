package ISA.projekat.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
public class WorkingHours implements Serializable{

	private LocalDateTime workHourBegin;
	private LocalDateTime workHourEnd;

	private List<Appointment> appointment;

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

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
}
