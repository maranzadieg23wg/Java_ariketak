import javax.swing.*;
import java.util.ArrayList;

public class Zinema {

    private String izena;

    private ArrayList<Pelikula> pelikulaList = new ArrayList<>();

    private Pelikula aretoa[];

    public Zinema(String izena, int kopurua) {
        this.izena = izena;
        this.aretoa = new Pelikula [kopurua+1];
        aretoa[1] = new Pelikula("???", 0, 0);
    }

    public int pelikularenAretoa(String izenburua, int urtea, int iraupena){
        for (int i =0;i<aretoa.length;i++){


            boolean berbera = aretoa[i].equals(new Pelikula(izenburua, urtea, iraupena));
            if (berbera){
                return i+1;
            }
        }

        return -1;
    }

    public void gehituPelikula(Pelikula pelikula){

        int libre=-1;
        boolean zineman = false;

        for (int i =0;i<aretoa.length;i++){
            if (aretoa[i]==null && libre ==-1){
                libre = i;
            }
            if (aretoa[i].equals(pelikula)){
                zineman = true;
            }
        }

        if (!zineman && libre !=-1){
            aretoa[libre]=pelikula;
        }

        if (zineman){
            System.out.println(pelikula.getIzenburua()+" pelikula zineman dago.");
        }

        if (libre ==-1){
            System.out.println("Zinemako areto guztiak okupatuta daude.");
        }


    }

    public void gehituPelikula(Pelikula pelikula, int aretoNum){

        boolean zineman = false;

        for (int i =0;i<aretoa.length;i++){
            if (aretoa[i].equals(pelikula)){
                zineman = true;
                i = aretoa.length+2;
            }
        }

        if (!zineman && aretoa[aretoNum]==null){
            aretoa[aretoNum]=pelikula;
        }

        if (zineman){
            System.out.println(pelikula.getIzenburua()+" pelikula zineman dago.");
        }

        if (aretoa[aretoNum]!=null){
            System.out.println(aretoNum+" aretoa ez dago libre.");
        }

    }

    public void erakutsi(){

        System.out.println(this.izena);
        for (int i =1;i<aretoa.length;i++){
            if (aretoa[i]!=null){
                Pelikula pelikula = aretoa[i];
                System.out.println(pelikula.getIzenburua()+" - Room "+i);
            }
        }
    }

    public void ezabatuPelikula(String izena){
        for (int i =1;i<aretoa.length;i++){

            Pelikula pelikula = aretoa[i];

            if (pelikula.getIzenburua().equals(izena)){
                aretoa[i]=null;
            }
        }
    }

    public ArrayList<Integer> aretoLibreak(){

        ArrayList<Integer> libre = new ArrayList<>();

        for (int i=1;i<aretoa.length;i++){

            if (aretoa[i]!=null){
                libre.add(i);
            }

        }
        return libre;
    }

    

}
