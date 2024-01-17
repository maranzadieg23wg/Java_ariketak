package enpresa;

public class Langile extends Pertsona{


    private float dirua;

    public Langile(String izena, String NAN, float altuera, float pisua, float dirua) {
        super(izena, NAN, altuera, pisua);
        this.dirua = dirua;
    }


    public void diruaIrabazi(float dirua){
        this.dirua +=dirua;
    }

    public void  diruaGastatu(float dirua){
        this.dirua -=dirua;
    }

    public String toString(){
        return  super.toString()+" Dirua: "+dirua;
    }
}
