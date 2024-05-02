package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Konexioa {
    String ipa = "10.14.4.122";
    //String ipa = "192.168.1.60";
    String DBIzena = "ORCLCDB";
    String username = "taldea3";
    String pasahitza = "batbihiru";


    Connection conn;
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
        String sql = "SELECT ID_ESTRENALDIA FROM ESTREINALDIAK WHERE ID_ESTRENALDIA = (SELECT MAX(ID_ESTRENALDIA) FROM ESTREINALDIAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoPelikula = 0;
        if (emaitza.next()) {
            azkenekoPelikula = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoPelikula;
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
