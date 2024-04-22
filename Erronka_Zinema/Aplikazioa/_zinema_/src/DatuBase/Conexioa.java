package DatuBase;
import Objetuak.Bezero;
import Objetuak.IkusitakoLista;
import Objetuak.Pelikulak;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Conexioa {

    String ipa = "10.14.4.122";
    //String ipa = "192.168.1.60";
    String DBIzena = "ORCLCDB";
    String username = "taldea3";
    String pasahitza = "batbihiru";


    Connection conn;
    Scanner sc;


    Bezero bezero;
    ArrayList<IkusitakoLista> ikusitakoPelikulak;


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
            System.out.println("3: Pelikula aleatorio bat lortu");
            System.out.println("4: Ikusi ikusitako lista");
            System.out.println("0: Itxi");

            aukera = sc.nextInt();

            switch (aukera){
                case 1:
                    saioaHasi();
                    break;


                case 2:
                    sortuKontua();
                    break;

                case 3:
                    System.out.println(pelikulaLortu());
                    break;


                case 4:
                    ikusitakoPelikulak();
                    break;


                case 0:
                    aukera =0;
                    break;
                default:
                    System.out.println("Sartu duzun zenbakiak ez du balio");
                    break;


            }


        }




    }

    //*******************************SORTU KONTUA ******************************

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
        //ezistitzenDa(emaila);

        if (ezistitzenDaEmail(emaila)){
            System.err.println(emaila+" erabiltzailearekin kontu bat existitzen da");
        }else {

            System.out.print("Izena: ");
            String izena = sc.nextLine();
            System.out.print("Abizena: ");
            String abizena = sc.nextLine();
            System.out.print("Erabiltzailea: ");
            String erabiltzailea = sc.nextLine();



            while (ezistitzenDaErabiltzailea(erabiltzailea)){


                System.out.println(erabiltzailea+" ezistitzenda.");

                System.out.print("Erabiltzailea: ");
                erabiltzailea = sc.nextLine();


            }





            String sql2 = "Insert into ERABILTZAILEAK values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql2);
            kontsulta2.setInt(1, azkenekoID());
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

    //***************************************SAIOA HASI****************************************

    void saioaHasi() throws SQLException {
        sc.nextLine();
        System.out.println("-----------SAIOA HASI-----------");
        System.out.print("Emaila: ");
        String emaila = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        String pasahitzaHash = String.valueOf(pasahitza.hashCode());

        String sql = "select * from ERABILTZAILEAK where emaila = ? and pasahitza = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, emaila);
        kontsulta.setString(2, pasahitzaHash);

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()) {
            System.out.println("Saioa hasita");
            int idErabiltzailea = emaitza.getInt("ID_ERABILTZAILEA");
            String izena = emaitza.getString("IZENA");
            String abizena = emaitza.getString("ABIZENA");
            String email = emaitza.getString("EMAILA");
            String erabiltzaile = emaitza.getString("ERABILTZAILEA");
            this.bezero = new Bezero(idErabiltzailea, izena, abizena, email, erabiltzaile);


        } else {
            System.err.println(emaila + " erabiltzailearekin kontu bat ez dago existitzen");
        }
    }


    boolean ezistitzenDaEmail(String email) throws SQLException {
        String sql = "select * from ERABILTZAILEAK where (emaila = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, email);


        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }
    }

    boolean ezistitzenDaErabiltzailea(String Erabiltzailea) throws SQLException {
        String sql = "select * from ERABILTZAILEAK where (erabiltzailea = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, Erabiltzailea);


        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }
    }


    Pelikulak pelikulaLortu() throws SQLException {
        return pelikulaLortu(-1);
    }

    Pelikulak pelikulaLortu(int aukera) throws SQLException {

        if (aukera == -1){
            int azkenP = azkenekoPelikula();

            aukera = (int) (Math.random() * azkenP)+1;
        }


        String sql = "select * from FILMAK where (erabiltzailea = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, String.valueOf(aukera));


        ResultSet emaitza = kontsulta.executeQuery();

        return pelikulaObjetua(emaitza);

    }



    Pelikulak pelikulaObjetua(ResultSet pel) throws SQLException {


        int IDPelikula = pel.getInt("IDPelikula");
        String tituloa = pel.getString("tituloa");
        String generoa = pel.getString("generoa");
        int irabaziak = pel.getInt("irabaziak");
        int aurrekontua = pel.getInt("aurrekontua");
        String trailera = pel.getString("trailera");
        String irudia = pel.getString("irudia");
        int idEstrenaldia = pel.getInt("idEstrenaldia");
        int idZuzendaria = pel.getInt("idZuzendaria");
        return new Pelikulak(IDPelikula, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, idEstrenaldia, idZuzendaria);


    }


    //***********************************Ikusteko Pelikula Lista****************************************************

    void ikusitakoPelikulak() throws SQLException {

        String sql = "select * from IKUSITAKOLISTA where (id_erabiltzailea = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, String.valueOf(bezero.getIdErabiltzailea()));

        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            IkusitakoLista list = ikusitakoListaLortu(emaitza);

            ikusitakoPelikulak.add(list);
        }

    }


    IkusitakoLista ikusitakoListaLortu(ResultSet pel) throws SQLException {
        int IDPelikula = pel.getInt("ID_filma");
        int ikusita = pel.getInt("ikusita");
        int ikusteko = pel.getInt("ikusteko");
        float nota = pel.getFloat("nota");
        int ikusKop = pel.getInt("ikus_kop");

        Pelikulak peli = pelikulaLortu(IDPelikula);

        return new IkusitakoLista(bezero, peli, ikusita, nota, ikusKop);

    }

    //************************************* AZKENEKOAK***********************************************

    int azkenekoID() throws SQLException {
        String sql = "select * from ERABILTZAILEAK WHERE ID_ERABILTZAILEA =(SELECT MAX(ID_ERABILTZAILEA) FROM ERABILTZAILEAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);



        ResultSet emaitza = kontsulta.executeQuery();

        return emaitza.getInt(1);
    }

    int azkenekoPelikula() throws SQLException {
        String sql = "select * from FILMAK WHERE ID_FILMA =(SELECT MAX(ID_FIMLA) FROM FILMAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);



        ResultSet emaitza = kontsulta.executeQuery();

        return emaitza.getInt(1);
    }


    //************************KONEXIOA*********************************

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

    void konexioaItxi(){

        try {
            System.out.println("Konexioa izten");
            conn.close();
        }catch (SQLException e){
            System.err.println("Ezin izan da konexioa izti.");
        }

    }




}
