package eskaerak;

public class Bezero {

    String NAN;
    String izena;
    int maileguKop;

    Bezero(String NAN, String izena, int maileguKop){
        this.NAN = NAN;
        this.izena = izena;
        this.maileguKop = maileguKop;
    }

    public void erakutsi(){
        System.out.println("NAN: "+NAN+" Izena: "+izena+" Mailegu Kopurua: "+maileguKop);
    }

}
