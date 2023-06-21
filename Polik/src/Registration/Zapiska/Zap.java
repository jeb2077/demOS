package Registration.Zapiska;

public class Zap {
    private int idZapiska0;
    private String Polis0;
    private String Doctor0;
    private String Familia0;
    private String Name0;
    private String Otchestvo0;
    private String Date0;
    private String Time0;
    public Zap (int idZapiska, String Polis, String Doctor, String Familia, String Name, String Otchestvo, String Date, String Time) {

        this.idZapiska0 = idZapiska;
        this.Polis0 = Polis;
        this.Doctor0 = Doctor;
        this.Familia0 = Familia;
        this.Name0 = Name;
        this.Otchestvo0 = Otchestvo;
        this.Date0 = Date;
        this.Time0 = Time;
    }

    public String getPolis() {
        return Polis0;
    }

    public String getDoctor() {
        return Doctor0;
    }

    public String getFamil() {
        return Familia0;
    }

    public String getName() {
        return Name0;
    }

    public String getOtchestvo() {
        return Otchestvo0;
    }

    public String getDate() {
        return Date0;
    }

    public String getTime() {
        return Time0;
    }
}
