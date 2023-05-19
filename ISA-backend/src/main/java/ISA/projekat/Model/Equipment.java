package ISA.projekat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Equipment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true)
	private int bloodQuantity;
	
	@Column(nullable = true)
	private int needles;
	
	
	public Equipment() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBloodQuantity() {
		return bloodQuantity;
	}


	public void setBloodQuantity(int bloodQuantity) {
		this.bloodQuantity = bloodQuantity;
	}


	public int getNeedles() {
		return needles;
	}


	public void setNeedles(int needles) {
		this.needles = needles;
	}

	
	
	
	
	
	
	
	
	
	
}
