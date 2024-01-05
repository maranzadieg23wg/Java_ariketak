import java.time.LocalDate;

public class Bisita {

    private Bezero bezero;
    private double zenbat =0;
    private java.time.LocalDate data;

    Bisita(Bezero bezero, LocalDate data){
        this.bezero = bezero;
        this.data = data;
    }

    public double kalkulatuZenbatekoa(float zenbat){

        this.zenbat = zenbat-(zenbat * bezero.jasoDeskontua());
        return this.zenbat;

    }

    public String toString(){

        return bezero.toString()+"Zenbat: "+zenbat+" -- Data: "+data;
    }

    //Lortzen dugna honekin da, lortzea bezero objetua.
    public Bezero getBezero(){
        return bezero;
    }

    public java.time.LocalDate getData(){
        return data;
    }


}
