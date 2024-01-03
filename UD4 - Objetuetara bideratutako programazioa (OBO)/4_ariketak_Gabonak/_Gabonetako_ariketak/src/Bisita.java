import java.util.Date;
public class Bisita {

    private Bezero bezero;
    private double zenbat =0;
    private java.util.Date data;

    Bisita(Bezero bezero){
        this.bezero = bezero;

        this.data = new java.util.Date();
    }

    public double kalkulatuZenbatekoa(float zenbat){

        this.zenbat = zenbat * bezero.jasoDeskontua();
        return this.zenbat;

    }

    public String toString(){
        return bezero.toString()+"Zenbat: "+zenbat+" --  Data: "+data;
    }


}
