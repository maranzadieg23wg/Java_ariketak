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
                if (i+e == 6){
                    matrizea[i][e]=1;
                }


            }
        }



        //2 matrizeak inprimatzen
        System.out.println("Hau da emaitza matrizea: ");
        inprimatu(matrizea,errenkada,zutabe);








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
}