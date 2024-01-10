public class Elementuak {

    int kodea;
    String izenburua;
    String egilea;

    Elementuak (int kodea, String izenburua, String egilea){
        this.kodea = kodea;
        this.izenburua = izenburua;
        this.egilea = egilea;
    }

    public void erakutsi(){
        System.out.println("Kodea: "+kodea+" Izenburua: "+izenburua+" Egilea: "+egilea);
    }

}
