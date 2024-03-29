package ISA.projekat.Controller;

import javax.servlet.http.HttpServletResponse;

import ISA.projekat.Model.RegisteredUser;
import ISA.projekat.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import ISA.projekat.JwtAuthenticationRequest;
import ISA.projekat.ResourceConflictException;
import ISA.projekat.TokenUtils;
import ISA.projekat.UserTokenState;
import ISA.projekat.DTOs.RegisteredUserDTO;
import ISA.projekat.Model.Address;
import ISA.projekat.Model.User;
import ISA.projekat.Service.RegisteredUserService;
import ISA.projekat.Service.UserService;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private RegisteredUserService registeredUserService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmailSenderService emailSenderService;
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {
		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		// Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
		// kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String role = user.getRoles().get(0).getName();
		String jwt = tokenUtils.generateToken(user.getUsername(), role.substring(5));
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public Boolean signup(@RequestBody RegisteredUserDTO registeredUserDTO) {
		Boolean created = false;
		User existUser = userService.findByUsername(registeredUserDTO.getUsername());
		if (existUser == null) {
			Address address = new Address(registeredUserDTO.getState(), registeredUserDTO.getCity(), registeredUserDTO.getStreet(), registeredUserDTO.getNumber());
			registeredUserDTO.setPassword(passwordEncoder.encode(registeredUserDTO.getPassword()));
			// treba staviti da se uzme id od ovog registrovanog usera i da mu se stavi role_user
			registeredUserService.RegisterUser(registeredUserDTO, address);
			created = true;

			emailSenderService.sendSimpleEmail(registeredUserDTO.getUsername(),
					"Verifikacija naloga",
					"Molimo Vas kliknite na link da biste izvršili verifikaciju vašeg naloga: http://localhost:4200/email-verified/" + registeredUserDTO.getUsername());
		}
		return created;
	}

	@GetMapping("/verify-email/{email}")
	public Boolean verifyEmail(@PathVariable String email){
		RegisteredUser user = registeredUserService.findByUsername(email);
		if (user == null) {
			return false;
		}
		user.setEnabled(true);
		registeredUserService.save(user);
		return true;
	}
}