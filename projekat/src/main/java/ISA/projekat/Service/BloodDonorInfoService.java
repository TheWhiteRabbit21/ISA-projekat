package ISA.projekat.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.projekat.Model.BloodDonorInfo;
import ISA.projekat.Repository.BloodDonorInfoRepository;

@Service
public class BloodDonorInfoService {

	 @Autowired
	 private BloodDonorInfoRepository bloodDonorInfoRepository;
	 
	 public List<BloodDonorInfo> findAll(){
	        return bloodDonorInfoRepository.findAll();
	 }
	 
	 public void Create(BloodDonorInfo bloodDonorInfo){
		 	bloodDonorInfoRepository.save(bloodDonorInfo);
	 }
	 
}
