package surfPakete;

public class OlatuTxikikoSurflari extends Surflari{

    private int tablaLuzeera;

    public OlatuTxikikoSurflari(String izena, int rankingPos, int energia, Babesle babesle, int tablaLuzeera) {
        super(izena, rankingPos, energia, babesle);
        this.tablaLuzeera = tablaLuzeera;
    }


    public void erakutsi(){
        System.out.println(getIzena()+", "+getRankingPos()+", "+getEnergia()+", " + getBabesle().erakutsi()+", "+tablaLuzeera);
    }
}
