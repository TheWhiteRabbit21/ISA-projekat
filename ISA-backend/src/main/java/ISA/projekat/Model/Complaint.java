package ISA.projekat.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "complaints")
@SuppressWarnings("serial")
public class Complaint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String text;

    @Column()
    private String response;

    @Version
    private Integer version;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private RegisteredUser registeredUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodBankCenter_id", referencedColumnName = "id")
    private BloodBankCenter bloodBankCenter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    public Complaint(){

    }

    public Complaint(String text, RegisteredUser registeredUser) {
        this.text = text;
        this.registeredUser = registeredUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public BloodBankCenter getBloodBankCenter() {
        return bloodBankCenter;
    }

    public void setBloodBankCenter(BloodBankCenter bloodBankCenter) {
        this.bloodBankCenter = bloodBankCenter;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", response='" + response + '\'' +
                ", registeredUser=" + registeredUser +
                ", bloodBankCenter=" + bloodBankCenter +
                ", staff=" + staff +
                '}';
    }
}
