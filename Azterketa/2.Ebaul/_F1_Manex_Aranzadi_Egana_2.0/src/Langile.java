import java.util.Objects;

public class Langile {


    private String izena;
    private String abizena;
    private int adina;
    private Kargu kargu;



    public Langile(String izena, String abizena, int adina, Kargu kargu) {
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
        this.kargu = kargu;

    }

    @Override
    public String toString() {
        return "Langile{" +
                "izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", adina=" + adina +
                ", kargu=" + kargu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Langile langile = (Langile) o;
        return adina == langile.adina && Objects.equals(izena, langile.izena) && Objects.equals(abizena, langile.abizena) && kargu == langile.kargu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(izena, abizena, adina, kargu);
    }

    public Kargu getKargu() {
        return kargu;
    }
}
