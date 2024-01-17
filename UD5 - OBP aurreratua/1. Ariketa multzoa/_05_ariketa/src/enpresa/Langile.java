package enpresa;

public class Langile extends Pertsona{


    private float dirua;

    private Mugikor telefonoa;


    public Langile(String izena, String NAN, float altuera, float pisua, float dirua, Mugikor telefonoa) {
        super(izena, NAN, altuera, pisua);
        this.dirua = dirua;
        this.telefonoa = telefonoa;
    }


    void diruaIrabazi(float dirua){
        this.dirua +=dirua;
    }

    void  diruaGastatu(float dirua){
        this.dirua -=dirua;
    }

    public String toString(){
        return  super.toString()+" Dirua: "+dirua+" Bateria: "+telefonoa.getBateria();
    }

    public void lanEgin(){
        diruaIrabazi(10);
        telefonoa.erabili();
    }
}
