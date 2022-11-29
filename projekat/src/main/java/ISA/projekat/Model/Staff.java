package ISA.projekat.Model;

import ISA.projekat.Model.enums.Gender;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("2")

public class Staff extends User {

	//private Set<Appointment> appointments = new HashSet<Appointment>(); 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bloodBankCenter_id")
	private BloodBankCenter bloodBankCenter;

	public Staff(String email, String password, String name, String surname, Gender gender, int jmbg, Address address, String phoneNumber) {
		super(email, password, name, surname, gender, jmbg, address, phoneNumber);
	}

	public Staff() {
		super();
	}

	public BloodBankCenter getBloodBankCenter() {
		return bloodBankCenter;
	}

	public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
		this.bloodBankCenter = bloodBankCenter;
	}

	public Staff(int id, String email, String password, String name, String surname, Gender gender, int jmbg,
			Address address, String phoneNumber) {
		super(id, email, password, name, surname, gender, jmbg, address, phoneNumber);

	}
}
