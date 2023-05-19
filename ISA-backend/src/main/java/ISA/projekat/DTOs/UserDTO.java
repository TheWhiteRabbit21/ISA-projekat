package ISA.projekat.DTOs;


//import ISA.projekat.Model.RegisteredUser;
//import ISA.projekat.Model.enums.UserCategory;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.User;


public class UserDTO {
	public int id;
	public String name;
	public String surname;
	public String email;
	public String gender;
	public String jmbg;
	public int role;
	public String state;
	public String city;
	public String street;
	public String streetNumber;
	public String password;
	public String phoneNumber;


	public UserDTO(int id, String name, String surname, String email, String gender, String jmbg, String state, String city, String street, String streetNumber, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
		this.jmbg = jmbg;
		this.state = state;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.phoneNumber = phoneNumber;
	}

	public UserDTO() {

    }



    public UserDTO(User user, Address address) {
    	this(user.getId(), user.getName(), user.getSurname(), user.getUsername(), user.getGender().toString(), user.getJmbg(), address.getCountry()
				, address.getCity(), address.getStreet(), address.getNumber(), user.getPhoneNumber());
	}
    
    
//	public int getId() {
//		return id;
//	}






}

