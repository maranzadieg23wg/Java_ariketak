package elementuak;

public class Elementu {

    private int kodea;
    private String izenburua;
    private String egilea;

    Elementu(int kodea, String izenburua, String egilea){
        this.kodea = kodea;
        this.izenburua = izenburua;
        this.egilea = egilea;
    }

    public void erakutsi(){
        System.out.println("Kodea: "+kodea+" Izenburua: "+izenburua+" Egilea: "+egilea);
    }

    public  int getKodea(){
        return kodea;
    }

    public String getIzenburua(){
        return izenburua;
    }
    public String getEgilea(){
        return  egilea;
    }
}
