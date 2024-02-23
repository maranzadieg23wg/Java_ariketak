import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Instant hasiera = Instant.now();
        ArrayList<Integer> lista = random(25000);

        erakutsi(lista);

        Instant bukaera = Instant.now();
        System.out.println(Duration.between(hasiera, bukaera));

        //System.out.println("--------------------------------------");
        //lista = ordenatu(lista);

        //erakutsi(lista);
    }


    public static ArrayList<Integer> random(int zenbat){

        ArrayList<Integer> lista = new ArrayList<>();

        for (int i =0;i<zenbat;i++){
            Integer zenbakia = (int)Math.floor(Math.random()*(200-0+1)+0);
            lista.add(zenbakia);
        }
        erakutsi(lista);
        System.out.println("-----------------------------");
        return ordenatu(lista);

    }

    public static ArrayList<Integer>aldatu(int p1, int p2,ArrayList<Integer>lista){
        int z1 = lista.get(p1);
        int z2 = lista.get(p2);

        int temp = z1;
        z1 = z2;
        z2 = temp;

        lista.set(p1, z1);
        lista.set(p2, z2);
        return lista;
    }
    public static ArrayList<Integer> ordenatu(ArrayList<Integer> lista){
        int hasiera =0;
        int bukaera = lista.size()-1;

        while (hasiera<=bukaera){
            int berriHasiera = hasiera;
            int berriBukaera = bukaera;

            for (int i =berriHasiera;i<berriBukaera;i++){
                if (lista.get(i)> lista.get(i+1)){
                    aldatu(i, i + 1, lista);
                }
            }
            bukaera = berriBukaera-1;
            for (int i =berriBukaera;i>berriHasiera;i--){
                if (lista.get(i)< lista.get(i-1)){
                    aldatu(i, i - 1, lista);
                }
            }

            hasiera = berriHasiera+1;
        }


        //lista.set(0, hasiera);
        //lista.set(lista.size()-1,bukaera);
        //System.out.println(lista.size());
        return lista;

    }



    public static void erakutsi(ArrayList<Integer> lista){


        for (Integer zen:lista) {
            System.out.print(zen+" - ");
        }
        System.out.println(" ");
    }
}

