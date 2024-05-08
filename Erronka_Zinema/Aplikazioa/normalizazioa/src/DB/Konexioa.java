package DB;

import API.API;
import okhttp3.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Konexioa {
    String ipa = "10.14.4.122";
    //String ipa = "192.168.1.60";
    String DBIzena = "ORCLCDB";
    String username = "taldea3";
    String pasahitza = "batbihiru";


    static Connection conn;
    Scanner sc;




    public Konexioa() throws SQLException {
        sc = new Scanner(System.in);

        konexiaEgin();


        //menua();
        //konexioaItxi();





    }


    public int azkenekoPelikula() throws SQLException {
        String sql = "SELECT ID_FILMA FROM FILMAK WHERE ID_FILMA = (SELECT MAX(ID_FILMA) FROM FILMAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoPelikula = 0;
        if (emaitza.next()) {
            azkenekoPelikula = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoPelikula;
    }

    public int azkenekoZuzendaria() throws SQLException {
        String sql = "SELECT ID_FILM_ZUZENDARIA FROM FILM_ZUZENDARIA WHERE ID_FILM_ZUZENDARIA = (SELECT MAX(ID_FILM_ZUZENDARIA) FROM FILM_ZUZENDARIA)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoPelikula = 0;
        if (emaitza.next()) {
            azkenekoPelikula = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoPelikula;
    }

    public int azkenekoEstrenaldia() throws SQLException {
        String sql = "SELECT ID_ESTREINALDIA FROM ESTREINALDIAK WHERE ID_ESTREINALDIA = (SELECT MAX(ID_ESTREINALDIA) FROM ESTREINALDIAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoPelikula = 0;
        if (emaitza.next()) {
            azkenekoPelikula = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoPelikula;
    }

    public int azkenekoAktorea() throws SQLException {
        String sql = "SELECT ID_AKTOREA FROM AKTOREAK WHERE ID_AKTOREA = (SELECT MAX(ID_AKTOREA) FROM AKTOREAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoAktorea = 0;
        if (emaitza.next()) {
            azkenekoAktorea = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoAktorea;
    }


    public static int aktoZ =0;
    public void pelLortu(){
        try {
            int lehenengoa = 3126;
            //int lehenengoa = 6793;
            int azkenekoa = 7503;

            int ze=0;
            aktoZ =1;

            for (int i = lehenengoa;i<azkenekoa;i++){
                String sql = "SELECT ID_FILMA, TITULUA FROM FILMAK WHERE ID_FILMA =?";
                PreparedStatement kontsulta = conn.prepareStatement(sql);
                kontsulta.setInt(1, i);


                ResultSet emaitza = kontsulta.executeQuery();



                while (emaitza.next()) {
                    ze++;

                    int idLokal = emaitza.getInt(1);
                    String izena = emaitza.getString(2);

                    System.out.print("ID: " + idLokal+"  ");
                    System.out.println("Pelikula: " + izena);

                    int pelID = idPelikula(izena);

                    API.gehituAkt(pelID, aktoZ, idLokal);



                    //Thread.sleep(2*1000);
                }
                if (ze%10 ==0){
                    konexioaItxi();
                    konexiaEgin();
                }

            }


            System.out.println(ze);
        } catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }


    public int idPelikula(String izena) throws IOException {
        return API.pelikulaID(izena);
    }


    public static int aktoreaDago(String izena, String abizena) throws SQLException {
        String sql = "select * from aktoreak where izena =? and abizena=?";


        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);
        kontsulta.setString(2, abizena);

        ResultSet emaitza = kontsulta.executeQuery();


        if (emaitza.next()){
            return emaitza.getInt("ID_AKTOREA");
        }else {
            return -1;
        }
    }

    public static void gehituAktorea(int id, String izena, String abizena, int generoa, String URL){

        try {
            String generoaa ="";
            if (generoa ==1){
                generoaa = "Emakumea";
            }else if (generoa ==2){
                generoaa = "Gizonezkoa";
            }else {
                generoaa = "Non-Binari";
            }


            String email = izena+abizena+"@"+domeinua();
            String tel = telefonoZenbakiak();


       /* String sql = "insert into aktoreak values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, id);
        kontsulta.setString(2, izena);
        kontsulta.setString(3, abizena);
        kontsulta.setString(4, null);
        kontsulta.setString(5, null);
        kontsulta.setString(6, email);
        kontsulta.setString(7, tel);
        kontsulta.setString(8, null);
        kontsulta.setString(9, null);
        kontsulta.setString(10, URL);

        int rowsAffected = kontsulta.executeUpdate();



        if (rowsAffected > 0) {
            System.out.println("Gehitu egin da "+izena+" "+abizena);

        } else {
            System.err.println("Ezin izan da gehitu "+izena+" "+abizena);
        }*/
            String csvSeparator = ",";
            String csvFile = "fitxategiak/csv/aktoreak.csv";
            BufferedWriter aktoreak = new BufferedWriter(new FileWriter(csvFile, true));


            aktoreak.write(id+"");
            aktoreak.write(csvSeparator);
            aktoreak.write(izena);
            aktoreak.write(csvSeparator);
            if (abizena ==null){
                aktoreak.write("-");
            }else {
                aktoreak.write(abizena);
            }
            aktoreak.write(csvSeparator);
            aktoreak.write("-");
            aktoreak.write(csvSeparator);
            aktoreak.write("_");
            aktoreak.write(csvSeparator);
            aktoreak.write(email);
            aktoreak.write(csvSeparator);
            aktoreak.write(tel+"");
            aktoreak.write(csvSeparator);
            aktoreak.write("-");
            aktoreak.write(csvSeparator);
            aktoreak.write("_");
            aktoreak.write(csvSeparator);
            if (URL ==null){
                aktoreak.write("-");
            }else {
                aktoreak.write(URL);
            }
            aktoreak.newLine();

            aktoreak.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }




    }

    public static void lanEGin(int id, int idAkt, String pertso)   {

        try {
            /*String sql = "insert into PELIKULETANLANEGIN values (?,?,?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, id);
        kontsulta.setInt(2, idAkt);
        kontsulta.setString(3, pertso);

        int rowsAffected = kontsulta.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Gehitu egin da "+pertso);

        } else {
            System.err.println("Ezin izan da gehitu "+pertso);
        }*/
            String csvSeparator = ",";
            String csvFile = "fitxategiak/csv/pelikulanLanEgin.csv";
            BufferedWriter aktoreak = new BufferedWriter(new FileWriter(csvFile, true));

            aktoreak.write(id+"");
            aktoreak.write(csvSeparator);
            aktoreak.write(idAkt+"");
            aktoreak.write(csvSeparator);
            aktoreak.write(pertso);
            aktoreak.newLine();

            aktoreak.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }



    }



    public static String domeinua(){

        String[] domeinuak = {
                "gmail.com",
                "yahoo.com",
                "outlook.com",
                "hotmail.com",
                "icloud.com",
                "aol.com",
                "mail.com",
                "protonmail.com",
                "yandex.com",
                "zoho.com",
                "gmx.com",
                "live.com",
                "qq.com",
                "163.com",
                "mail.ru"
        };

        Random r = new Random();
        int z = r.nextInt(15);

        return domeinuak[z];
    }

    public static String telefonoZenbakiak(){
        Random random = new Random();

        StringBuilder telefono = new StringBuilder();

        telefono.append("+");

        telefono.append(random.nextInt(10));

        for (int i = 0; i < 8; i++) {
            telefono.append(random.nextInt(10));
        }
        return telefono.toString();
    }

    //************************KONEXIOA*********************************

    /**
     * Datu basera konektatzeko konexioa ireki behar dugu, eta horretarako erabiltzen da funtzio hau.
     * <blockquote>{@code konexioaEgin();}</blockquote>
     */
    void konexiaEgin(){

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ipa + ":1521:" + DBIzena, username, pasahitza);
            System.out.println("Konexioa eginda");
        }catch (SQLException e){

            System.err.println("Ezin izan da konexioa egin");
            //System.out.println(e.getErrorCode());
            if (e.getErrorCode() == 12541){
                System.err.println(e.getErrorCode()+": ez da aurkitu TNS-a");
            }


        }

    }

    /**
     * Datu basearekin izteko konexioa erabiliko genuke funtzio hau.
     * <blockquote>{@code konexioaItxi();}</blockquote>
     */
    public void konexioaItxi(){

        try {
            System.out.println("Konexioa itxita");
            conn.close();
        }catch (SQLException e){
            System.err.println("Ezin izan da konexioa itxi.");
        }

    }
}
