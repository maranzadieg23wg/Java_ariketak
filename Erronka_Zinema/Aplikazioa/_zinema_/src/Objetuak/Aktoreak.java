package Objetuak;

public class Aktoreak {

    private int id_aktora;
    private String izena;
    private String abizena;
    private String jaiotze_Data;
    private String nazionalitatea;
    private String emaila;
    private String telefonoa;
    private String irudia;
    String irudiaLokalki;

    public Aktoreak(int id_aktora, String izena, String abizena, String jaiotze_Data, String nazionalitatea, String emaila, String telefonoa, String irudia) {
        this.id_aktora = id_aktora;
        this.izena = izena;
        this.abizena = abizena;
        this.jaiotze_Data = jaiotze_Data;
        this.nazionalitatea = nazionalitatea;
        this.emaila = emaila;
        this.telefonoa = telefonoa;
        this.irudia = irudia;
    }

    public void setirudiaLokalki(String irudiaLokalki) {
        this.irudiaLokalki = irudiaLokalki;
    }

    public String getIrudiaLokalki() {
        return irudiaLokalki;
    }

    public String getIrudia() {
        return irudia;
    }

    @Override
    public String toString() {
        return "Aktoreak{" +
                "id_aktora=" + id_aktora +
                ", izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", jaiotze_Data='" + jaiotze_Data + '\'' +
                ", nazionalitatea='" + nazionalitatea + '\'' +
                ", emaila='" + emaila + '\'' +
                ", telefonoa='" + telefonoa + '\'' +
                ", irudia='" + irudia + '\'' +
                ", irudiaLokalki='" + irudiaLokalki + '\'' +
                '}';
    }
}
