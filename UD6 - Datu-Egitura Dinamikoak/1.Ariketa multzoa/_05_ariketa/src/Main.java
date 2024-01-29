public class Main {
    public static void main(String[] args) {

        Txapelketa t1 = new Txapelketa();

        Kirolari k1 = new Kirolari("Manolo", 20, Espezialitate.KORRIKALARI);
        Kirolari k2 = new Kirolari("Manuel", 25, Espezialitate.TXIRRINDULARI);
        Kirolari k3 = new Kirolari("Karlas", 230, Espezialitate.IGERILARI);


        Kirolari k4 = new Kirolari("Manolo2.0", 20, Espezialitate.KORRIKALARI);
        Kirolari k5 = new Kirolari("Manolo3.0", 20, Espezialitate.KORRIKALARI);


        t1.gehituKirolari(k1);
        t1.gehituKirolari(k2);
        t1.gehituKirolari(k3);
        t1.gehituKirolari(k4);
        t1.gehituKirolari(k5);

        t1.erakutsi();

        t1.aldatuEspezialitatea(k3, Espezialitate.TXIRRINDULARI);
        t1.aldatuEspezialitatea(k4, Espezialitate.IGERILARI);

        System.out.println("////////////////////////ALDATUTA////////////////////////////");

        t1.erakutsi();


    }

}