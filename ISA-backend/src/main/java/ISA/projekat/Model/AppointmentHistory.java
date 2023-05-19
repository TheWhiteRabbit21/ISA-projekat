package ISA.projekat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class AppointmentHistory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String datum;
	
	@Column(nullable = false)
	private int donorId;
	
	@Column(nullable = false)
	private String krvnaGrupa;
	
	@Column(nullable = false)
	private String napomenaDoktoruMedicine;
	
	@Column(nullable = false)
	private String bakarSulfat;
	
	@Column(nullable = false)
	private String hemoglobinometarVrednost;
	
	@Column(nullable = false)
	private String pluca;
	
	@Column(nullable = false)
	private String srce;
	
	@Column(nullable = false)
	private String TA;
	
	@Column(nullable = false)
	private String tipKese;
	
	@Column(nullable = false)
	private String napomena;
	
	@Column(nullable = false)
	private int brojLotaKese;
	
	
	
	public AppointmentHistory() {
		super();
	}

	
	public AppointmentHistory(String datum2, int donorId2, String krvnaGrupa2, String napomenaDoktoruMedicine2, String bakarSulfat2,
			String hemoglobinometarVrednost2, String pluca2, String srce2, String ta2, String tipKese2,
			String napomena2, String brojLotaKese2) {
		
		this.datum = datum2;
		this.donorId = donorId2;
		this.krvnaGrupa = krvnaGrupa2;
		this.napomenaDoktoruMedicine = napomenaDoktoruMedicine2;
		this.bakarSulfat = bakarSulfat2;
		this.hemoglobinometarVrednost = hemoglobinometarVrednost2;
		this.pluca = pluca2;
		this.srce = srce2;
		this.TA = ta2;
		this.tipKese = tipKese2;
		this.napomena = napomena2;
		this.brojLotaKese = Integer.parseInt(brojLotaKese2);
		
		
	}


	public String getDatum() {
		return datum;
	}


	public void setDatum(String datum) {
		this.datum = datum;
	}


	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public String getNapomenaDoktoruMedicine() {
		return napomenaDoktoruMedicine;
	}

	public void setNapomenaDoktoruMedicine(String napomenaDoktoruMedicine) {
		this.napomenaDoktoruMedicine = napomenaDoktoruMedicine;
	}

	public String getBakarSulfat() {
		return bakarSulfat;
	}

	public void setBakarSulfat(String bakarSulfat) {
		this.bakarSulfat = bakarSulfat;
	}

	public String getHemoglobinometarVrednost() {
		return hemoglobinometarVrednost;
	}

	public void setHemoglobinometarVrednost(String hemoglobinometarVrednost) {
		this.hemoglobinometarVrednost = hemoglobinometarVrednost;
	}

	public String getPluca() {
		return pluca;
	}

	public void setPluca(String pluca) {
		this.pluca = pluca;
	}

	public String getSrce() {
		return srce;
	}

	public void setSrce(String srce) {
		this.srce = srce;
	}

	public String getTA() {
		return TA;
	}

	public void setTA(String tA) {
		TA = tA;
	}

	public String getTipKese() {
		return tipKese;
	}

	public void setTipKese(String tipKese) {
		this.tipKese = tipKese;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public int getBrojLotaKese() {
		return brojLotaKese;
	}

	public void setBrojLotaKese(int brojLotaKese) {
		this.brojLotaKese = brojLotaKese;
	}
	
	
	
	
	
	
	
}
