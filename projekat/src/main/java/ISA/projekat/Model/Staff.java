package ISA.projekat.Model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Staff extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//private Set<Appointment> appointments = new HashSet<Appointment>(); 
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blood_bank_center_id")
	private BloodBankCenter center;*/
	
	public Staff() {
		super();
	}
	
	
}
