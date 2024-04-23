package Objetuak;

import java.io.IOException;
import java.io.*;
import java.net.URL;

public class IrudiakDeskargatu {

    String url;
    String karpeta;

    String fitxategiarenIzena;
    public static String irudiaDeskargatu(String urlString, String directorioDestino) {
        try {
            URL url = new URL(urlString);

            InputStream inputStream = url.openStream();

            String fitxategiaIzena = urlString.substring(urlString.lastIndexOf('/') + 1);
            String fitxategiaNonGorde = directorioDestino + File.separator + fitxategiaIzena;
            OutputStream outputStream = new FileOutputStream(fitxategiaNonGorde);


            byte[] buffer = new byte[2048];
            int luzeera;
            while ((luzeera = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, luzeera);
            }


            inputStream.close();
            outputStream.close();

            return fitxategiaNonGorde;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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
