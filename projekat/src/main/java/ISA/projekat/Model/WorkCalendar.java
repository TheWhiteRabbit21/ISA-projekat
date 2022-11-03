package ISA.projekat.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class WorkCalendar implements Serializable{

	private Date workHourBegin;	//mozda ne date nego nesto drugo za pocetak i kraj radnog vremena.
	private Date workHourEnd;

	private List<Appointment> appointment;
	
	
}
