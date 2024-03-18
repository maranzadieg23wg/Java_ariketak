package enpresa;

public class Enpresa {

    private String izena;
    private float irabaziak;
    private Langile jabea;
    private Langile gerentea;

    public Enpresa(String izena, float irabaziak, Langile jabea, Langile gerentea) {
        this.izena = izena;
        this.irabaziak = irabaziak;
        this.jabea = jabea;
        this.gerentea = gerentea;
    }

    public void kontratatuGerentea(Langile langile){
        this.gerentea = langile;
    }

    public void lana(){
        this.irabaziak+=100;
        this.jabea.lanEgin();
        this.gerentea.lanEgin();
    }

    public String toString(){
        return "Izena: "+izena+" Irabaziak: "+irabaziak+ " Jabea: "+jabea.toString() + " Gerentea: "+gerentea.toString();
    }
}
