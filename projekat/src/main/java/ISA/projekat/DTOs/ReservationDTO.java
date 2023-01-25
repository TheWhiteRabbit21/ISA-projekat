package ISA.projekat.DTOs;

public class ReservationDTO {
    private String date;
    private String time;
    private int bloodBankId;

    public ReservationDTO() {
        super();
    }

    public ReservationDTO(String date, String time, int bloodBankId) {
        this.date = date;
        this.time = time;
        this.bloodBankId = bloodBankId;
    }

    public int getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(int bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
