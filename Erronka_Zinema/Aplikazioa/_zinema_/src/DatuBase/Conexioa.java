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
    ArrayList<IkusitakoLista> ikusitakoPelikulak = new ArrayList<>();


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
            System.out.println("5: Gehitu ikusitako pelikula bat");
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

                    for (IkusitakoLista ikusi: ikusitakoPelikulak) {
                        System.out.println(ikusi);
                    }
                    break;

                case 5:

                    gehituIkusitakoPeli(101, 1, 8.5F, 4);
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





            String sql2 = "Insert into ERABILTZAILEAK values (?, ?, ?, ?, ?, ?, null)";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql2);
            kontsulta2.setInt(1, azkenekoID()+1);
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

            int idErabiltzailea = emaitza.getInt("ID_ERABILTZAILE");
            String izena = emaitza.getString("IZENA");
            String abizena = emaitza.getString("ABIZENA");
            String email = emaitza.getString("EMAILA");
            String erabiltzaile = emaitza.getString("ERABILTZAILEA");
            this.bezero = new Bezero(idErabiltzailea, izena, abizena, email, erabiltzaile);

            System.out.println("Saioa hasita");


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


    Pelikulak pelikulaLortu(String izena) throws SQLException {

        String sql = "SELECT * FROM FILMAK WHERE TITULUA = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);



        ResultSet emaitza = kontsulta.executeQuery();

        return pelikulaObjetua(emaitza);
    }

    Pelikulak pelikulaLortu() throws SQLException {
        return pelikulaLortu(-1);
    }

    Pelikulak pelikulaLortu(int aukera) throws SQLException {

        if (aukera == -1){
            int azkenP = azkenekoPelikula();
            int lehenP = lehenengoPelikula();

            aukera = (int) (Math.random() * (azkenP - lehenP + 1)) + lehenP;
        }





        String sql = "SELECT * FROM FILMAK WHERE ID_FILMA = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, aukera);



        ResultSet emaitza = kontsulta.executeQuery();

        return pelikulaObjetua(emaitza);

    }



    Pelikulak pelikulaObjetua(ResultSet pel) throws SQLException {

        if (!pel.next()) {
            return null;
        }


        int IDPelikula = pel.getInt("ID_FILMA");
        String tituloa = pel.getString("TITULUA");
        String generoa = pel.getString("GENEROA");
        long irabaziak = pel.getLong("IRABAZIAK");
        long aurrekontua = pel.getLong("AURREKONTUAK");
        String trailera = pel.getString("TRAILERRAK");
        String irudia = pel.getString("IRUDIA");
        int idEstrenaldia = pel.getInt("ID_ESTREINALDIA");
        int idZuzendaria = pel.getInt("ID_FILM_ZUZENDARIA");

        return new Pelikulak(IDPelikula, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, idEstrenaldia, idZuzendaria);


    }


    //***********************************Ikusteko Pelikula Lista****************************************************

    void ikusitakoPelikulak(){

        try {
            String sql = "select * from IKUSITAKOLISTA where (id_erabiltzaile = ?)";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setString(1, String.valueOf(bezero.getIdErabiltzailea()));

            ResultSet emaitza = kontsulta.executeQuery();

            while (emaitza.next()){
                IkusitakoLista list = ikusitakoListaLortu(emaitza);

                ikusitakoPelikulak.add(list);
            }
        }catch (SQLException e){
            //System.err.println("e: "+e.getErrorCode());
            System.err.println("Ez da saioa hasi, orduan, ezin da ikusi ikusitako lista");
        }


    }


    IkusitakoLista ikusitakoListaLortu(ResultSet pel) throws SQLException {
        int IDPelikula = pel.getInt("ID_filma");
        int ikusita = pel.getInt("ikusita");
        //int ikusteko = pel.getInt("ikusteko");
        float nota = pel.getFloat("nota");
        int ikusKop = pel.getInt("ikus_kop");

        Pelikulak peli = pelikulaLortu(IDPelikula);

        return new IkusitakoLista(bezero, peli, ikusita, nota, ikusKop);

    }



    void gehituIkusitakoPeli(int IDPeli, int ikusita, float nota, int ikusKop) throws SQLException {


        if (!listanDago(IDPeli)){

            String sql = "Insert into IKUSITAKOLISTA values (?, ?, ?, ?, ?)";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, bezero.getIdErabiltzailea());
            kontsulta.setInt(2, IDPeli);
            kontsulta.setInt(3, ikusita);
            kontsulta.setFloat(4, nota);
            kontsulta.setInt(5, ikusKop);

            int rowsAffected = kontsulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gehitu egin da pelikua");

            } else {
                System.err.println("Errore bat gertatu da gehitzean pelikula");
            }



        }else {
            System.err.println(IDPeli+" listan dago");
        }




    }


    boolean listanDago(int IDPeli) throws SQLException {

        String sql = "select * from IKUSITAKOLISTA where (id_erabiltzaile = ? and ID_FILMA = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, String.valueOf(bezero.getIdErabiltzailea()));
        kontsulta.setString(2, String.valueOf(IDPeli));

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }




    }




    //************************************* AZKENEKOAK***********************************************

    int azkenekoID() throws SQLException {
        String sql = "SELECT ID_ERABILTZAILE FROM ERABILTZAILEAK WHERE ID_ERABILTZAILE = (SELECT MAX(ID_ERABILTZAILE) FROM ERABILTZAILEAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoID = 0;
        if (emaitza.next()) {
            azkenekoID = emaitza.getInt(1);
        }

        return azkenekoID;
    }


    int azkenekoPelikula() throws SQLException {
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

    int lehenengoPelikula() throws SQLException {
        String sql = "SELECT ID_FILMA FROM FILMAK WHERE ID_FILMA = (SELECT MIN(ID_FILMA) FROM FILMAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int lehenengoPeli = 0;
        if (emaitza.next()) {
            lehenengoPeli = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return lehenengoPeli;
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
            System.out.println("Konexioa itxita");
            conn.close();
        }catch (SQLException e){
            System.err.println("Ezin izan da konexioa itxi.");
        }

    }




}
