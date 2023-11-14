import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int zenbat =11;


        zenbat = zenbat/2;

        int counter = 3;

        int counter1 = zenbat*2-2;


        for (int e = 0; e < zenbat; e++){

            //Hemen inprimatzen da * herdia.
            for (int i = e; i < zenbat; i++){
                System.out.print("* ");
            }
            //Gero imprimatu behar du azkeneko asteriskoa
            if (e ==0){
                System.out.print("* ");
            }

            if(e != 0){
                for (int i = 0; i < counter-1; i++){
                    System.out.print(" ");
                    System.out.print(" ");
                }
                System.out.print("  ");
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

        //Hemen imprimatzen da herdiko * seguida
        for (int e = 0; e < 1; e++){
            //Hemen inprimatzen da * herdia.
            for (int i = e; i < zenbat*2; i++){
                System.out.print("* ");
            }
            //Gero imprimatu behar du azkeneko asteriskoa
            System.out.println("* ");
        }

        //Alderantziz
        for (int e = zenbat-1; e > 0; e--){

            //Hemen inprimatzen da * herdia.

            for (int i = zenbat; i > e; i--) {

                System.out.print("* ");

            }

            //Gero imprimatu behar du azkeneko asteriskoa

            if (e == zenbat) {
                System.out.print("* ");
            }


            for (int i = 0; i < counter1; i++){
                System.out.print(" ");
                System.out.print(" ");
            }
            System.out.print("  ");


            for (int i = zenbat; i > e; i--) {
                System.out.print("* ");
            }
            System.out.println(" ");


            //Buelta bakoitzean inprimatu behar den utzunea +2 egiten du

            counter1 -= 2;


        }

        //Hemen imprimatzen da azkeneko * seguida
        for (int e = 0; e < 1; e++){
            //Hemen inprimatzen da * herdia.
            for (int i = e; i < zenbat*2; i++){
                System.out.print("* ");
            }
            //Gero imprimatu behar du azkeneko asteriskoa
            System.out.println("* ");
        }









    }


}