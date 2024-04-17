public class Ikasle {

    private int id;
    private String izena;
    private String herria;
    private long telefonoa;
    private java.sql.Date JaiotzeData;
    private int ikastaroKodea;


    public Ikasle(int id, String izena, String herria, long telefonoa, java.sql.Date jaiotzeData, int ikastaroKodea) {
        this.id = id;
        this.izena = izena;
        this.herria = herria;
        this.telefonoa = telefonoa;
        JaiotzeData = jaiotzeData;
        this.ikastaroKodea = ikastaroKodea;
    }

    @Override
    public String toString() {
        return "Ikasle{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", herria='" + herria + '\'' +
                ", telefonoa=" + telefonoa +
                ", JaiotzeData='" + JaiotzeData + '\'' +
                ", ikastaroKodea=" + ikastaroKodea +
                '}';
    }

    public int getId() {
        return id;
    }
}
