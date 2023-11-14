import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int zenbat =11;

        String [][]matrizea = new String[zenbat][zenbat];

        zenbat = zenbat/2;

        int counter = 3;


        for (int e = 0; e < zenbat; e++){

            //Hemen inprimatzen da * herdia.
            for (int i = e; i < zenbat; i++){
                System.out.print("* ");
            }
            //Gero imprimatu behar du azkeneko asteriskoa
            if (e ==0){
                System.out.print("* ");
            }

            //Lehenengo bueltan ez denez imprimatzen  , inprimatu behar dugu "* " utsunearekin-


            if(e != 0){
                for (int i = 0; i < counter-1; i++){
                    System.out.print("1");
                    System.out.print(" ");
                }
                System.out.print("1 ");
            }

            for (int i = e; i < zenbat; i++){
                System.out.print("* ");
            }


            System.out.println(" ");

            //Buelta bakoitzean inprimatu behar den utzunea +2 egiten du
            if (e!=0){
                counter += 2;
            }

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