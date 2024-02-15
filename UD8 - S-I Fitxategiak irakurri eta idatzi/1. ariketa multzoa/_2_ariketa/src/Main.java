import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Lehen fitxategiaren izena: ");
        String fitxategia1 = sc.nextLine();
        System.out.println("Bigarren fitxategiaren izena: ");
        String fitxategia2 = sc.nextLine();
        System.out.println("Hirugarren fitxategiaren izena: ");
        String fitxategia3 = sc.nextLine();

        try {
        BufferedReader f1 = new BufferedReader(new FileReader(".\\fitxategiak\\"+fitxategia1));
        //BufferedReader f2 = new BufferedReader(new FileReader(".\\fitxategiak\\fitx2.txt"));
        //BufferedReader f3 = new BufferedReader(new FileReader(".\\fitxategiak\\fitx3.txt"));



        BufferedWriter w2 = new BufferedWriter(new FileWriter(".\\fitxategiak\\"+fitxategia2));
        BufferedWriter w3 = new BufferedWriter(new FileWriter(".\\fitxategiak\\"+fitxategia3));


        String line;
        int zenbat =0;
        while ((line = f1.readLine()) != null) {

            //System.out.println(line);

            w2.write(line);
            w2.newLine();
            if (zenbat<20){
                w3.write(line);
                w3.newLine();
            }

            zenbat++;
        }

        f1.close();
        w2.close();
        w3.close();

    } catch (IOException e) {
        System.err.println("Fitxategia ez da aurkitu");
    }

        System.out.println("Bukatuta");


    }
}