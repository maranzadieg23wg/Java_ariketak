import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int zenbat =11;

        String [][]matrizea = new String[zenbat][zenbat];

        zenbat = zenbat/2;
        for (int i =0;i<zenbat+1;i++){

            for (int e =zenbat;e>i;e--){
                System.out.print("*");
               // matrizea[i][e]="*";
            }

            for (int r =zenbat;r<i*2;r++){
                System.out.print(" ");
                //matrizea[i][r]="1";
            }

            for (int e =zenbat;e>i;e--){
                //System.out.print("*");
                // matrizea[i][e]="*";
            }




            System.out.println(" ");

        }
        //Buelta heman






        //imprimatu(matrizea,zenbat,zenbat);


    }

    public static void imprimatu (String [][]matrizea, int goraka, int eskubira){

        for (int i=0;i<goraka;i++){
            for (int e =0;e<eskubira;e++){
                System.out.print(matrizea[i][e]+" ");
            }
            System.out.println(" ");
        }
    }
}