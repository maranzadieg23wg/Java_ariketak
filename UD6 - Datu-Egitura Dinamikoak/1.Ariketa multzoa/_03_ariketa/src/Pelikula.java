import java.util.Objects;

public class Pelikula {

    private String izenburua;
    private int urtea;
    private int iraupena; //← minututan

    public Pelikula(String izenburua, int urtea, int iraupena) {
        this.izenburua = izenburua;
        this.urtea = urtea;
        this.iraupena = iraupena;
    }

    public String toString() {
        return "Izenburua: "+izenburua+" Urtea: "+urtea+ " Iraupena: "+iraupena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelikula pelikula = (Pelikula) o;
        return urtea == pelikula.urtea && (iraupena - pelikula.iraupena <=5 || pelikula.iraupena - iraupena <=5) && Objects.equals(izenburua, pelikula.izenburua);
    }

    public String getIzenburua() {
        return izenburua;
    }

    public int getUrtea() {
        return urtea;
    }

    public int getIraupena() {
        return iraupena;
    }
}
