abstract class Txori{

    private DatuPertsonal izenak;

    private char sexua;
    private int adina;
    private static int txoriKop = 0;

    Txori(char sexua, int adina, DatuPertsonal izenak) {
        this.sexua = sexua;
        this.adina = adina;
        txoriKop++;
        this.izenak = izenak;
    }

    static int getTxoriKop(){
        return txoriKop;
    }

    void norNaiz(){
        System.out.println("------------------------------");
        System.out.println("Sexua: "+sexua);
        System.out.println("Adina: "+adina);
        System.out.println("Izena: "+getTxoriIzena());
        System.out.println("Jabe Izena: "+getJabeIzena());
        System.out.println("------------------------------");
    }

    abstract void abestu();

    public String getTxoriIzena(){
        return izenak.getTxoriIzena();
    }

    public String getJabeIzena(){
        return izenak.getJabeIzena();
    }

    public void setJabeIzena(String izena){
        izenak.setJabeIzena(izena);
    }

    public void setTxoriIzena(String izena){
        izenak.setTxoriIzena(izena);
    }

}
