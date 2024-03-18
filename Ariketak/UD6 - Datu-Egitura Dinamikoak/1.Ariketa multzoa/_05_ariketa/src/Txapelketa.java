import java.util.ArrayList;
import java.util.HashSet;

public class Txapelketa {


    private HashSet<Kirolari> korrikalari;
    private HashSet<Kirolari> txirrindulari;
    private HashSet<Kirolari> igerilari;

    public Txapelketa() {
        this.korrikalari = new HashSet<Kirolari>();
        this.txirrindulari = new HashSet<Kirolari>();
        this.igerilari = new HashSet<Kirolari>();
    }

    void gehituKirolari(Kirolari kirolari){
        if (kirolari.getEspezialitatea1() == Espezialitate.KORRIKALARI){
            korrikalari.add(kirolari);
        } else if (kirolari.getEspezialitatea1() == Espezialitate.TXIRRINDULARI) {
            txirrindulari.add(kirolari);
        } else if (kirolari.getEspezialitatea1() == Espezialitate.IGERILARI) {
            igerilari.add(kirolari);
        }
    }

    void aldatuEspezialitatea(Kirolari kirolari, Espezialitate espezialitate){

        if (kirolari.getEspezialitatea1() == espezialitate){
            System.out.println(kirolari.getIzena()+" kirolaria dagoeneko "+espezialitate+" dauka.");
        }else {
            if (espezialitate == Espezialitate.KORRIKALARI) {

                if (kirolari.getEspezialitatea1() == Espezialitate.TXIRRINDULARI) {
                    txirrindulari.remove(kirolari);
                } else {
                    igerilari.remove(kirolari);
                }

                kirolari.setEspezialitatea1(espezialitate);
                korrikalari.add(kirolari);
            } else if ((espezialitate == Espezialitate.TXIRRINDULARI)) {

                if (kirolari.getEspezialitatea1() == Espezialitate.KORRIKALARI) {
                    korrikalari.remove(kirolari);
                } else {
                    igerilari.remove(kirolari);
                }

                kirolari.setEspezialitatea1(espezialitate);
                txirrindulari.add(kirolari);

            } else if ((espezialitate == Espezialitate.IGERILARI)) {

                if (kirolari.getEspezialitatea1() == Espezialitate.KORRIKALARI) {
                    korrikalari.remove(kirolari);
                } else {
                    txirrindulari.remove(kirolari);
                }

                kirolari.setEspezialitatea1(espezialitate);
                igerilari.add(kirolari);

            }
        }
    }


    void erakutsi(){

        System.out.println("*****************************KORRIKALARI*****************************");
        for (Kirolari kirolari: korrikalari) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }

        System.out.println("*****************************TXIRRINDULARI***************************");
        for (Kirolari kirolari: txirrindulari) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }

        System.out.println("*****************************IGERILARI*******************************");
        for (Kirolari kirolari: igerilari) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }

    }

    void duatleta() {
        HashSet<Kirolari> duatletak = new HashSet<>();

        for (Kirolari kirolari : korrikalari) {
            if (txirrindulari.contains(kirolari) || igerilari.contains(kirolari)) {
                duatletak.add(kirolari);
            }
        }
        for (Kirolari kirolari : txirrindulari) {
            if (igerilari.contains(kirolari) || korrikalari.contains(kirolari)) {
                duatletak.add(kirolari);
            }
        }

        /*for (Kirolari kirolari : duatletak){
            if (korrikalari.contains(kirolari) && txirrindulari.contains(kirolari) && igerilari.contains(kirolari)){
                duatletak.remove(kirolari);
            }
        }*/

        //↓ Intellij-tak urrengo formatua gomendatudik erabiltzea eta ez for-a
        duatletak.removeIf(kirolari -> korrikalari.contains(kirolari) && txirrindulari.contains(kirolari) && igerilari.contains(kirolari));

        System.out.println("*****************************KORRIKALARI*****************************");
        boolean korri =false;
        for (Kirolari kirolari : korrikalari) {
            if (duatletak.contains(kirolari)) {
                System.out.println(kirolari.getIzena() + " " + kirolari.getAdina());
                korri = true;
            }
        }

        if (!korri){
            System.out.println("Ez dago duatletarik atletismoan");
        }

        System.out.println("*****************************TXIRRINDULARI***************************");
        boolean txirri = false;
        for (Kirolari kirolari : txirrindulari) {
            if (duatletak.contains(kirolari)) {
                System.out.println(kirolari.getIzena() + " " + kirolari.getAdina());
                txirri = true;
            }
        }

        if (!txirri){
            System.out.println("Ez dago duatletarik txirrindularitzan");
        }

        System.out.println("*****************************IGERILARI*******************************");
        boolean iger = false;
        for (Kirolari kirolari : igerilari) {
            if (duatletak.contains(kirolari)) {
                System.out.println(kirolari.getIzena() + " " + kirolari.getAdina());

                iger = true;
            }
        }

        if (!iger){
            System.out.println("Ez dago duatletarik igeriketan");
        }

    }


    void triatleta(){
        HashSet<Kirolari> guztiak = korrikalari;
        guztiak.retainAll(txirrindulari);
        guztiak.retainAll(igerilari);



        System.out.println("*****************************KORRIKALARI*****************************");
        for (Kirolari kirolari: guztiak) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }

        if (guztiak.size()==0){
            System.out.println("Ez dago triatletarik");
        }

        System.out.println("*****************************TXIRRINDULARI***************************");
        for (Kirolari kirolari: guztiak) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }
        if (guztiak.size()==0){
            System.out.println("Ez dago triatletarik");
        }

        System.out.println("*****************************IGERILARI*******************************");
        for (Kirolari kirolari: guztiak) {
            System.out.println(kirolari.getIzena() + " "+kirolari.getAdina());
        }
        if (guztiak.size()==0){
            System.out.println("Ez dago triatletarik");
        }

    }








}
