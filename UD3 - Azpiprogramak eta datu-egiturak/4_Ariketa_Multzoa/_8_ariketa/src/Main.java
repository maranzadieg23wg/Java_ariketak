import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        /*System.out.println("Sartu matrizearen errenkada kopurua: ");
        int errenkada = sc.nextInt();

        System.out.println("Sartu matrizearen zutabe kopurua: ");
        int zutabe = sc.nextInt();*/


        int errenkada = 7;
        int zutabe = 7;

        int [][] matrizea = new int[errenkada][zutabe];
        //int [][] matrizea2 = new int[zutabe][errenkada];


        //System.out.println("Bete 4x4 matrize bat zenbaki osoekin:");

        //zenbakiak gehitzen ditut matrizera
        for (int i = 0;i< errenkada;i++){
            for (int e = 0;e<zutabe;e++){
                matrizea[i][e]=(int)(Math.random()*9);
            }
        }



        //matrizea inprimatzen du
        System.out.println("Hau da sarrerako matrizea: ");
        inprimatu(matrizea,errenkada,zutabe);



        for (int i = 0; i<errenkada;i++){
            System.out.print(i+". errenkadaren batura hau da: "+kontatuErrenkada(matrizea, i));
            System.out.println(" ");
        }

        for (int i = 0; i<zutabe;i++){
            System.out.print(i+". zutabearen batura hau da: "+kontatuZutabe(matrizea, i));
            System.out.println(" ");
        }





        sc.close();

    }

    public static void inprimatu (int [] []matrizea, int errenkada, int zutabe){

        //inprimatzen du matrizea
        //System.out.println("Hau da bukaerako matrizea: ");

        for (int i = 0;i<errenkada;i++){
            for (int e = 0;e<zutabe;e++){
                System.out.print(matrizea[i][e]+"  ");
            }
            System.out.println(" ");
        }

        //return matrizea[1][1];

    }

    public static int kontatuErrenkada (int [] []matrizea, int errenkada){

        int zenbat = 0;

        for (int e = 0;e<matrizea[errenkada].length;e++){
            zenbat+=matrizea[errenkada][e];
        }

        return zenbat;
    }

    public static int kontatuZutabe (int [] []matrizea, int zutabe){

        int zenbat = 0;

        for (int e = 0;e<matrizea.length;e++){
            zenbat+=matrizea[e][zutabe];
        }

        return zenbat;
    }
}