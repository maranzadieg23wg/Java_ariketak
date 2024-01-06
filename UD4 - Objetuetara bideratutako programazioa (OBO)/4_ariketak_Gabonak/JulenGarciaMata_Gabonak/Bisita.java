import java.util.Date;
import java.util.Objects;

public class Bisita {

    private Bezero bezero;
    Date date;
    double zenb;

    public Bisita(Bezero bezero, Date date){
        this.bezero=bezero;
        this.date=date;
        this.zenb=0;
    }

    public double kalkulatuZenbatekoa(double zenb){
        this.zenb=zenb;
        if(Objects.equals(bezero.bazkideS,"Premium") && Objects.equals(bezero.bazkideB,true)){
            return this.zenb=(this.zenb*0.20);
        } else if (Objects.equals(bezero.bazkideS,"Urre") && Objects.equals(bezero.bazkideB,true)) {
            return  this.zenb=(this.zenb*0.15);
        }else if (Objects.equals(bezero.bazkideS,"Zilar") && Objects.equals(bezero.bazkideB,true)) {
            return this.zenb=(this.zenb*0.10);
        }
        else {
            return this.zenb;
        }
    }

    public String toString (){

        return bezero.toString()+"  Zenbat_aldiz= "+ zenb+ "eta data= "+date;
    }

    //Bezeroaren datu guztiak emateko
    public Bezero emanBezero(){
        return bezero;
    }
}
