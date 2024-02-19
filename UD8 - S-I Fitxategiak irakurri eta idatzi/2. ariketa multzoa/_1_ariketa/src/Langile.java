public class Langile {

    private String izena;
    private int soldata;
    private Mugikor mugikor;

    public Langile(String izena, int soldata, Mugikor mugikor) {
        this.izena = izena;
        this.soldata = soldata;
        this.mugikor = mugikor;
    }

    void erakutsi(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Langile{" +
                "izena='" + izena + '\'' +
                ", soldata=" + soldata +
                ", mugikor=" + mugikor +
                '}';
    }

    public void lanEgin(){
        soldata+=10;

        mugikor.deitu(15);
    }

    public void lanEgin(int zenbat, int minutu){
        soldata+=zenbat;

        mugikor.deitu(minutu);
    }


}
