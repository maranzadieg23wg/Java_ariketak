public class Txori {

    private char sexua;
    private int adina;
    int txoriKop;

    public Txori(char sexua, int adina) {
        this.sexua = sexua;
        this.adina = adina;
        this.txoriKop = 0;
    }

    public int getTxoriKop(){
        return txoriKop;
    }

    public void norNaiz(){
        System.out.println("------------------------------");
        System.out.println("Sexua: "+sexua);
        System.out.println("Adina: "+adina);
        System.out.println("------------------------------");
    }
}
