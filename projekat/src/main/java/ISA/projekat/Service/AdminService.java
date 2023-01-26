package ISA.projekat.Service;

import ISA.projekat.Model.Administrator;
import ISA.projekat.Repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void create(Administrator administrator){
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
        administrator.setPassword(password);
        administrator.setPasswordChanged(true);
        adminRepository.save(administrator);
    }
}
