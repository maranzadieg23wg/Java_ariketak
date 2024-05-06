package DB;

import API.API;
import okhttp3.Response;

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


    public void pelLortu(){
        try {

            String sql = "select ID_FILMA,TITULUA from FILMAK";

            PreparedStatement kontsulta = conn.prepareStatement(sql);

            ResultSet emaitza = kontsulta.executeQuery();
            int azkenID = azkenekoAktorea();

            while (emaitza.next()){

                azkenID++;

                int idLokal = emaitza.getInt(1);
                String izena = emaitza.getString(2);


                int pelID = idPelikula(izena);

                API.gehituAkt(pelID, azkenID, idLokal);

                azkenID = azkenekoAktorea();

            }

        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int idPelikula(String izena) throws IOException {
        return API.pelikulaID(izena);
    }


    public static int aktoreaDago(String izena, String abizena) throws SQLException {
        String sql = "select * from aktoreak where izena =?, abizena=?";

        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);
        kontsulta.setString(2, abizena);

        ResultSet emaitza = kontsulta.executeQuery();
        if (emaitza.next()){
            return emaitza.getInt("ID");
        }else {
            return -1;
        }
    }

    public static void gehituAktorea(int id, String izena, String abizena, int generoa, String URL) throws SQLException {
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

        String sql = "inser into aktoreak values (?,?,?,?,?,?,?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, id);
        kontsulta.setString(2, izena);
        kontsulta.setString(3, abizena);
        kontsulta.setString(4, generoaa);
        kontsulta.setString(5, email);
        kontsulta.setString(6, tel);
        kontsulta.setString(7, URL);

        int rowsAffected = kontsulta.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Gehitu egin da "+izena+" "+abizena);

        } else {
            System.err.println("Ezin izan da gehitu "+izena+" "+abizena);
        }


    }

    public static void lanEGin(int id, int idAkt, String pertso) throws SQLException {
        String sql = "inser into lanEgin du values (?,?,?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, id);
        kontsulta.setInt(2, idAkt);
        kontsulta.setString(3, pertso);

        int rowsAffected = kontsulta.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Gehitu egin da "+pertso);

        } else {
            System.err.println("Ezin izan da gehitu "+pertso);
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
