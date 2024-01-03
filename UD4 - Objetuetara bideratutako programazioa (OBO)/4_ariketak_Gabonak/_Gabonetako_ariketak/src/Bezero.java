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

    public double jasoDeskontua(float zenbat){

        switch (this.maila){
            case "Premium":
                return (zenbat *0.2);
                //break;

            case "Urre":
                return (zenbat *0.15);
                //break;

            case "Zilar":
                return (zenbat *0.2);
                //break;

            default:
                return zenbat;
                //break;;
        }

    }

    public String toString(){
        if (!bazkide){
            return "Izena: "+ izena+" -- NAN: "+NAN;
        }else {
            return "Izena: "+ izena+" -- NAN: "+NAN+" -- Bazkide: "+bazkide+" -- Maila: "+maila;
        }

    }

}
