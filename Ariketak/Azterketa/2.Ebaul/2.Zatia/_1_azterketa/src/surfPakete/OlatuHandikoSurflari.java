package surfPakete;

public class OlatuHandikoSurflari extends Surflari{

    private int olatuAltuera;
    private boolean motorraDu;
    public OlatuHandikoSurflari(String izena, int rankingPos, int energia, Babesle babesle, int olatuAltuera, boolean motorraDu) {
        super(izena, rankingPos, energia, babesle);
        this.olatuAltuera = olatuAltuera;
        this.motorraDu = motorraDu;
    }


    public void surfeatu(){

        int zenbat = 3;

        for (int i =0;i<zenbat;i++){
            super.surfeatu();
            //System.out.println(getEnergia());
        }


    }

    public void erakutsi(){
        System.out.println(getIzena()+", "+getRankingPos()+", "+getEnergia()+", " + getBabesle().erakutsi()+", "+olatuAltuera+", "+motorraDu);
    }
}
