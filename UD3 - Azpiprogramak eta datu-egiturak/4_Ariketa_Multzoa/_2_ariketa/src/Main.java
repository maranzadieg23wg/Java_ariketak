import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [][] matrizea = new int[4][4];




        System.out.println("Bete 4x4 matrize bat zenbaki osoekin:");
        
        //zenbakiak gehitzen ditut matrizera.
        for (int i = 0;i< matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                matrizea[i][e]=sc.nextInt();
            }
        }

        inprimatu(matrizea);


        sc.close();

    }

    public static void inprimatu (int [] []matrizea){

        //inprimatzen du matrizea
        System.out.println("Hau da bukaerako matrizea: ");

        for (int i = 0;i<matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                System.out.print(matrizea[i][e]+"  ");
            }
            System.out.println(" ");
        }

        //return matrizea[1][1];

    }
}