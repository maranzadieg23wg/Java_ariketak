public class Bezero {

    private String izena;
    private String NAN;
    private boolean bazkide;
    private String maila;

    public Bezero (String izena, String NAN){
        this.izena = izena;
        this.NAN = NAN;
        this.bazkide = false; //←Bezero bat sortzean maila gabe, inoiz ez da izango bazkide, orduan beti bazkide 'false' izango da.
    }

    public Bezero(String izena, String NAN, String maila){
        this.izena = izena;
        this.NAN = NAN;
        this.bazkide = true; //←Maila bat ezartzen badiogu bazkideari, beti izango da bazkide, orduan bazkide izango da 'true'
        this.maila = maila;
    }

    public double jasoDeskontua(/*float zenbat*/){ //←Bueltatzen dugu zein den bere deskontua, beste funtzio batean kalkulatzen da zenbat izango den azkeneko prezioa.

        if (!bazkide){ //←Ez bada bazkide, bere deskontu maila izango da 0, orduan zuzenean bueltatzen da 0
            return 0;
        }

        switch (this.maila){ //←Lortzen dugu bere maila, ondoren begiratzeko zein maila daukan.
            case "Premium":
                return (0.2);
                //break;

            case "Urre":
                return (0.15);
                //break;

            case "Zilar":
                return (0.1);
                //break;

            default:
                return 0; //←Maila gaizki egongo balitz sartuta, bere deskontua 0 izango zen badazpadare.
                //break;;
        }



    }



    public String toString(){ //←Funtzio honek bueltatzen du bezeroaren datuak.
        /*
        if (!bazkide){
            return "Izena: "+ izena+" -- NAN: "+NAN+" -- ";
        }else {
            return "Izena: "+ izena+" -- NAN: "+NAN+" -- Bazkide: "+bazkide+" -- Maila: "+maila+" -- ";
        }*/
        return "Izena: "+ izena+" -- NAN: "+NAN+" -- Bazkide: "+bazkide+" -- Maila: "+maila+" -- "; //←Bueltatzen ditu bezeroaren datu guztiak, bazkide den a la ez eta bere maila.

    }

    public void setBazkide(boolean bazkide) { //←Esaten diogu aldatzea bazkide den a la ez.

        this.bazkide = bazkide; //←Jasotzen dugun boolean balorea esartzen zaio.

        if (!this.bazkide){ //←Ezarri ondoren bazkiden den a la ez, ikusten bada bazkide = 'false' dela, automatikoki bere maila null izango da. Horrela deskontua lortzean, beti bueltatuko du 0 gaizki detektatzen bada bazkide balorea.
            this.maila = null;
        }
    }

    public void setMaila(String maila){ //←Ezartzen zaio maila berri bat.

        this.maila = maila; //←Esleitzen da esandako bazkide maila. Apaindegi objetuko funtzio batean konprobatzen da ea maila ezistitzen den a la ez.
        setBazkide(true); //←Maila bat edukita, bazkide izango da automatikoki, orduan bidaltzen dugu setBazkidera esanez bazkide dela.
    }

    public String getNAN(){
        return NAN;
    } //←Bezeroaren NAN String-a bueltatzen du. String hau erabiltzen da identifikatzeko bezeroak.
}
