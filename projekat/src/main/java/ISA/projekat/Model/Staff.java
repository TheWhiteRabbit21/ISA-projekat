package ISA.projekat.Model;

import ISA.projekat.Model.enums.Gender;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("2")
public class Staff extends User {

	//private Set<Appointment> appointments = new HashSet<Appointment>(); 
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blood_bank_center_id")
	private BloodBankCenter center;*/

	public Staff(String email, String password, String name, String surname, Gender gender, int jmbg, int address, String phoneNumber) {
		super(email, password, name, surname, gender, jmbg, address, phoneNumber);
	}

	public Staff() {
		super();
	}

	public Staff(Integer id, String email, String password, String name, String surname, Gender gender, int jmbg,
			int address, String phoneNumber) {
		super(id, email, password, name, surname, gender, jmbg, address, phoneNumber);

	}
	
}
