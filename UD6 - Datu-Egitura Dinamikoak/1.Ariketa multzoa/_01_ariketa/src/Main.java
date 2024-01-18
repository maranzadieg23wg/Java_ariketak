import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {




        ArrayList<Integer> zenbakiList = new ArrayList<>();


        int zenbakia = eskatu();

        zenbakiList = zenbakiList(zenbakiList, zenbakia);



        System.out.print(zenbakiList.size());
        erakutsi(zenbakiList);





    }

    public static int eskatu(){
        System.out.print("Sartu zenbaki bat: ");
        Scanner sc = new Scanner(System.in);
        int zenbakia = sc.nextInt();

        ArrayList<Integer> zenbakiList = new ArrayList<>();
        zenbakiList=zenbakiList(zenbakiList, zenbakia);
        if (zenbakiList.size()<10){
            System.out.println("Sartutako zenbakiak ez ditu 10 zatitzaile 10 zenbakiarekin.");
            eskatu();
        }


        return  zenbakia;
    }

    public static ArrayList zenbakiList(ArrayList list, int zenbakia){

        Iterator<Integer> it = list.iterator();

        int z =0;
        while (list.size()<10){



            System.out.print("z: "+z+" ");
            z++;
            if (zatiHamar(z)){
                list.add(zenbakia);
            }

        }
        return list;
    }

    public static boolean zatiHamar(int zenbakia){


        if (zenbakia %10 ==0){
            System.out.println("True");
            return true;
        }else {
            System.out.println("False");

            return false;
        }

    }

    public static void erakutsi (ArrayList list){

        Iterator<Integer> it = list.iterator();

        int z =0;
        while (it.hasNext()){



            System.out.print(" "+list.get(z));
            //System.out.print("Z"+z);
            z++;
        }
    }



}