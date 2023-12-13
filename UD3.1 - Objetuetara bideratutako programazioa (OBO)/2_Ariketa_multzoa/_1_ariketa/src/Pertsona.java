public class Pertsona {

    String izena;
    String DNI;
    int adina;


    Pertsona(String izena, String DNI, int adina){
        this.izena=izena;
        this.DNI=DNI;
        this.adina=adina;
    }


    public String getIzena(){
        return this.izena;
    }
    public String getDNI(){
        return this.DNI;
    }
    public int getAdina(){return this.adina;}



}
