package ISA.projekat.DTOs;

public class UserDataDTO {
	public String role;
	public String username;
	
	public UserDataDTO() {
		super();
	}
	
	public UserDataDTO(String role, String username) {
		super();
		this.role = role;
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
