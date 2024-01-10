abstract class Langile {

    private String izena;
    private String abizena;
    private int gsz;

    public Langile(String izena, String abizena, int gsz){
        this.izena = izena;
        this.abizena=abizena;
        this.gsz=gsz;
    }

    public String toString(){
        return "Izena: "+izena+" Abizena:"+abizena+ "GSZ: "+gsz;
    }




}
