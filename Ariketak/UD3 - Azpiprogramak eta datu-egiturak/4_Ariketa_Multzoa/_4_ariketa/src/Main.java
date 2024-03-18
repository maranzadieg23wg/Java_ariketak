import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [][] matrizea = new int[3][3];
        int [][] matrizea2 = new int[3][3];




        //System.out.println("Bete 4x4 matrize bat zenbaki osoekin:");

        //zenbakiak gehitzen ditut lehenengo matrizera
        for (int i = 0;i< matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                matrizea[i][e]=(int)(Math.random()*9);
            }
        }

        //matrizetako zenbakiak lekuz aldatzen ditu
        for (int i = 0;i< matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                matrizea2[e][i]=matrizea[i][e];
            }
        }


        //3 matrizeak inprimatzen
        System.out.println("Hau da sarrerako matrizea: ");
        inprimatu(matrizea);

        System.out.println("Hau da emaitza matrizea: ");
        inprimatu(matrizea2);




        sc.close();

    }

    public static void inprimatu (int [] []matrizea){

        //inprimatzen du matrizea
        //System.out.println("Hau da bukaerako matrizea: ");

        for (int i = 0;i<matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                System.out.print(matrizea[i][e]+"  ");
            }
            System.out.println(" ");
        }

        //return matrizea[1][1];

    }
}