package ISA.projekat.DTOs;

import ISA.projekat.Model.AppointmentHistory;

public class AppointmentInfoDTO {

	public String datum;
	public int donorId;
	public String krvnaGrupa;
	public String napomenaDoktoruMedicine;
	public String bakarSulfat;
	public String hemoglobinometarVrednost;
	public String pluca;
	public String srce;
	public String TA;
	public String tipKese;
	public String napomena;
	public String brojLotaKese;
	public String kolicinaKrviDataML;
	public String brojIgala;
	

	public AppointmentInfoDTO() {
	
	}


	public AppointmentInfoDTO(AppointmentHistory ah) {

		this.datum = ah.getDatum();
		this.donorId = ah.getDonorId();
		this.krvnaGrupa = ah.getKrvnaGrupa();
		this.napomenaDoktoruMedicine = ah.getNapomenaDoktoruMedicine();
		this.bakarSulfat = ah.getBakarSulfat();
		this.hemoglobinometarVrednost = ah.getHemoglobinometarVrednost();
		this.pluca = ah.getPluca();
		this.srce = ah.getSrce();
		this.TA = ah.getTA();
		this.tipKese = ah.getTipKese();
		this.napomena = ah.getNapomena();
		this.brojLotaKese = Integer.toString(ah.getBrojLotaKese());
		
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


	public String getBrojLotaKese() {
		return brojLotaKese;
	}


	public void setBrojLotaKese(String brojLotaKese) {
		this.brojLotaKese = brojLotaKese;
	}


	public String getKolicinaKrviDataML() {
		return kolicinaKrviDataML;
	}


	public void setKolicinaKrviDataML(String kolicinaKrviDataML) {
		this.kolicinaKrviDataML = kolicinaKrviDataML;
	}


	public String getBrojIgala() {
		return brojIgala;
	}


	public void setBrojIgala(String brojIgala) {
		this.brojIgala = brojIgala;
	}
	
	
	
	
	
	
}