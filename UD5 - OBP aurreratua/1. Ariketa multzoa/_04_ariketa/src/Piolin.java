public class Piolin extends  Kanario{

    private int peliKop;
    Piolin(char sexua, int adina, float tamaina, int peliKop, DatuPertsonal izena) {
        super(sexua, adina, tamaina, izena);
        this.peliKop = peliKop;
    }

    void abestu(){
        System.out.println("Nire izena " + getTxoriIzena()+" da eta pio-pio abesten dut.");
    }


}
