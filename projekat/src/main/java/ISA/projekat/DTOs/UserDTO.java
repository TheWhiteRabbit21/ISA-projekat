package ISA.projekat.DTOs;


import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Model.enums.UserCategory;

public class UserDTO {
	public String id;
	public String name;
	public String surname;
	public String email;
	public String gender;
	public String jmbg;
	public String state;
	public String city;
	public String street;
	public String streetNumber;
	public String password;
	public String phoneNumber;

	public String points;

	public String user_catagory;

	public UserDTO() {

	}
    
    /*public UserDTO(User user) {
    this(user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getGender(), user.getJmbg(), user.getAddress(), user.getCity(), user.getState(), user.getPhoneNumber());
	}*/




	public UserDTO(String email, String password, String name, String surname, String gender, String jmbg, String city, String state, String phoneNumber, String points, String user_catagory) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.points = points;
		this.user_catagory = user_catagory;
	}

	public UserDTO(RegisteredUser u) {
	}
}