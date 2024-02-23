import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Instant hasiera = Instant.now();
        ArrayList<Integer> lista = random(7);

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
        //System.out.println("-----------------------------");
        return ordenatu(lista);

    }


    public static ArrayList<Integer> ordenatu(ArrayList<Integer> lista){

        banatu(lista);


        return lista;
    }

    public static ArrayList<Integer> banatu(ArrayList<Integer>lista){

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l0 = new ArrayList<>();
        int luzeera = lista.size();
        //System.out.println(luzeera);
        if (luzeera >=1){

            for (int i =0;i<lista.size();i++){
                if (i<luzeera/2){
                    l1.add(lista.get(i));
                    //System.out.print("l1: "+lista.get(i)+" ");
                }else {
                    l2.add(lista.get(i));
                    //System.out.print("l2: "+lista.get(i)+" ");
                }
            }
            //System.out.println(" ");
            banatu(l1);
            banatu(l2);
            l0 = batu(l1, l2);

        }else {
            l0.add(lista.get(0));
        }

        return l0;

    }

    public static ArrayList<Integer> batu (ArrayList<Integer>l1, ArrayList<Integer>l2){
        ArrayList<Integer> l0 = new ArrayList<>();

        while (!l1.isEmpty() && !l2.isEmpty()){
            if (l1.get(0)<= l2.get(0)){
                l0.add(l1.get(0));
                l1.remove(0);
            }else {
                l0.add(l2.get(0));
                l2.remove(0);

            }
        }

        if (l1.size()>0){
            l0.addAll(l1);
        }
        if (l2.size()>0){
            l0.addAll(l2);
        }

        return l0;
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


    public static void erakutsi(ArrayList<Integer> lista){


        for (Integer zen:lista) {
            System.out.print(zen+" - ");
        }
        System.out.println(" ");
    }
}

