package ISA.projekat.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class WorkingHours implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(nullable = false)
//	private LocalDateTime workHourBeginDate;

	@Column(nullable = false)
	private String workHourBeginTime;

	
//	@Column(nullable = false)
//	private LocalDateTime workHourEndDate;


	@Column(nullable = false)
	private String workHourEndTime;

	/*@Column(nullable = false)
	private Set<Appointment> appointment;*/

	@OneToOne(mappedBy = "workingHours")
	private BloodBankCenter bloodBankCenter;

	public WorkingHours() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public LocalDateTime getWorkHourBeginDate() {
//		return workHourBeginDate;
//	}

//	public void setWorkHourBeginDate(LocalDateTime workHourBeginDate) {
//		this.workHourBeginDate = workHourBeginDate;
//	}

	public String  getWorkHourBeginTime() {
		return workHourBeginTime;
	}

	public void setWorkHourBeginTime(String workHourBeginTime) {
		this.workHourBeginTime = workHourBeginTime;
	}

//	public LocalDateTime getWorkHourEndDate() {
//		return workHourEndDate;
//	}

//	public void setWorkHourEndDate(LocalDateTime workHourEndDate) {
//		this.workHourEndDate = workHourEndDate;
//	}

	public String getWorkHourEndTime() {
		return workHourEndTime;
	}

	public void setWorkHourEndTime(String workHourEndTime) {
		this.workHourEndTime = workHourEndTime;
	}

	public BloodBankCenter getBloodBankCenter() {
		return bloodBankCenter;
	}

	public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
		this.bloodBankCenter = bloodBankCenter;
	}
	
	/*public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}*/
	
	
	
	
	
	
}
