public class Main {
    public static void main(String[] args) {

        Pertsona p1 = new Pertsona("Manolo", "12345678A", 20);

        KontuKorronte k1 = new KontuKorronte(p1);

        Banku b1 = new Banku("Kutxabank");


        b1.gehituKontuKorronte(k1);

        //k1.erakutsiKontua();

        k1.diruGordailua(60);
        k1.diruaKendu(120);

        b1.kenduKontuKorronte(k1);
        b1.ikusiKontuKorronte(k1);

    }
}