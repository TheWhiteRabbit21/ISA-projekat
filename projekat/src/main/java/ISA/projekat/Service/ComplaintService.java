package ISA.projekat.Service;

import ISA.projekat.Model.Complaint;
import ISA.projekat.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }
    @Transactional(readOnly = false)
    public void save(Complaint complaint){
        complaintRepository.save(complaint);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void setResponse(String response, Integer id){
        Complaint complaint = complaintRepository.findById(id).get();
        if(complaint.getResponse().equals("")){
            complaint.setResponse(response);
            complaintRepository.save(complaint);
        }
    }
    public Complaint findById(Integer id){
        return complaintRepository.findById(id).get();
    }
    public Collection<Complaint> getAllUnanswered(){
        return complaintRepository.findByResponseIsNull();
    }
}
