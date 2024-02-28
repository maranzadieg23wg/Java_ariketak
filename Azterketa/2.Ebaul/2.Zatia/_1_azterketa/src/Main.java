import Torneo.Torneo;
import surfPakete.Babesle;
import surfPakete.OlatuHandikoSurflari;
import surfPakete.OlatuTxikikoSurflari;
import surfPakete.Surflari;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Babesle b1 = new Babesle("Red", "2000/01/21", true);
        Babesle b2 = new Babesle("Blue", "2010/08/31", false);
        Babesle b3 = new Babesle("Yellow", "2020/02/29", true);


        OlatuTxikikoSurflari tx1 = new OlatuTxikikoSurflari("Steven", 16,60, b1, 50);
        OlatuTxikikoSurflari tx2 = new OlatuTxikikoSurflari("Saul", 15,50, b2, 20);

        OlatuHandikoSurflari h1 = new OlatuHandikoSurflari("Han", 6, 100, b3, 50, false);
        OlatuHandikoSurflari h2 = new OlatuHandikoSurflari("Luke", 8, 99, b1, 30, true);

        Torneo t1 = new Torneo("Zurriola");


        /*h1.surfeatu();
        tx2.atsedenaHartu();

        h1.erakutsi();
        tx2.erakutsi();*/

        t1.gehituBabesle(b1);
        t1.gehituBabesle(b2);
        t1.gehituBabesle(b3);

        t1.gehituSurflaria(tx1);
        t1.gehituSurflaria(tx2);

        t1.gehituSurflaria(h1);
        t1.gehituSurflaria(h2);


        ArrayList<Surflari> lista = t1.surflariakTorneokoBabelearekin();

        for (Surflari s:lista) {
            s.erakutsi();
        }

        ArrayList<Surflari> lista1 = t1.surflariakBabeslearekin(b2);

        for (Surflari s:lista1) {
            s.erakutsi();
        }

        t1.igoTorneoKategoria();

        ArrayList<Surflari> lista2 = t1.surflariakBabeslearekin(b1);

        for (Surflari s:lista2) {
            s.erakutsi();
        }


        t1.gordeFitxategian();



    }
}