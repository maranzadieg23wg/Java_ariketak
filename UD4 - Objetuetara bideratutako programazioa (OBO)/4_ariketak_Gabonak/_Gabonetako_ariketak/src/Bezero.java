public class Bezero {

    private String izena;
    private String NAN;
    private boolean bazkide;
    private String maila;

    public Bezero (String izena, String NAN){
        this.izena = izena;
        this.NAN = NAN;
        this.bazkide = false;
    }

    public Bezero(String izena, String NAN, String maila){
        this.izena = izena;
        this.NAN = NAN;
        this.bazkide = true;
        this.maila = maila;
    }

    public double jasoDeskontua(/*float zenbat*/){

        if (!bazkide){
            return 0;
        }

        switch (this.maila){
            case "Premium":
                return (0.2);
                //break;

            case "Urre":
                return (0.15);
                //break;

            case "Zilar":
                return (0.2);
                //break;

            default:
                return 0;
                //break;;
        }



    }



    public String toString(){
        if (!bazkide){
            return "Izena: "+ izena+" -- NAN: "+NAN+" -- ";
        }else {
            return "Izena: "+ izena+" -- NAN: "+NAN+" -- Bazkide: "+bazkide+" -- Maila: "+maila+" -- ";
        }

    }

    //Esaten diogu bazkidea den a la ez
    public void setBazkide(boolean bazkide) {

        this.bazkide = bazkide;
    }

    public void setMaila(String maila){
        
        this.maila = maila;
        setBazkide(true);
    }

    public String getNAN(){
        return NAN;
    }
}
