public class Pertsona {
    private String izena;
    private long telefonoa;
    private String herria;

    public Pertsona(String izena, long telefonoa, String herria) {
        this.izena = izena;
        this.telefonoa = telefonoa;
        this.herria = herria;
    }

    public String getIzena() {
        return izena;
    }

    public long getTelefonoa() {
        return telefonoa;
    }

    public String getHerria() {
        return herria;
    }

    @Override
    public String toString() {
        return "Pertsona{" +
                "izena='" + izena + '\'' +
                ", telefonoa='" + telefonoa + '\'' +
                ", herria='" + herria + '\'' +
                '}';
    }
}
