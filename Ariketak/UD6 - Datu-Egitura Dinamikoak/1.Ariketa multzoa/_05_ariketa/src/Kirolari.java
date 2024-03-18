import java.util.Objects;

public class Kirolari {



    private String izena;
    private int adina;


    private  Espezialitate espezialitatea1;

    public Kirolari(String izena, int adina, Espezialitate espezialitatea) {
        this.izena = izena;
        this.adina = adina;
        this.espezialitatea1 = espezialitatea;
    }

    public Kirolari(String izena, int adina) {
        this.izena = izena;
        this.adina = adina;
    }

    public Espezialitate getEspezialitatea1() {
        return espezialitatea1;
    }

    public String getIzena() {
        return izena;
    }

    public int getAdina() {
        return adina;
    }

    public void setEspezialitatea1(Espezialitate espezialitatea1) {
        this.espezialitatea1 = espezialitatea1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kirolari kirolari = (Kirolari) o;
        return adina == kirolari.adina && Objects.equals(izena, kirolari.izena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(izena, adina);
    }
}
