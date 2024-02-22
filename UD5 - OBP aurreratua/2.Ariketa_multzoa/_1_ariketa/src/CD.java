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
        try{
            if (birgrabagarria){
                System.out.println("CD dispositiboa grabatzen");

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


    }

    @Override
    public void biratu() {
        System.out.println("CD dispositiboa 210 rpm abiaduran biratzen du");
    }
}
