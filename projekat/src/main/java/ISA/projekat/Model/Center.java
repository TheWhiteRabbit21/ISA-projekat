package ISA.projekat.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "centers")
@SuppressWarnings("serial")
public class Center implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int addressId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private int administratorCenterId;

    public Center(String name, int addressId, String description) {
        this.name = name;
        this.addressId = addressId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAdministratorCenterId() {
        return administratorCenterId;
    }

    public void setAdministratorCenterId(int administratorCenterId) {
        this.administratorCenterId = administratorCenterId;
    }
}
