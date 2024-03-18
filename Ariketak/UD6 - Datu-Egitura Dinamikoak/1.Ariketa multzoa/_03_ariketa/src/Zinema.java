import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Zinema {

    private String izena;

    private ArrayList<Pelikula> pelikulaList = new ArrayList<>();

    private Pelikula aretoa[];

    Scanner sc = new Scanner(System.in);

    public Zinema(String izena, int kopurua) {
        this.izena = izena;
        this.aretoa = new Pelikula [kopurua+1];
        aretoa[0] = new Pelikula("???", 0, 0);
    }

    int pelikularenAretoa(String izenburua, int urtea, int iraupena){
        for (int i =0;i<aretoa.length;i++){


            if (aretoa[i] !=null){
                boolean berbera = aretoa[i].equals(new Pelikula(izenburua, urtea, iraupena));
                if (berbera){
                    return i+1;
                }
            }

        }

        return -1;
    }

    public void gehituPelikula(Pelikula pelikula){

        pelikulaList.add(pelikula);
        int zineman = pelikularenAretoa(pelikula.getIzenburua(), pelikula.getUrtea(), pelikula.getIraupena());

        boolean libre = true;

        if (zineman != -1){
            System.out.println(pelikula.getIzenburua()+" pelikula zineman dago "+zineman+" aretoan");
        }else {
            for (int i =0;i<aretoa.length;i++){

                if (aretoa[i]==null){
                    aretoa[i]=pelikula;
                    i = aretoa.length+2;
                    libre = true;
                }else {
                    libre = false;
                }

            }
        }
        if (!libre){
            System.out.println("Zinemako areto guztiak okupatuta daude beste pelikulekin.");
        }

    }

    public void gehituPelikula(Pelikula pelikula, int aretoNum){

        pelikulaList.add(pelikula);

        int zineman = pelikularenAretoa(pelikula.getIzenburua(), pelikula.getUrtea(), pelikula.getIraupena());

        boolean libre = true;

        if (zineman != -1){
            System.out.println(pelikula.getIzenburua()+" pelikula zineman dago "+zineman+" aretoan");
        }else {
            if (aretoa[aretoNum]==null){
                aretoa[aretoNum]=pelikula;
                libre = true;
            }else {
                libre = false;
            }
        }
        if (!libre){
            System.out.println("Zinemako "+aretoNum+" sala okupatuta dago "+ aretoa[aretoNum].getIzenburua()+" pelikularekin.");
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

        Iterator<Pelikula> it = this.pelikulaList.iterator();

        while (it.hasNext()){
            Pelikula pelikula = it.next();
            if(pelikula.getIzenburua().startsWith(izena)){
                it.remove();
                int i = pelikularenAretoa(pelikula.getIzenburua(), pelikula.getUrtea(), pelikula.getIraupena());
                aretoa[i]=null;
            }
        }

    }

    public ArrayList<Integer> aretoLibreak(){

        ArrayList<Integer> libre = new ArrayList<>();

        for (int i=1;i<aretoa.length;i++){

            if (aretoa[i]==null){
                libre.add(i);
            }

        }
        return libre;
    }

    public void garbituZinema(){

        pelikulaList.clear(); 

        for (int i =1; i<aretoa.length;i++){
            aretoa[i]= null;
        }
    }

    public void aldatuAretoa(Pelikula pelikula){

        int zineman = pelikularenAretoa(pelikula.getIzenburua(), pelikula.getUrtea(), pelikula.getIraupena());
        boolean mugituta = false;

        if (zineman == -1){
            System.out.println(pelikula.getIzenburua()+" ez dago zinemako aretotan.");
        }else {
            System.out.println(zineman+" aretoan dago pelikula");


            System.out.println("Zein aretora nahi duzu mugitu pelikula?");
            while (!mugituta){
                int kodea = sc.nextInt();

                if (aretoa[kodea]==null){
                    ezabatuPelikula(pelikula.getIzenburua());
                    gehituPelikula(pelikula, kodea);
                    mugituta = true;

                }else {
                    System.out.println(kodea+" posizioan "+aretoa[kodea].getIzenburua()+" pelikula dago eta ezin da bertan sartu.");
                    System.out.println("Sartu beste areto bat.");
                }
            }




        }

    }


    public ArrayList<Pelikula> motzagoakBaino(int denboraMin){

        ArrayList<Pelikula> gutxiago = new ArrayList<>();

        for (int i =0;i<pelikulaList.size();i++){

            int iraupena = pelikulaList.get(i).getIraupena();

            if (denboraMin > iraupena){
                gutxiago.add(pelikulaList.get(i));
            }


        }

        return gutxiago;
    }

    public ArrayList<Pelikula> motzagoakBaino(int denboraHor, int denboraMin){

        int denbora = (denboraHor*60)+denboraMin;

        return motzagoakBaino(denbora);
    }

    

}
