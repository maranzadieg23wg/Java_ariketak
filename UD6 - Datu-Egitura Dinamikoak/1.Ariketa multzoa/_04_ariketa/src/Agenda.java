import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Agenda {


    HashMap<String, int[]> agenda = new HashMap<>();
    private int zenbat;

    public Agenda(int zenbat) {
        this.zenbat = zenbat;
    }

    void gehituSarrera(String izena, int[] telefonoak){

        if (agenda.size()+1>this.zenbat){
            System.out.println("Agenda beteta dago");
        }else {

            if (agenda.get(izena) ==null){
                agenda.put(izena, telefonoak);
            }else {
                Scanner sc = new Scanner(System.in);
                boolean egokia = false;

                System.out.println("Agendan "+izena+" pertsonarentzat "+ Arrays.toString(agenda.get(izena)) +" telefonoak daude.");
                System.out.println("Nahi dituzu aldatu, hemandako telefonoen gatik?");
                while (egokia){
                    System.out.println("BAI/EZ");
                    String erantzuna = sc.nextLine();
                    if (erantzuna.equals("BAI")|| erantzuna.equals("EZ") || erantzuna.equals("bai") || erantzuna.equals("ez")){
                        egokia = true;
                        if (erantzuna.equals("BAI")|| erantzuna.equals("bai")){
                            agenda.remove(izena);
                            agenda.put(izena, telefonoak);
                        }
                    }
                }

            }
        }

    }

    void erakutsi(){

        Iterator<String> it = agenda.keySet().iterator();
        while (it.hasNext()){
            String izena = it.next();
            int [] telefonoak = agenda.get(izena);
            System.out.println(izena + Arrays.toString(telefonoak));
            System.out.println("---------------------------------------");
        }
    }

    void bilatuIzena(String izena){

        int [] telefonoak = agenda.get(izena);
        if (telefonoak ==null){
            System.out.println(izena+" pertsona ez dago agendan");
        }else {
            System.out.println(izena + Arrays.toString(telefonoak));
        }
    }

    int zenbakiKopurua(int telefonoa){
        int zenbat =0;
        Iterator<String> it = agenda.keySet().iterator();
        while (it.hasNext()){
            String izena = it.next();
            int [] telefonoak = agenda.get(izena);
            for (int i =0;i<telefonoak.length;i++){
                if (telefonoak[i]==telefonoa){
                    //System.out.println(izena+ Arrays.toString(telefonoak));
                    zenbat++;
                }
            }
        }

        return zenbat;

    }

}

