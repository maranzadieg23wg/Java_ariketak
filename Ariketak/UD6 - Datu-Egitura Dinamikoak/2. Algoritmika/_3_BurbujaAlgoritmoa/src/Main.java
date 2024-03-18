import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Instant hasiera = Instant.now();
        ArrayList<Integer> lista = random(50000);

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
        return ordenatu(lista);

    }

    public static ArrayList<Integer> ordenatu(ArrayList<Integer> lista){

        for (int i =0;i<lista.size();i++){
            for (int e =0;e< lista.size()-i-1;e++){
                //System.out.println("e: "+e);
                //System.out.println("i: "+i);


                Integer z1 = lista.get(e);
                Integer z2 = lista.get(e+1);

                if (z1>z2){
                    int temp = z1;
                    z1 = z2;
                    z2 = temp;
                }
                lista.set(e, z1);
                lista.set(e+1, z2);

            }
        }
        return lista;

    }



    public static void erakutsi(ArrayList<Integer> lista){


        for (Integer zen:lista) {
            System.out.println(zen);
        }
    }
}

