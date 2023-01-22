package ISA.projekat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.projekat.Model.AppointmentHistory;
import ISA.projekat.Model.BloodDonorInfo;
import ISA.projekat.Repository.AppointmentHistoryRepository;
import ISA.projekat.Repository.BloodDonorInfoRepository;

@Service
public class BloodDonorInfoService {

	 @Autowired
	 private BloodDonorInfoRepository bloodDonorInfoRepository;
	 
	 @Autowired AppointmentHistoryRepository appointmentHistoryRepository;
	 
	 public List<BloodDonorInfo> findAll(){
	        return bloodDonorInfoRepository.findAll();
	 }
	 
	 public void Create(BloodDonorInfo bloodDonorInfo){
		 	bloodDonorInfoRepository.save(bloodDonorInfo);
	 }

	public BloodDonorInfo findByDonorId(int id) {
		
		List<BloodDonorInfo> bdia = bloodDonorInfoRepository.findAll();
		
		BloodDonorInfo temp = new BloodDonorInfo();
		
		for(BloodDonorInfo bdi : bdia) {
			if(bdi.getId() == id) {
				temp = bdi;
			}
		}
		
		return temp;
	}

	public List<AppointmentHistory> findAppointmentHistoryById(int id) {

		List<AppointmentHistory> temp = new ArrayList<>();
		temp = appointmentHistoryRepository.findAll();
		
		List<AppointmentHistory> res = new ArrayList<>();
		
		for(AppointmentHistory ah : temp) {
			if(ah.getDonorId() == id) {
				res.add(ah);
			}
		}
		
		return res;
	}

	public void CreateAppointmentHistory(AppointmentHistory ah) {
		appointmentHistoryRepository.save(ah);
	}
	 
}
