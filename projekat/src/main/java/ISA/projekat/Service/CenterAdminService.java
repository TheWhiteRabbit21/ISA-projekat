package ISA.projekat.Service;

import ISA.projekat.DTOs.*;
import ISA.projekat.Model.*;
import ISA.projekat.Model.enums.Gender;
import ISA.projekat.Repository.AppointmentRepository;
import ISA.projekat.Repository.CenterAdminRepository;
import ISA.projekat.Repository.CenterRepository;
import ISA.projekat.Repository.RoleRepository;
import ISA.projekat.Repository.WorkCalendarRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CenterAdminService {

    private final CenterAdminRepository centerAdminRepository;
    private final CenterRepository bloodBankCenterRepository;
    private final AppointmentRepository appointmentRepository;
    private final WorkCalendarRepository workCalendarRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public CenterAdminService(RoleRepository roleRepository, CenterAdminRepository centerAdminRepository, CenterRepository bloodBankCenterRepository, WorkCalendarRepository workCalendarRepository, AppointmentRepository appointmentRepository) {
        this.centerAdminRepository = centerAdminRepository;
        this.appointmentRepository = appointmentRepository;
        this.bloodBankCenterRepository = bloodBankCenterRepository;
        this.workCalendarRepository = workCalendarRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleRepository = roleRepository;
    }

    
    public void CreateCenterAdmin(CenterAdminDTO centerAdminDTO){
        Address address = new Address(centerAdminDTO.country, centerAdminDTO.city, centerAdminDTO.street, centerAdminDTO.number);
        Staff staff = new Staff(centerAdminDTO.email,centerAdminDTO.password,centerAdminDTO.name,
                centerAdminDTO.surname, parseGender(centerAdminDTO.gender), centerAdminDTO.jmbg, address,centerAdminDTO.phoneNumber);
        staff.setEnabled(true);
        staff.setPassword(passwordEncoder.encode(centerAdminDTO.password));
        staff.setRoles(roleRepository.findByName("ROLE_ADMIN_CENTER"));
        centerAdminRepository.save(staff);
    }
    public List<CenterAdminDTO> GetAvailableAdmins() {
        List<CenterAdminDTO> admins = new ArrayList<CenterAdminDTO>();
        for (Staff admin : centerAdminRepository.findAllByBloodBankCenterIsNull()) {
            admins.add(new CenterAdminDTO(admin.getId(), admin.getName(), admin.getSurname()));
            return admins;
        }
        return admins;
    }
        public int findIdByUsername(String username){
            if(centerAdminRepository.findByUsername(username) != null){
                return centerAdminRepository.findByUsername(username).getId();
            }
            return 0;
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

        public List<CenterDTO> findAllCentersByAppointments(ReservationDTO reservationDTO){
            List<CenterDTO> centers = new ArrayList<CenterDTO>();
            for(WorkCalendar workCalendar : workCalendarRepository.findAll()){
                for(Appointment appointment: workCalendar.getAppointments()){
                    String myDate = reservationDTO.getDate().toString();
                    String myDay = myDate.split("/")[0];
                    String myMonth = myDate.split("/")[1];
                    String myYear = myDate.split("/")[2];
                    String theirDate = appointment.getDate().toString();
                    String theirYear = theirDate.split("-")[0];
                    String theirMonth = theirDate.split("-")[1];
                    String theirDay = theirDate.split("-")[2];
                    if(appointment.isTaken() == false) {
                        if (myDay.equals(theirDay) && myMonth.equals(theirMonth) && myYear.equals(theirYear) && appointment.getTime() == LocalTime.parse(reservationDTO.getTime())) {
                            BloodBankCenter bloodBankCenter = workCalendar.getBloodBankCenter();
                            CenterDTO center = new CenterDTO();
                            center.setId(String.valueOf(bloodBankCenter.getId()));
                            center.setName(bloodBankCenter.getName());
                            center.setCity(bloodBankCenter.getAddress().getCity());
                            center.setAverageRating(bloodBankCenter.getAverageRating());
                            centers.add(center);
                        }
                    }
                }
            }
            return centers;
        }
        public void reserveAppointment(ReservationDTO reservationDTO){
            BloodBankCenter center = bloodBankCenterRepository.findById(reservationDTO.getBloodBankId()).get();
            WorkCalendar calendar = workCalendarRepository.findByBloodBankCenter(center);
            for(Appointment appointment: calendar.getAppointments()){
                String myDate = reservationDTO.getDate().toString();
                String myDay = myDate.split("/")[0];
                String myMonth = myDate.split("/")[1];
                String myYear = myDate.split("/")[2];
                String theirDate = appointment.getDate().toString();
                String theirYear = theirDate.split("-")[0];
                String theirMonth = theirDate.split("-")[1];
                String theirDay = theirDate.split("-")[2];
                if (myDay.equals(theirDay) && myMonth.equals(theirMonth) && myYear.equals(theirYear) && appointment.getTime() == LocalTime.parse(reservationDTO.getTime())) {
                    appointment.setTaken(true);
                    workCalendarRepository.save(calendar);
                    return;
                }
            }
        }
    }
