public class Main {
    public static void main(String[] args) {

        Pertsona p1 = new Pertsona("Manolo", "12345678A", 20);
        Pertsona p2 = new Pertsona("Emilio", "87654321Z", 33);


        KontuKorronte k1 = new KontuKorronte(p1);
        KontuKorronte k2 = new KontuKorronte(p2);

        Banku b1 = new Banku("Kutxabank");


        b1.gehituKontuKorronte(k1);
        b1.gehituKontuKorronte(k2);

        //k1.erakutsiKontua();

        k1.diruGordailua(60);
        k1.diruaKendu(120);

        b1.kenduKontuKorronte(k1);
        //b1.ikusiKontuKorronte(k1);
        //b1.ikusiKontuKorronte(k2);
        b1.listaKontuKorronte();

    }
}