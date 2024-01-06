import java.util.Objects;

public class Bezero {

    String izena;
    String NAN;
    boolean bazkideB;
    String bazkideS;

    public Bezero (String izena, String NAN, boolean bazkideB, String bazkideS){

        this.izena=izena;
        this.NAN=NAN;
        this.bazkideB=bazkideB;
        this.bazkideS=bazkideS;
    }

    public Bezero (String izena, String NAN) {

        this.izena=izena;
        this.NAN=NAN;
    }

    public void jasoDeskontua (){
        if(Objects.equals(bazkideS,"Premium") && Objects.equals(bazkideB,true)){
            System.out.println("Premium= %20");
        } else if (Objects.equals(bazkideS,"Urre") && Objects.equals(bazkideB,true)) {
            System.out.println("Urre= %15");
        }else if (Objects.equals(bazkideS,"Zilar") && Objects.equals(bazkideB,true)) {
            System.out.println("Zilar= %10");
        }
    }


    public String toString (){
        if (Objects.equals(bazkideB,true)) {
            return "Izena= "+this.izena+" NAN= "+this.NAN+" Bezero-Maila= "+this.bazkideS;}
        else {
            return "Izena= "+this.izena+" NAN= "+this.NAN;
        }
    }

    //Nan-a hemateko
    public String emanNAN(){
        return NAN;
    }



}
