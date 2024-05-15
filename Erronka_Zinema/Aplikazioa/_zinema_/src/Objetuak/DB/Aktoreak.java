package Objetuak.DB;

import Objetuak.IrudiakDeskargatu;

import java.util.Objects;

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

        lokalIrudia();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aktoreak aktoreak = (Aktoreak) o;
        return id_aktora == aktoreak.id_aktora && Objects.equals(izena, aktoreak.izena) && Objects.equals(abizena, aktoreak.abizena) && Objects.equals(jaiotze_Data, aktoreak.jaiotze_Data) && Objects.equals(nazionalitatea, aktoreak.nazionalitatea) && Objects.equals(emaila, aktoreak.emaila) && Objects.equals(telefonoa, aktoreak.telefonoa) && Objects.equals(irudia, aktoreak.irudia) && Objects.equals(irudiaLokalki, aktoreak.irudiaLokalki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_aktora, izena, abizena, jaiotze_Data, nazionalitatea, emaila, telefonoa, irudia, irudiaLokalki);
    }

    public void lokalIrudia(){
        IrudiakDeskargatu irudiakDeskargatu = new IrudiakDeskargatu(irudia,"./irudiak/aktore");

        setirudiaLokalki(irudiakDeskargatu.getFitxategiarenIzena());
    }
}
