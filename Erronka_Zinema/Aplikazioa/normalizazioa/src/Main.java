import API.API;
import DB.Konexioa;

import java.io.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {





    }


    static void aktoreak() throws SQLException {

        Konexioa conn = new Konexioa();
        String csvFile = "fitxategiak/csv/datuakAldatuta.csv";
        String fimak = "fitxategiak/csv/filmak.csv";
        String zuzendariak = "fitxategiak/csv/zuzendaria.csv";
        String zuzenduta = "fitxategiak/csv/zuzenduta.csv";
        String estren = "fitxategiak/csv/estrenaldia.csv";
        String line = "";
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter film = new BufferedWriter(new FileWriter(fimak));
             BufferedWriter zuzendari = new BufferedWriter(new FileWriter(zuzendariak));
             BufferedWriter zuzendu = new BufferedWriter(new FileWriter(zuzenduta));
             BufferedWriter estrenaldia = new BufferedWriter(new FileWriter(estren))){


            br.readLine();

            while ((line = br.readLine()) != null){

                int pelikula = conn.azkenekoPelikula() +1;
                int zuzendaria = conn.azkenekoZuzendaria() +1;
                int estrenadia = conn.azkenekoEstrenaldia() +1;


                String[] data = line.split(csvSeparator); //← Sartu egin den CSV lerroko datuak separatuta

                String izena = data[0];
                String estrenaldi = data[1];
                String genero = data[2];
                String iraupena = data[3];
                String zuzendariIzena = data[4];
                String zuzendariAdina = data[6];
                String kostua = data[11];
                String irabaziak = data[13];
                String poster = data[14];
                String trailer = data[15];


                film.write(pelikula);
                film.write(csvSeparator);
                film.write(izena);
                film.write(csvSeparator);
                film.write(genero);
                film.write(csvSeparator);
                film.write(irabaziak);
                film.write(csvSeparator);
                film.write(kostua);
                film.write(csvSeparator);
                film.write(zuzendaria);
                film.write(csvSeparator);
                film.write(estrenadia);
                film.write(csvSeparator);
                film.write(poster);
                film.write(csvSeparator);
                film.write(trailer);
                film.newLine();

                zuzendari.write(zuzendaria);
                zuzendari.write(csvSeparator);
                String[] li = zuzendariIzena.split(" ");
                zuzendari.write(li[0]);
                zuzendari.write(csvSeparator);
                zuzendari.write(li[1]);
                zuzendari.write(zuzendariAdina);
                zuzendari.newLine();

                estrenaldia.write(estrenadia);
                estrenaldia.write(csvSeparator);
                estrenaldia.write(estrenaldi);
                estrenaldia.write(csvSeparator);
                estrenaldia.write("EEUU");
                estrenaldia.write(csvSeparator);
                estrenaldia.write(pelikula);
                estrenaldia.newLine();

                zuzendu.write(pelikula);
                zuzendu.write(csvSeparator);
                zuzendu.write(zuzendaria);
                zuzendu.newLine();






            }



        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void URLGehitu(){
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