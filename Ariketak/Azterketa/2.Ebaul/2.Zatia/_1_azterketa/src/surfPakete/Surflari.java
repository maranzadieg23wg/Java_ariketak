package surfPakete;

public abstract class Surflari {

    private String izena;
    private int rankingPos;
    private int energia;
    private Babesle babesle;

    public Surflari(String izena, int rankingPos, int energia, Babesle babesle) {


        try {
            if (energia<0 || energia>100){
                Exception Exception = null;
                throw Exception;
            }
        }catch (Exception e){
            System.err.println("Sartutako energiak ez du balio.");
        }

        this.izena = izena;
        this.rankingPos = rankingPos;
        this.energia = energia;
        this.babesle = babesle;
    }

    public void surfeatu(){
        this.energia-=5;
    }

    public void atsedenaHartu(){
        this.energia+=10;
    }

    public String getIzena() {
        return izena;
    }

    public int getRankingPos() {
        return rankingPos;
    }

    int getEnergia() {
        return energia;
    }

    public Babesle getBabesle() {
        return babesle;
    }

    public void erakutsi(){
        //System.out.println(getIzena()+", "+getRankingPos()+", "+getEnergia()+", " + getBabesle().erakutsi());
    }
}
