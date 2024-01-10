package elementuak;


public class Liburu extends Elementu {

    int orrialdeKop;

    public Liburu (int kodea, String izenburua, String egilea, int orrialdeKop){
        super(kodea, izenburua, egilea);
        this.orrialdeKop = orrialdeKop;
    }

    public String kodeOsoa(){
        return "Kodea: "+getKodea()+" Izenburua: "+getIzenburua+" Orrialde Kopurua: "+orrialdeKop;
    }
}
