public class Main {
    public static void main(String[] args) {

        Txapelketa t1 = new Txapelketa();

        //Kirolari k1 = new Kirolari("Manolo", 20, Espezialitate.KORRIKALARI);
        //Kirolari k2 = new Kirolari("Manuel", 25, Espezialitate.KORRIKALARI);
        Kirolari k3 = new Kirolari("Karlas", 230, Espezialitate.TXIRRINDULARI);

        Kirolari tx1 = new Kirolari("Manolo", 20, Espezialitate.TXIRRINDULARI);
        Kirolari tx2 = new Kirolari("Manuel", 25, Espezialitate.TXIRRINDULARI);
        //Kirolari tx3 = new Kirolari("Karlas", 230, Espezialitate.TXIRRINDULARI);

        Kirolari ig1 = new Kirolari("Manolo", 20, Espezialitate.IGERILARI);
        //Kirolari ig2 = new Kirolari("Manuel", 25, Espezialitate.IGERILARI);
        Kirolari ig3 = new Kirolari("Karlas", 230, Espezialitate.IGERILARI);




        //t1.gehituKirolari(k1);
        //t1.gehituKirolari(k2);
        t1.gehituKirolari(k3);
        t1.gehituKirolari(tx1);
        t1.gehituKirolari(tx2);
        t1.gehituKirolari(ig1);
        //t1.gehituKirolari(ig2);
        t1.gehituKirolari(ig3);


        /*t1.erakutsi();

        t1.aldatuEspezialitatea(k3, Espezialitate.TXIRRINDULARI);
        t1.aldatuEspezialitatea(k4, Espezialitate.IGERILARI);

        System.out.println("////////////////////////ALDATUTA////////////////////////////");

        t1.erakutsi();*/

        //t1.triatleta();

        t1.duatleta();




    }

}