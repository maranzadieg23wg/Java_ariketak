import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        System.out.println("Sartu matrizearen errenkada kopurua: ");
        String erromatarZenbakia = sc.nextLine();

        String []zenbakiak = new String[erromatarZenbakia.length()];

        int []zenbakiak2 = new int[erromatarZenbakia.length()];

        int erantzuna =0;


        for (int i =0;i< zenbakiak.length;i++){

            zenbakiak[i]=String.valueOf(erromatarZenbakia.charAt(i));

        }


        for (int i =0;i< zenbakiak.length;i++){
            if (zenbakiak[i].equals("I")){
                zenbakiak2 [i]=1;
            } else if (zenbakiak[i].equals("V")) {
                zenbakiak2 [i]=5;
            }else if (zenbakiak[i].equals("X")) {
                zenbakiak2 [i]=10;
            }else if (zenbakiak[i].equals("L")) {
                zenbakiak2 [i]=50;
            }else if (zenbakiak[i].equals("C")) {
                zenbakiak2 [i]=100;
            }else if (zenbakiak[i].equals("D")) {
                zenbakiak2 [i]=500;
            }else if (zenbakiak[i].equals("M")) {
                zenbakiak2 [i]=1000;
            }
        }

        for (int i =0;i< zenbakiak.length-1;i++){

           if (zenbakiak2[i]>=zenbakiak2[i+1]){
                erantzuna +=zenbakiak2[i];
           }else {
                erantzuna -=zenbakiak2[i];
           }
        }
        erantzuna += zenbakiak2[zenbakiak2.length - 1];

        System.out.println(erantzuna);

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