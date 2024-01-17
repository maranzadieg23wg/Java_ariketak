package enpresa;

public class Pertsona {

    private String izena;
    private String NAN;
    private float altuera;
    private float pisua;


    Pertsona(String izena, String NAN, float altuera, float pisua){
        this.izena = izena;
        this.NAN = NAN;
        this.altuera = altuera;
        this.pisua = pisua;
    }

    public String toString(){
        return "Izena: "+izena+" Altuera: "+altuera;
    }


}
