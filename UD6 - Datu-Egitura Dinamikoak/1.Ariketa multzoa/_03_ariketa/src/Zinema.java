import java.util.ArrayList;

public class Zinema {

    private String izena;

    private ArrayList<Pelikula> pelikulaList = new ArrayList<>();

    private Pelikula aretoa[];

    public Zinema(String izena, int kopurua) {
        this.izena = izena;
        this.aretoa = new Pelikula [kopurua];
    }

    public int pelikularenAretoa(String izenburua, int urtea, int iraupena){
        for (int i =0;i<aretoa.length;i++){


            boolean berbera = aretoa.equals(new Pelikula(izenburua, urtea, iraupena));
            if (berbera){
                return i+1;
            }


        }

        return 0;
    }

    public void gehituPelikula(Pelikula pelikula){

        for (int i =0;i<aretoa.length;i++){
            if (aretoa[i]==null){
                aretoa[i]=pelikula;
                i = aretoa.length+2;
            }
        }

    }


}
