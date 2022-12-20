package ISA.projekat.Model;

import ISA.projekat.Model.enums.Gender;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("3")
public class Administrator extends User{

	@Column(nullable = true)
	private boolean passwordChanged;
	
	public Administrator() {
		super();
		this.passwordChanged = false;
	}

	public Administrator(String email, String password, String name, String surname, Gender gender, Integer jmbg, Address address, String phoneNumber, boolean passwordChanged) {
		super(email, password, name, surname, gender, jmbg, address, phoneNumber);
		this.passwordChanged = passwordChanged;
	}

	public boolean isPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}
}
