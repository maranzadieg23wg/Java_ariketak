package Objetuak.cookies;

import DatuBase.Konexioa;
import Objetuak.DB.Bezero;
import Objetuak.Encrypt;

import java.io.*;

public class Cookie {
    public static Bezero saioCookie(){


        String url = "./fitxategiak/cookies/saioa";
        File fitx = new File(url);
        File karpeta = fitx.getParentFile();
        try {

            if (!karpeta.exists()){
                karpeta.mkdirs();
            }
            if (!fitx.exists()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(url));
                bw.close();
            }else {
                BufferedReader br1 = new BufferedReader(new FileReader(url));

                String line;
                while ((line = br1.readLine()) !=null){
                    line = Encrypt.decrypt(line);
                    String[] saio = line.split(":");

                    //System.out.println(saio[0]+":"+saio[1]);

                    Konexioa conn = new Konexioa();

                    boolean bai = conn.saioaHasiHash(saio[0], saio[1]);

                    if (bai){
                        return conn.getBezero();
                    }else {

                        return null;
                    }
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

            File karpeta12 = new File("irudiak/zuzendari");

            if (karpeta12.exists() && karpeta12.isDirectory()) {

                File[] fitxategia = karpeta12.listFiles();


                for (File fitx : fitxategia) {
                    fitx.delete();
                }


            }

            Konexioa.saioaItzi();

            Konexioa.borratuLista();
        }catch (IOException e){
            System.err.println("Arazo bat gertatu da borratzean datuak");

        }

    }
}
