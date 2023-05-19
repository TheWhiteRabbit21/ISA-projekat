package ISA.projekat.Service;

import ISA.projekat.Model.Administrator;
import ISA.projekat.Repository.AdminRepository;
import ISA.projekat.Repository.RoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void create(Administrator administrator){
        administrator.setEnabled(true);
        String password = administrator.getPassword();
        administrator.setPassword(passwordEncoder.encode(password));
        administrator.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        adminRepository.save(administrator);
    }

    public boolean checkIfPasswordChanged(int id){
        return adminRepository.checkIfPasswordChanged(id);
    }

    public int findIdByUsername(String username){
        if(adminRepository.findByUsername(username) != null){
            return adminRepository.findByUsername(username).getId();
        }
        return 0;
    }

    public void changePassword(int id, String password){
        Administrator administrator = adminRepository.findById(id).get();
        administrator.setPassword(passwordEncoder.encode(password));
        administrator.setPasswordChanged(true);
        adminRepository.save(administrator);
    }
}
