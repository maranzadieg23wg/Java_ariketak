import API.API;
import DB.Konexioa;
import org.json.JSONObject;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        //URLGehitu();
        //aktoreak();

        //Konexioa conn = new Konexioa();
        //conn.pelLortu();

        aktoreErrepikatuak();
        sinopsisgehitu();

    }

    static void aktoreErrepikatuak() throws SQLException {
        Konexioa conn = new Konexioa();

        conn.errepikatuta();

        conn.konexioaItxi();

    }


    static void sinopsisgehitu() throws SQLException, IOException {
        Konexioa conn = new Konexioa();

        conn.gehituSinopsis();

        conn.konexioaItxi();

    }


    static void aktoreak() throws SQLException {

        HashMap<String, Integer> zuzendariLista = new HashMap<>();
        int zenbat =0;
        int guztira = 4381;


        Konexioa conn = new Konexioa();
        String csvFile = "fitxategiak/csv/datuakAldatuta.csv";
        String fimak = "fitxategiak/csv/final/filmak.csv";
        String zuzendariak = "fitxategiak/csv/final/zuzendaria.csv";
        String zuzenduta = "fitxategiak/csv/final/zuzenduta.csv";
        String estren = "fitxategiak/csv/final/estrenaldia.csv";
        String line = "";
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter film = new BufferedWriter(new FileWriter(fimak));
             BufferedWriter zuzendari = new BufferedWriter(new FileWriter(zuzendariak));
             BufferedWriter zuzendu = new BufferedWriter(new FileWriter(zuzenduta));
             BufferedWriter estrenaldia = new BufferedWriter(new FileWriter(estren))){


            br.readLine();

            int pelikula = conn.azkenekoPelikula();
            int zuzendaria = conn.azkenekoZuzendaria();
            int estrenadia = conn.azkenekoEstrenaldia();
            /*int pelikula = 0;
            int zuzendaria = 0;
            int estrenadia = 0;*/

            while ((line = br.readLine()) != null){

                pelikula++;
                zuzendaria++;
                estrenadia++;




                StringBuilder sb = new StringBuilder();
                boolean withinQuotes = false;
                for (char c : line.toCharArray()) {
                    if (c == '"') {
                        withinQuotes = !withinQuotes;
                    }
                    if (withinQuotes && c == ',') {
                        sb.append(';');
                    } else {
                        sb.append(c);
                    }
                }



                String[] data = sb.toString().split(csvSeparator); //← Sartu egin den CSV lerroko datuak separatuta

                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }

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




                String gender ="";
                String zuzIMG ="";
                JSONObject zuz = API.jsonLortu(API.zuzendariaLortu(zuzendariIzena));
                if (zuz !=null){
                    int gener = zuz.getInt("gender");

                    if (gener ==2){
                        gender = "Man";
                    }else {
                        gender ="Woman";
                    }

                    zuzIMG = "http://image.tmdb.org/t/p/w500"+zuz.get("profile_path");
                }


                film.write(pelikula+"");
                film.write(csvSeparator);
                film.write(izena);
                film.write(csvSeparator);
                film.write(genero);
                film.write(csvSeparator);
                film.write(irabaziak);
                film.write(csvSeparator);
                film.write(kostua);
                film.write(csvSeparator);

                if (zuzendariLista.containsKey(zuzendariIzena)){
                    film.write(zuzendariLista.get(zuzendariIzena)+"");
                    zuzendaria--;
                }else {
                    film.write(zuzendaria+"");
                }
                film.write(csvSeparator);
                film.write(estrenadia+"");
                film.write(csvSeparator);
                film.write(poster);
                film.write(csvSeparator);
                film.write(trailer);
                film.newLine();


                if (!zuzendariLista.containsKey(zuzendariIzena)){
                    zuzendari.write(zuzendaria+"");
                    zuzendari.write(csvSeparator);


                    if (zuzendariIzena.equals("-")){
                        zuzendari.write(zuzendariIzena);
                        zuzendari.write(csvSeparator);
                    }else if (!zuzendariIzena.contains(" ")){
                        zuzendari.write(zuzendariIzena);
                        zuzendari.write(csvSeparator);
                    } else if (zuzendariIzena.contains("\\")) {
                        zuzendari.write(zuzendariIzena);
                        zuzendari.write(csvSeparator);
                    } else {
                        String[] li = zuzendariIzena.split(" ");
                        zuzendari.write(li[0]);
                        zuzendari.write(csvSeparator);
                        zuzendari.write(li[1]);
                        zuzendari.write(csvSeparator);
                    }
                    zuzendari.write(zuzendariAdina);
                    zuzendari.write(csvSeparator);
                    zuzendari.write(gender);
                    zuzendari.write(csvSeparator);
                    zuzendari.write(zuzIMG);
                    zuzendari.newLine();
                    zuzendariLista.put(zuzendariIzena, zuzendaria);
                }


                estrenaldia.write(estrenadia+"");
                estrenaldia.write(csvSeparator);
                LocalDate dataa = LocalDate.parse(estrenaldi);
                String dataOngi = dataa.format(DateTimeFormatter.ofPattern("yy-MMM-dd", Locale.ENGLISH).withLocale(Locale.ENGLISH)).toUpperCase();
                //System.err.println(dataOngi);
                estrenaldia.write(dataOngi);
                estrenaldia.write(csvSeparator);
                estrenaldia.write("EEUU");
                estrenaldia.write(csvSeparator);
                estrenaldia.write(pelikula+"");
                estrenaldia.newLine();

                zuzendu.write(pelikula+"");
                zuzendu.write(csvSeparator);
                if (zuzendariLista.containsKey(zuzendariIzena)){
                    zuzendu.write(zuzendariLista.get(zuzendariIzena)+"");
                }else {
                    zuzendu.write(zuzendaria+"");
                }
                zuzendu.newLine();



                zenbat++;
                System.out.println(izena);
                System.out.println(zuzendariIzena);
                System.out.println(zuzIMG);
                System.out.println("%"+zenbat*100/guztira);
                System.out.println("-------------------------------------------------");




            }

            film.close();
            zuzendari.close();
            estrenaldia.close();
            zuzendu.close();
            film.close();



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
                }else {
                    bw.write("-");
                    bw.write(csvSeparator);
                }

                if (trailer !=null){
                    bw.write(trailer);
                }else {
                    bw.write("-");
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