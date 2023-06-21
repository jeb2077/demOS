package Doctor.AmbCard;

public class Amb {
    private int idambcard;
    private String Polis;
    private String famil;
    private String Name;
    private String Otchest;
    private String Date;
    private String Simptoms;
    private String Isledovanie;
    private String Lekarstva;

    public Amb(int idambcard, String Polis, String famil, String Name, String Otchest, String Date, String Simptoms, String Isledovanie, String Lekarstva) {

    this.idambcard = idambcard;
    this.Polis = Polis;
    this.famil = famil;
    this.Name = Name;
    this.Otchest = Otchest;
    this.Date = Date;
    this.Simptoms = Simptoms;
    this.Isledovanie = Isledovanie;
    this.Lekarstva = Lekarstva;
}
public int idambcard(){return idambcard;}

    public String getPolis() {
        return Polis;
    }

    public String getDate() {
        return Date;
    }

    public String getSimptoms() {
        return Simptoms;
    }

    public String getFamili() {
        return famil;
    }

    public String getName() {
        return Name;
    }

    public String getOtchestvo() {
        return Otchest;
    }

    public String getIsledovanie() {
        return Isledovanie;
    }

    public String getLekarstva() {
        return  Lekarstva;
    }
}
