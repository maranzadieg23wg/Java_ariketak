public class DVD extends DiskoOptikoa implements Diskoa{


    public DVD(double edukiera, String unitatea, int okupatutakoPortz) {
        super(edukiera, unitatea, okupatutakoPortz, true);
    }

    @Override
    public void irakurri() {
        System.out.println("DVD dispositibo bat irakurtzen");
    }

    @Override
    public void grabatu(double kantitatea) {
        if (birgrabagarria){
            System.out.println("DVD dispositiboa grabatzen");

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
        System.out.println("DVD dispositiboa 500 rpm abiaduran biratzen du");
    }
}
