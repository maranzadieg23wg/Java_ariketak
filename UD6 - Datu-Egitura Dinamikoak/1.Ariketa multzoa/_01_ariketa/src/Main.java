import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {




        ArrayList<Integer> zenbakiList = new ArrayList<>();

        while (zenbakiList.size()<10){
            int zenbakia = eskatu();

            zenbakiList = zenbakiList(zenbakiList, zenbakia);

            if (zenbakiList.size()<10){
                zenbakiList.clear();
            }
        }




        //System.out.print(zenbakiList.size());
        erakutsi(zenbakiList);





    }

    public static int eskatu(){
        System.out.print("Sartu zenbaki bat: ");
        Scanner sc = new Scanner(System.in);
        int zenbakia = sc.nextInt();


        return  zenbakia;
    }

    public static ArrayList zenbakiList(ArrayList list, int zenbakia){

        //Iterator<Integer> it = list.iterator();

        int z =1;
        while (list.size()<10){



            //System.out.print("z: "+z+" ");

            if (zenbakia % z ==0){
                list.add(z);
            }

            if (z> zenbakia){
                return list;
            }
            z++;

        }
        return list;
    }



    public static void erakutsi (ArrayList list){

        Iterator<Integer> it = list.iterator();


        while (it.hasNext()){



            System.out.print(" "+it.next());
            //System.out.print("Z"+z);
        }
    }



}