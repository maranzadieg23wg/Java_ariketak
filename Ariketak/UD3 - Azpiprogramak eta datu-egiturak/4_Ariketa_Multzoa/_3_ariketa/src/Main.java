import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [][] matrizea = new int[3][3];
        int [][] matrizea2 = new int[3][3];
        int [][] matrizea3 = new int[3][3];




        //System.out.println("Bete 4x4 matrize bat zenbaki osoekin:");

        //zenbakiak gehitzen ditut bi matrizetara, zenbakiak aleatorioak dira
        for (int i = 0;i< matrizea.length;i++){
            for (int e = 0;e<matrizea.length;e++){
                matrizea[i][e]=(int)(Math.random()*9);
                matrizea2[i][e]=(int)(Math.random()*9);


                //Bi matrizetako zenbakiak batzen dira hemen
                matrizea3[i][e]=matrizea[i][e] + matrizea2[i][e];
            }
        }


        //3 matrizeak inprimatzen
        System.out.println("Hau da lehen matrizea: ");
        inprimatu(matrizea);

        System.out.println("Hau da bigarren matrizea: ");
        inprimatu(matrizea2);

        System.out.println("Hau da hirugarren matrizea: ");
        inprimatu(matrizea3);


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