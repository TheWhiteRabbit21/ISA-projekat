package ISA.projekat.Model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Appointment implements Serializable{

	private int[] idStaff;
	private Date dateBegin;	//datum i tacno vreme termina pregleda, isto mozda ne date.
	private Date dateEnd;	//Also ili trajanje da se ubaci kao polje, ili da ima samo dateEnd do kad traje termin.
	private boolean taken;
	
	public int[] getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int[] idStaff) {
		this.idStaff = idStaff;
	}
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
	
	
	
	
}
