package Objetuak;

import java.io.IOException;
import java.io.*;
import java.net.URL;

public class IrudiakDeskargatu {

    String url;
    String karpeta;

    String fitxategiarenIzena;
    public static String irudiaDeskargatu(String urlString, String bukaerakoKarpeta) {
        try {
            URL url = new URL(urlString);

            InputStream inputStream = url.openStream();

            String cache = "./fitxategiak/cache/irudiak";

            String fitxategiaIzena = urlString.substring(urlString.lastIndexOf('/') + 1);
            String fitxategiaNonGorde = bukaerakoKarpeta + File.separator + fitxategiaIzena;

            File fitx = new File(fitxategiaNonGorde);
            File karpe = fitx.getParentFile();
            if (!karpe.exists()){
                karpe.mkdirs();
            }

            File fitx1 = new File(cache);
            File karpe1 = fitx1.getParentFile();
            if (!karpe1.exists()){
                karpe1.mkdirs();
                BufferedWriter bw = new BufferedWriter(new FileWriter(cache));
                bw.close();
            } else if (!fitx1.exists()) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(cache));
                bw.close();
            }


            BufferedReader br1 = new BufferedReader(new FileReader(cache));

            //fitxategiaNonGorde = fitxategiaNonGorde.replace("\\", "/");

            String line;
            while ((line = br1.readLine()) !=null){
                if (line.equals(fitxategiaNonGorde)){
                    System.out.println(fitxategiaNonGorde);
                    br1.close();
                    return fitxategiaNonGorde;
                }
            }
            br1.close();

            OutputStream outputStream = new FileOutputStream(fitxategiaNonGorde);

            byte[] buffer = new byte[2048];
            int luzeera;
            while ((luzeera = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, luzeera);
            }



            inputStream.close();
            outputStream.close();


            BufferedWriter bw1 = new BufferedWriter(new FileWriter("./fitxategiak/cache/irudiak", true));
            bw1.write(fitxategiaNonGorde);
            bw1.newLine();

            bw1.close();

            return fitxategiaNonGorde;
        } catch (IOException e) {
            String karpeta = "irudiak/errorIrudia/";
            String url = "irudiak/errorIrudia/Image_not_available.png";
            File fitx = new File(url);
            File karpe = fitx.getParentFile();
            if (!karpe.exists()){
                karpe.mkdirs();
            }
            if (!fitx.exists()){
                IrudiakDeskargatu.irudiaDeskargatu("https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png", karpeta);
            }
            //e.printStackTrace();
            return url;
        }
    }

    public IrudiakDeskargatu(String url, String karpeta) {
        this.url = url;
        this.karpeta = karpeta;



        fitxategiarenIzena = irudiaDeskargatu(url, karpeta);
    }

    public String getFitxategiarenIzena() {
        return fitxategiarenIzena;
    }
}
