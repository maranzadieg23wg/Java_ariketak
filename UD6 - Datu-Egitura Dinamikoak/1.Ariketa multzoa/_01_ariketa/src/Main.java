import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {




        ArrayList<Integer> zenbakiList = new ArrayList<>();

        /*while (zenbakiList.size()<10){
            int zenbakia = eskatu();

            zenbakiList = zenbakiList(zenbakiList, zenbakia);

            if (zenbakiList.size()<10){
                zenbakiList.clear();
            }
        }


        erakutsi(zenbakiList);*/

        zenbakiList = ausas(zenbakiList, 100, 50, false);
        erakutsi(zenbakiList);

        zenbakiList = ausas(zenbakiList, 20, 10, true);
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

    public static ArrayList ausas(ArrayList lista,int zenbaki, int zenbat, boolean errepikatu){

        lista.clear();
        for (int i =0;i<zenbat;i++){
            int negative = zenbaki*(-1);
            int gehitu = (int)Math.floor((Math.random()*(zenbaki - negative +1)+negative));

            if (errepikatu){
                if (!lista.contains(gehitu) || i ==0){
                    lista.add(gehitu);
                }else {
                    i--;
                }
            }else {
                lista.add(gehitu);
            }



        }

        return lista;


    }


    public static void erakutsi (ArrayList<Integer> list){

        Iterator<Integer> it = list.iterator();


        while (it.hasNext()){
            //System.out.print(it.next()+" ");
            //System.out.print("Z"+z);
            int zenbakia = it.next();

            System.out.print(zenbakia+" ");

            /*if (zenbakia==100 || zenbakia == -100 || zenbakia == 99 || zenbakia == -99){
                System.out.print(zenbakia+" ");
            }*/
        }
        System.out.println(" ");
    }



}