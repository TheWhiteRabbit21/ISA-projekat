package ISA.projekat.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ISA.projekat.Model.enums.Gender;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User implements Serializable, UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String username;
	
	@Column(nullable = true)
	private String password;
	
	@Column(nullable = true)
	private String name;
	
	@Column(nullable = true)
	private String surname;
	
	@Column(nullable = true)
	private Gender gender;
	
	@Column(nullable = true)
	private Integer jmbg;
	
	@Column(nullable = true)
    private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@Column(nullable = true)
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
	
	public User() {
		super();
	}
	
	public User(String email, String password, String name, String surname, Gender gender, Integer jmbg,

			Address address, String phoneNumber) {

		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	
	
	public User(Integer id, String email, String password, String name, String surname, Gender gender, int jmbg,
			Address address, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.jmbg = jmbg;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;

	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getJmbg() {
		return jmbg;
	}
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setRoles(List<Role> roles) {
	    this.roles = roles;
	}
	    
	public List<Role> getRoles() {
	    return roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", gender=" + gender + ", jmbg=" + jmbg + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// ovdje ce se dodati za registraciju da kad se posalje na mejl i stisne link onda se odobri
	@Override	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
	    this.enabled = enabled;
	}
}
