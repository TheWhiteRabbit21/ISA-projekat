package ISA.projekat.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Appointment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Date dateBegin;	//datum i tacno vreme termina pregleda, isto mozda ne date.
	
	@Column(nullable = false)
	private Date dateEnd;	//Also ili trajanje da se ubaci kao polje, ili da ima samo dateEnd do kad traje termin.
	
	@Column(nullable = false)
	private boolean taken;
	
	
	/*@ManyToMany(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Staff> staffs = new HashSet<Staff>();*/
	
	public Appointment() {
		super();
	}
	
	public Appointment(Date dateBegin, Date dateEnd, boolean taken/*, Set<Staff> staffs*/) {
		super();
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.taken = taken;
		//this.staffs = staffs;
	}


	/*public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}*/
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	@Override
	public String toString() {
		return "Appointment [dateBegin=" + dateBegin + ", dateEnd=" + dateEnd + ", taken=" + taken + "]";
	}

	
	/*public void addStaff(Staff staff) {
		staffs.add(staff);
		//staff.setAppointment(this);
	}
	
	public void removeStaff(Staff staff) {
		staffs.remove(staff);
		//staff.setAppointment(null);
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
