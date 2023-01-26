package ISA.projekat.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ISA.projekat.DTOs.AppointmentCalendarDTO;
import ISA.projekat.DTOs.AppointmentDTO;
import ISA.projekat.Model.*;
import ISA.projekat.Repository.CenterRepository;
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

    private final CenterRepository bloodBankCenterRepository;
    public CenterAdminService(CenterAdminRepository centerAdminRepository, CenterRepository bloodBankCenterRepository, WorkCalendarRepository workCalendarRepository) {
        this.centerAdminRepository = centerAdminRepository;
//        this.addressRepository = addressRepository;
        this.bloodBankCenterRepository = bloodBankCenterRepository;
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

    public List<AppointmentCalendarDTO> getAppointments(Integer id){
        List<AppointmentCalendarDTO> appointments = new ArrayList<AppointmentCalendarDTO>();
        Staff staff = centerAdminRepository.findById(id).get();
        WorkCalendar workCalendar = workCalendarRepository.findByBloodBankCenter(staff.getBloodBankCenter());
        for(Appointment appointment : workCalendar.getAppointments()){
            appointments.add(toDTO(appointment));
        }
        return appointments;
    }
    public int findIdByUsername(String username){
        if(centerAdminRepository.findByUsername(username) != null){
            return centerAdminRepository.findByUsername(username).getId();
        }
        return 0;
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

    private AppointmentCalendarDTO toDTO(Appointment appointment){
            String subject = appointment.getUser().getName() + " " + appointment.getUser().getName();
            String startDate = appointment.getDate().toString() + "T" + appointment.getTime().toString() + ":00";
            String endDate = appointment.getDate().toString() + "T" + appointment.getTime().plusMinutes(appointment.getDuration()).toString() + ":00";
            return new AppointmentCalendarDTO(appointment.getId(), subject, startDate, endDate);
    }
    public boolean defineNewAppointment(AppointmentDTO appointmentDTO){
        Staff staff = centerAdminRepository.findStaffById(appointmentDTO.getAdminId());
        BloodBankCenter bloodBankCenter = staff.getBloodBankCenter();
        WorkCalendar workCalendar = workCalendarRepository.findByBloodBankCenter(bloodBankCenter);
        String hours = appointmentDTO.getTime().split(":")[0];
        String minutes = appointmentDTO.getTime().split(":")[1];
        String hours2 = bloodBankCenter.getWorkingHours().getWorkHourBeginTime().split(":")[0];
        String minutes2 = bloodBankCenter.getWorkingHours().getWorkHourBeginTime().split(":")[1];
        String hours3 = bloodBankCenter.getWorkingHours().getWorkHourEndTime().split(":")[0];
        String minutes3 = bloodBankCenter.getWorkingHours().getWorkHourEndTime().split(":")[1];
        int numHours = Integer.parseInt(hours);
        int numMinutes = Integer.parseInt(minutes);
        int numHours2 = Integer.parseInt(hours2);
        int numMinutes2 = Integer.parseInt(minutes2);
        int numHours3 = Integer.parseInt(hours3);
        int numMinutes3 = Integer.parseInt(minutes3);
        int duration = appointmentDTO.getDuration();
        if(numHours2 <= numHours && (numHours + duration) <= numHours3 ){
            Appointment appointment = appointmentDTO.toModel();
            appointment.setWorkCalendar(workCalendar);
            workCalendar.getAppointments().add(appointment);
            workCalendarRepository.save(workCalendar);
            return  true;
        } else{
            return false;
        }
    }
}
