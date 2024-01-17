public class Txori {

    private char sexua;
    private int adina;
    private static int txoriKop = 0;

    Txori(char sexua, int adina) {
        this.sexua = sexua;
        this.adina = adina;
        txoriKop++;
    }

    static int getTxoriKop(){
        return txoriKop;
    }

    void norNaiz(){
        System.out.println("------------------------------");
        System.out.println("Sexua: "+sexua);
        System.out.println("Adina: "+adina);
        System.out.println("------------------------------");
    }


}
