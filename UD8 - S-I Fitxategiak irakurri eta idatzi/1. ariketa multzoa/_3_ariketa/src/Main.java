import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            BufferedWriter w1 = new BufferedWriter(new FileWriter(".\\fitxategiak\\fitx1.txt"));

            Scanner sc = new Scanner(System.in);

            System.out.print("Zenbat lerro: ");
            int zenbat = sc.nextInt();
            sc.nextLine();

            System.out.println("Hasi idazten");
            for (int i =0;i<zenbat;i++){
                String mezua = sc.nextLine();
                String alderantziz = "";

                for (int e =mezua.length()-1;e>=0;e--){
                    alderantziz= alderantziz + mezua.charAt(e);
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