public class Pertsona {
    private String izena;
    private String telefonoa;
    private String herria;

    public Pertsona(String izena, String telefonoa, String herria) {
        this.izena = izena;
        this.telefonoa = telefonoa;
        this.herria = herria;
    }

    public String getIzena() {
        return izena;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public String getHerria() {
        return herria;
    }
}
