public class Kirolari {



    private String izena;
    private int adina;
    private enum Espezialitatea{
        KORRIKALARI, TXIRRINDULARI, IGERILARI;

    }

    private  Espezialitatea espezialitatea1;

    public Kirolari(String izena, int adina, Espezialitatea espezialitatea) {
        this.izena = izena;
        this.adina = adina;
        this.espezialitatea1 = espezialitatea;
    }



}
