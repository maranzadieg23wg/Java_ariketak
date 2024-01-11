package eskaerak;

import elementuak.Elementu;

public class Bezero {

    String NAN;
    String izena;
    int maileguKop;

    private Mailegu maileguList[];

    public Bezero(String NAN, String izena){
        this.NAN = NAN;
        this.izena = izena;
        maileguKop =0;
        maileguList = new Mailegu[5];
    }

    public void erakutsi(){
        System.out.println("NAN: "+NAN+" Izena: "+izena+" Mailegu Kopurua: "+maileguKop);
    }

    public void gehituMailegu(Mailegu mailegu){
        if (maileguKop >= maileguList.length){
            System.out.println("Bezeroak ditu maileguan "+maileguKop+" liburu, ezin ditu gehiago artu. Bueltatu behar du baten bat.");
            mailegu = null;
        }else {
            for (int i =0;i<maileguList.length;i++){

                if (maileguList[i]==null){
                    maileguList[i]=mailegu;
                    i = maileguList.length;
                    maileguKop++;
                }

            }
        }

    }

    public void kenduMailegu(Mailegu mailegu){

        Elementu elementu = mailegu.getElementu();

        for (int i =0;i<maileguList.length;i++){

            Mailegu mailegu1 = maileguList[i];
            Elementu elementu1 = mailegu1.getElementu();

            if (elementu.getKodea() == elementu1.getKodea()){
                maileguList[i]=null;
                i = maileguList.length+1;
                maileguKop--;
            }
        }
    }

}
