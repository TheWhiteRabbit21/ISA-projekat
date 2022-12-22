package ISA.projekat.Service;

import java.util.ArrayList;
import java.util.List;

import ISA.projekat.DTOs.AppointmentDTO;
import ISA.projekat.Model.*;
import ISA.projekat.Repository.WorkCalendarRepository;
import org.springframework.stereotype.Service;

import ISA.projekat.DTOs.CenterAdminDTO;
import ISA.projekat.Model.enums.Gender;
//import ISA.projekat.Repository.AddressRepository;
import ISA.projekat.Repository.CenterAdminRepository;

@Service
public class CenterAdminService {
	
    private final CenterAdminRepository centerAdminRepository;
    private final WorkCalendarRepository workCalendarRepository;

    public CenterAdminService(CenterAdminRepository centerAdminRepository, WorkCalendarRepository workCalendarRepository) {
        this.centerAdminRepository = centerAdminRepository;
        this.workCalendarRepository = workCalendarRepository;
    }

    
    public void CreateCenterAdmin(CenterAdminDTO centerAdminDTO){
        Address address = new Address(centerAdminDTO.country, centerAdminDTO.city, centerAdminDTO.street, centerAdminDTO.number);
        centerAdminRepository.save(new Staff(centerAdminDTO.email,centerAdminDTO.password,centerAdminDTO.name,
                centerAdminDTO.surname, parseGender(centerAdminDTO.gender), centerAdminDTO.jmbg, address,centerAdminDTO.phoneNumber));
    }
    public List<CenterAdminDTO> GetAvailableAdmins(){
        List<CenterAdminDTO> admins = new ArrayList<CenterAdminDTO>();
        for(Staff admin : centerAdminRepository.findAllByBloodBankCenterIsNull()){
            admins.add(new CenterAdminDTO(admin.getId(),admin.getName(),admin.getSurname()));
        }
        return admins;
    }

    public List<AppointmentDTO> getAppointments(Integer id){
        List<AppointmentDTO> appointments = new ArrayList<AppointmentDTO>();
        Staff staff = centerAdminRepository.findById(id).get();
        WorkCalendar workCalendar = workCalendarRepository.findByBloodBankCenter(staff.getBloodBankCenter());
        for(Appointment appointment : workCalendar.getAppointments()){
            appointments.add(toDTO(appointment));
        }
        return appointments;
    }

    public Gender parseGender(String gender){
        if(gender.equals("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }

	public Staff findOne(int id) {
		return centerAdminRepository.findById(id).orElseGet(null);
	}

	public Staff Update(CenterAdminDTO centerAdminDTO, Staff staff) {
		
		Gender gender;
		
		if(centerAdminDTO.gender.equalsIgnoreCase("male")) {
			gender = Gender.MALE;
		}
		else if(centerAdminDTO.gender.equalsIgnoreCase("female")) {
			gender = Gender.FEMALE;
		}
		else {gender = Gender.OTHER;}
		
		Staff temp = new Staff(staff.getId(), centerAdminDTO.email, staff.getPassword(), centerAdminDTO.name, centerAdminDTO.surname,
			 gender, centerAdminDTO.jmbg, staff.getAddress(), centerAdminDTO.phoneNumber);
		
		return centerAdminRepository.save(temp);
		
	}

	public List<Staff> findAll() {
		return centerAdminRepository.findAll();
	}

    private AppointmentDTO toDTO(Appointment appointment){
        String subject = appointment.getUser().getName() + " " + appointment.getUser().getName();
        String startDate = appointment.getDate().toString() + "T" + appointment.getTime().toString() + ":00";
        String endDate = appointment.getDate().toString() + "T" + appointment.getTime().plusMinutes(appointment.getDuration()).toString() + ":00";
        return new AppointmentDTO(appointment.getId(), subject, startDate, endDate);
    }
}
