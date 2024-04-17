public class Ikastaro {

    private int id;
    private String izena;
    private int orduak;


    public Ikastaro(int id, String izena, int orduak) {
        this.id = id;
        this.izena = izena;
        this.orduak = orduak;
    }

    @Override
    public String toString() {
        return "Ikastaro{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", orduak=" + orduak +
                '}';
    }
}
