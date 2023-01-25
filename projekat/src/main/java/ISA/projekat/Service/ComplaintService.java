package ISA.projekat.Service;

import ISA.projekat.Model.Complaint;
import ISA.projekat.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public void setResponse(String response, Integer id){
        Complaint complaint = complaintRepository.findById(id).get();
        complaint.setResponse(response);
        complaintRepository.save(complaint);
    }
    public Collection<Complaint> getAllUnanswered(){
        return complaintRepository.findByResponseIsNull();
    }
}
