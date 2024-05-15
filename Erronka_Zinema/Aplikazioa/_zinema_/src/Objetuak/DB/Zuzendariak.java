package Objetuak.DB;

import Objetuak.IrudiakDeskargatu;

import java.util.Objects;

public class Zuzendariak {

    private int id;
    private String izena;
    private String abizena;
    private int jaiotzeData;
    private String sexua;
    private String irudia;
    private String irudiaLokalki;

    public Zuzendariak(int id, String izena, String abizena, int jaiotzeData, String sexua, String irudia) {
        this.id = id;
        this.izena = izena;
        this.abizena = abizena;
        this.jaiotzeData = jaiotzeData;
        this.sexua = sexua;
        this.irudia = irudia;

        lokalIrudia();
    }

    public String getIrudia() {
        return irudia;
    }

    public String getIrudiaLokalki() {
        return irudiaLokalki;
    }

    public void setIrudiaLokalki(String irudiaLokalki) {
        this.irudiaLokalki = irudiaLokalki;
    }

    @Override
    public String toString() {
        return "Zuzendariak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", jaiotzeData=" + jaiotzeData +
                ", sexua='" + sexua + '\'' +
                ", irudia='" + irudia + '\'' +
                ", irudiaLokalki='" + irudiaLokalki + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zuzendariak that = (Zuzendariak) o;
        return id == that.id && jaiotzeData == that.jaiotzeData && Objects.equals(izena, that.izena) && Objects.equals(abizena, that.abizena) && Objects.equals(sexua, that.sexua) && Objects.equals(irudia, that.irudia) && Objects.equals(irudiaLokalki, that.irudiaLokalki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, izena, abizena, jaiotzeData, sexua, irudia, irudiaLokalki);
    }

    public void lokalIrudia(){
        IrudiakDeskargatu irudiakDeskargatu = new IrudiakDeskargatu(irudia,"./irudiak/zuzendari");

        setIrudiaLokalki(irudiakDeskargatu.getFitxategiarenIzena());
    }
}
