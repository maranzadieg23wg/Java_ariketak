import API.API;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int zenbat =0;
        int guztira = 4381;
        String csvFile = "fitxategiak/csv/movie_statistic_dataset.csv";
        String outputFile = "fitxategiak/csv/datuakAldatuta.csv";
        String line = "";
        String csvSeparator = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSeparator);

                String izena = data[0];

                String poster = API.pelikulaIMG(izena);
                String trailer = API.pelikulaTrailer(izena);

                zenbat++;
                System.out.println(izena);
                System.out.println(poster);
                System.out.println(trailer);
                System.out.println(zenbat*100/guztira);
                System.out.println("-------------------------------------------------");

                for (String datuak: data) {
                    bw.write(datuak);
                    bw.write(csvSeparator);
                }

                //bw.write(csvSeparator);
                if (poster !=null){
                    bw.write(poster);
                    bw.write(csvSeparator);
                }

                if (trailer !=null){
                    bw.write(trailer);
                }

                bw.newLine();
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}