public class Txori {

    private char sexua;
    private int adina;
    static int txoriKop = 0;

    public Txori(char sexua, int adina) {
        this.sexua = sexua;
        this.adina = adina;
        txoriKop++;
    }

    public static int getTxoriKop(){
        return txoriKop;
    }

    public void norNaiz(){
        System.out.println("------------------------------");
        System.out.println("Sexua: "+sexua);
        System.out.println("Adina: "+adina);
        System.out.println("------------------------------");
    }


}
