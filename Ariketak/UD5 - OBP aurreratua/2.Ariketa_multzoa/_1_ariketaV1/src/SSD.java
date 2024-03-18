public class SSD extends DiskoOptikoa{


    public SSD(double edukiera) {
        super(edukiera, "GB", 0, true);
    }


    @Override
    public void irakurri() {
        System.out.println("SDD dispositibo bat irakurtzen");
    }

    @Override
    public void grabatu(double kantitatea) {
        try{
            if (birgrabagarria){
                System.out.println("SSD dispositiboa grabatzen");

                double libre = (100-okupatutakoPortz)*edukiera/100;
                //System.out.println(libre);

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
}
