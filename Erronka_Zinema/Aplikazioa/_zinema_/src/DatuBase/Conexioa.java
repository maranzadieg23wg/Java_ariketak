package DatuBase;
import Objetuak.Bezero;

import java.sql.*;
import java.util.Scanner;

public class Conexioa {

    String ipa = "10.14.4.122";
    String DBIzena = "ORCLCDB";
    String username = "taldea3";
    String pasahitza = "batbihiru";


    Connection conn;
    Scanner sc;


    public Conexioa() throws SQLException {
        sc = new Scanner(System.in);

        konexiaEgin();

        menua();
        konexioaItxi();





    }

    void menua() throws SQLException {
        int aukera = 1;
        while (aukera !=0){

            System.out.println("1: Saioa hasi");
            System.out.println("2: Sortu kontua");
            System.out.println("0: Itxi");

            aukera = sc.nextInt();

            switch (aukera){
                case 1:
                    saioaHasi();


                case 2:
                    sortuKontua();


                case 0:
                    aukera =0;
                default:
                    System.out.println("Sartu duzun zenbakiak ez du balio");
            }


        }




    }

    void sortuKontua() throws SQLException {
        sc.nextLine();
        System.out.println("-----------KONTUA SORTU-----------");
        System.out.print("Emaila: ");
        String emaila = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        int pasahitzaHash = pasahitza.hashCode();
        pasahitza = null;


        //Begiratu ea existitzen den
        String sql = "select count(*) from ERABILTZAILEAK where (emaila = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, emaila);


        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.getInt(1)!=0){
            System.err.println(emaila+" erabiltzailearekin kontu bat existitzen da");
        }else {

            System.out.print("Izena: ");
            String izena = sc.nextLine();
            System.out.print("Abizena: ");
            String abizena = sc.nextLine();
            System.out.print("Erabiltzailea: ");
            String erabiltzailea = sc.nextLine();


            ResultSet emaitza1 = null;
            while (emaitza1.getInt(1) !=0){
                String sql1 = "select count(*) from ERABILTZAILEAK where (erabiltzailea = ?)";
                PreparedStatement kontsulta1 = conn.prepareStatement(sql1);
                kontsulta1.setString(1, erabiltzailea);


                 emaitza1 = kontsulta1.executeQuery();

                System.out.println(erabiltzailea+" ezistitzenda.");

                System.out.print("Erabiltzailea: ");
                erabiltzailea = sc.nextLine();

                if (emaitza.getInt(1) !=0){
                    break;
                }
            }





            String sql2 = "Insert into ERABILTZAILEAK values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql2);
            kontsulta2.setString(2, izena);
            kontsulta2.setString(3, abizena);
            kontsulta2.setString(4, emaila);
            kontsulta2.setString(5, erabiltzailea);
            kontsulta2.setInt(6, pasahitzaHash);

            int rowsAffected = kontsulta2.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Erabiltzailea ongi sortu egin da.");
            } else {
                System.err.println("Errore bat gertatu da erabiltzailea sortzean.");
            }





        }



    }

    void saioaHasi() throws SQLException {

        System.out.println("-----------SAIOA HASI-----------");
        System.out.print("Emaila: ");
        String emaila = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        int pasahitzaHash = pasahitza.hashCode();
        pasahitza = null;



        String sql = "select count(*), * from ERABILTZAILEAK where (emaila = ? and pasahitza =?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, emaila);
        kontsulta.setInt(2, pasahitzaHash);

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.getInt(1)!=0){
            //System.err.println(emaila+" erabiltzailearekin kontu bat existitzen da");
            int idErabiltzailea = emaitza.getInt(1);
            String izena = emaitza.getString(2);
            String abizena = emaitza.getString(3);
            String email = emaitza.getString(4);
            String erabiltzaile = emaitza.getString(5);
            Bezero bezero = new Bezero(idErabiltzailea, izena, abizena, email, erabiltzaile);
            System.out.println("Saioa hasita");
        }else {
            System.err.println(emaila+" erabiltzailearekin kontu bat ez existitzen da");
        }
    }



    void konexiaEgin(){

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ipa + ":1521:" + DBIzena, username, pasahitza);
            System.out.println("Konexioa eginda");
        }catch (SQLException e){
            System.out.println("Ezin izan da konexioa egin");
        }

    }

    void konexioaItxi(){

        try {
            System.out.println("Konexioa izten");
            conn.close();
        }catch (SQLException e){
            System.err.println("Ezin izan da konexioa izti.");
        }

    }




}
