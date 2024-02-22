public class CD extends DiskoOptikoa implements Diskoa{


    public CD(double edukiera, String unitatea, int okupatutakoPortz) {
        super(edukiera, unitatea, okupatutakoPortz, true);
    }

    @Override
    public void irakurri() {
        System.out.println("CD dispositibo bat irakurtzen");
    }

    @Override
    public void grabatu(double kantitatea) {
        if (birgrabagarria){
            System.out.println("CD dispositiboa grabatzen");

            double libre = okupatutakoPortz*edukiera/100;

            if (libre<kantitatea){
                System.err.println("Ezin da grabatu diskoan. Libre daude: "+libre);
            }else {

                libre-=kantitatea;

                double guztira = edukiera-libre;

                okupatutakoPortz = (int) ((int)guztira*100/edukiera);


            }
        }else {
            System.err.println("Disko mota hau ezin da birgrabatu");
        }

    }

    @Override
    public void biratu() {
        System.out.println("CD dispositiboa 210 rpm abiaduran biratzen du");
    }
}
