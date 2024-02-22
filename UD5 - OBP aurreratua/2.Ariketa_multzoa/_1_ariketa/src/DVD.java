public class DVD extends DiskoOptikoa implements Diskoa{


    public DVD(double edukiera, String unitatea, int okupatutakoPortz) {
        super(edukiera, unitatea, okupatutakoPortz, true);
    }

    @Override
    public void irakurri() {
        System.out.println("DVD dispositibo bat irakurtzen");
    }

    public void grabatu(double kantitatea) {
        try{
            if (birgrabagarria){
                System.out.println("DVD dispositiboa grabatzen");

                double libre = okupatutakoPortz*edukiera/100;

                try {
                    if (libre<kantitatea){
                        throw new Errorea("Ezin da grabatu diskoan. Libre daude: "+libre);
                    }else {

                        libre-=kantitatea;

                        double guztira = edukiera-libre;

                        okupatutakoPortz = (int) ((int)guztira*100/edukiera);


                    }
                }catch (Errorea e){
                    System.err.println(e.getMessage());
                }

            }else {
                throw new Errorea("Disko mota hau ezin da birgrabatu");
            }

        }catch (Errorea e){
            System.err.println(e.getMessage());
        }


        @Override
    public void biratu() {
        System.out.println("DVD dispositiboa 500 rpm abiaduran biratzen du");
    }
}
