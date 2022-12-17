package ISA.projekat.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@SuppressWarnings("serial")
public class WorkCalendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "workCalendar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodBankCenter_id", referencedColumnName = "id")
    private BloodBankCenter bloodBankCenter;
}
