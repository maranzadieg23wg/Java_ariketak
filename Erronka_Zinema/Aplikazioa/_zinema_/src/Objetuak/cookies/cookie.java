package Objetuak.cookies;

import DatuBase.Konexioa;
import Objetuak.Bezero;

import javax.swing.*;
import java.io.*;
import java.sql.SQLException;

public class Cookie {

    public static Bezero saioCookie(){


        try {
            BufferedReader br1 = new BufferedReader(new FileReader("./fitxategiak/cookies/saioa"));

            String line;
            while ((line = br1.readLine()) !=null){
                String[] saio = line.split(":");

                Konexioa conn = new Konexioa();

                boolean bai = conn.saioaHasiHash(saio[0], saio[1]);

                if (bai){
                    return conn.getBezero();
                }else {
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("./fitxategiak/cookies/saioa", false));
                    bw1.write(saio[0]+":"+saio[1]);
                    return null;
                }
            }
        }catch (Exception e){
            return null;
        }


        return null;

    }

    public static void borratuCache() throws IOException {

        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("./fitxategiak/cookies/saioa", false));
            bw1.write("");

            BufferedWriter bw2 = new BufferedWriter(new FileWriter("./fitxategiak/cache/irudiak", false));
            bw2.write("");



            File karpeta = new File("irudiak/aktore");

            if (karpeta.exists() && karpeta.isDirectory()) {

                File[] fitxategia = karpeta.listFiles();


                for (File fitx : fitxategia) {
                    fitx.delete();
                }


            }

            File karpeta1 = new File("irudiak/pelikula");

            if (karpeta1.exists() && karpeta1.isDirectory()) {

                File[] fitxategia = karpeta1.listFiles();


                for (File fitx : fitxategia) {
                    fitx.delete();
                }


            }
        }catch (IOException e){
            System.err.println("Arazo bat gertatu da borratzean datuak");

        }

    }
}
