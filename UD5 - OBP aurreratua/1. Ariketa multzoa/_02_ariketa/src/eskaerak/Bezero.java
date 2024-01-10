package eskaerak;

public class Bezero {

    String NAN;
    String izena;
    int maileguKop;

    private Mailegu maileguList[];

    Bezero(String NAN, String izena){
        this.NAN = NAN;
        this.izena = izena;
        maileguKop =0;
        maileguList = new Mailegu[5];
    }

    public void erakutsi(){
        System.out.println("NAN: "+NAN+" Izena: "+izena+" Mailegu Kopurua: "+maileguKop);
    }

    public void gehituMailegu(Mailegu mailegu){
        if (maileguKop < maileguList.length){
            System.out.println("Bezeroak ditu maileguan "+maileguKop+" liburu, ezin ditu gehiago artu. Bueltatu behar du baten bat.");
            mailegu = null;
        }
        for (int i =0;i<maileguList.length;i++){

            if (maileguList[i]==null){
                maileguList[i]=mailegu;
                i = maileguList.length;
                maileguKop++;
            }

        }
    }

    public void kenduMailegu(Mailegu mailegu){
        for (int i =0;i<maileguList.length;i++){
            if (maileguList[i].equals(mailegu)){
                maileguList[i]=null;
            }
        }
    }

}
