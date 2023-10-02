import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int bueltak = 0;
        byte egia = 0;
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> zenbakiGuztiak = new ArrayList<>();


        //System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.nextLine(); // consume the newline

        for (int i = 0; i < zenbat; i++) {
            egia = 0;
            bueltak = 0;
            //System.out.println("Sartu zenbaki bat:");
            String zenbakiak = sc.nextLine();
            if (zenbakiak.length() < 4){
               //System.out.println("Sartutako zenbakiak ez ditu 4 karaketere");
                System.exit(0);
            }
            int V_X = Integer.parseInt(zenbakiak);
            if (V_X == 6174){
                bueltak = -1;
            }


            long kaprekar = kontatu(zenbakiak);
            while (egia ==0){
                bueltak++;
                if (kaprekar == 1111){
                    egia =1;
                    //System.out.println("8");
                    zenbakiGuztiak.add(8);
                }

                if (kaprekar == 6174){
                    egia =1;
                    //System.out.println(bueltak);
                    zenbakiGuztiak.add(bueltak);
                }else {
                    //System.out.println("ez");
                    zenbakiak = String.valueOf(kaprekar);
                    kaprekar = kontatu(zenbakiak);

                }
            }


        }

        sc.close();


        for (int i = 0;i <zenbakiGuztiak.size();i++){
            System.out.println(zenbakiGuztiak.get(i));
        }
    }

    public static long kontatu(String hitza) {

        //System.out.println("kalkulatzen");
        int total = 0;

        ArrayList<Integer> lista = new ArrayList<>();



        for (int i = 0; i < hitza.length(); i++) {
            int V_X = Character.getNumericValue(hitza.charAt(i));
            lista.add(V_X);

        }

       /* for (int i = 0; i < lista.size(); i++) {
            for (int j = i+1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j))) {
                    System.out.println("Sartutako zenbakia repdigits da");
                    System.exit(0);
                }
            }
        }*/

        if (lista.size()==3){
            lista.add(0);
        }else if (lista.size()==2){
            lista.add(0);
            lista.add(0);
        } else if (lista.size()==1) {
            lista.add(0);
            lista.add(0);
            lista.add(0);
        }

        if (lista.get(0).equals(lista.get(1)) && lista.get(1).equals(lista.get(2)) && lista.get(2).equals(lista.get(3)) && lista.get(3).equals(lista.get(0))){
            //System.out.println("Sartutako zenbakia repdigits da");
            //System.out.println("8");
            return 1111;
        }


        Collections.sort(lista);




        int z1 = konkatenatu (lista.get(0), lista.get(1), lista.get(2), lista.get(3));
        int z2 = konkatenatu (lista.get(3), lista.get(2), lista.get(1), lista.get(0));
        //System.out.println("z1 "+z1);
        //System.out.println("z2 "+z2);



        total = z2-z1;

        return total; // return a value
    }

    public static int konkatenatu (int z1, int z2, int z3, int z4){
       // System.out.println(z1+" " +z2+" "+ z3+" "+z4);
        String cadenaResultante = String.valueOf(z1) + String.valueOf(z2) + String.valueOf(z3) + String.valueOf(z4);
        return  Integer.parseInt(cadenaResultante);

    }
}
