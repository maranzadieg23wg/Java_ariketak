import java.util.Objects;

public class Langile {


    enum kargua{
        piloto,
        zuzendari,
        ingeniaria
    }

    private String izena;
    private String abizena;
    private  int adina;
    private kargua kargua;

    public Langile(String izena, String abizena, int adina, Langile.kargua kargua) {
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
        this.kargua = kargua;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Langile langile = (Langile) o;
        return adina == langile.adina && Objects.equals(izena, langile.izena) && Objects.equals(abizena, langile.abizena) && kargua == langile.kargua;
    }

    @Override
    public int hashCode() {
        return Objects.hash(izena, abizena, adina, kargua);
    }

    public Langile.kargua getKargua() {
        return kargua;
    }

    @Override
    public String toString() {
        return "Langile{" +
                "izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", adina=" + adina +
                ", kargua=" + kargua +
                '}';
    }
}
