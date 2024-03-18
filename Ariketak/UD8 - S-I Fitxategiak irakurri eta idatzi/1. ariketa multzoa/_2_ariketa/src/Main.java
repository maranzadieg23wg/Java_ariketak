import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        try {
        BufferedReader f1 = new BufferedReader(new FileReader(".\\fitxategiak\\"+args[0]));
        //BufferedReader f2 = new BufferedReader(new FileReader(".\\fitxategiak\\fitx2.txt"));
        //BufferedReader f3 = new BufferedReader(new FileReader(".\\fitxategiak\\fitx3.txt"));



        BufferedWriter w2 = new BufferedWriter(new FileWriter(".\\fitxategiak\\"+args[1]));


        int urrengoa = f1.read();
        while (urrengoa!= -1) {

            //System.out.println(urrengoa);

            w2.write(urrengoa);


            urrengoa = f1.read();

        }


        w2.close();


        f1 = new BufferedReader(new FileReader(".\\fitxategiak\\"+args[0]));
        BufferedWriter w3 = new BufferedWriter(new FileWriter(".\\fitxategiak\\"+args[2]));

        char[]karaktereak = new char[20];
        int charKopu = f1.read(karaktereak);

        while (charKopu !=-1){
            w3.write(karaktereak);
            karaktereak = new char[20];
            charKopu = f1.read(karaktereak);
            //System.out.println(charKopu);
        }

        f1.close();
        w3.close();

    } catch (IOException e) {
        System.err.println("Fitxategia ez da aurkitu");
    }

        System.out.println("Bukatuta");


    }
}