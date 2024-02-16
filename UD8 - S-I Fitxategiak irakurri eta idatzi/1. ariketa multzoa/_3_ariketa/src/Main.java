import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            BufferedWriter w1 = new BufferedWriter(new FileWriter(".\\fitxategiak\\fitx1.txt"));



            System.out.print("Zenbat lerro: ");
            BufferedReader zenbat1 = new BufferedReader(new InputStreamReader(System.in));

            int zenbat = Integer.parseInt(String.valueOf(zenbat1.readLine()));

            System.out.println("Hasi idazten");
            for (int i =0;i<zenbat;i++){

                String mezua = String.valueOf(zenbat1.readLine());
                String alderantziz = "";

                for (int e =mezua.length()-1;e>=0;e--){
                    alderantziz= alderantziz + mezua.charAt(e);
                }

                if (alderantziz.length()>30){

                    alderantziz=alderantziz.substring(0, 30);

                }

                w1.write(alderantziz);
                w1.newLine();

            }


            w1.close();

        }catch (IOException e) {
            System.err.println("Fitxategia ez da aurkitu");
        }

        System.out.println("Bukatuta");


    }
}