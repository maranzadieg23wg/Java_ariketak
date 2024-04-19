package DatuBase;
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





    }

    void menua(){





    }

    void sortuKontua() throws SQLException {

        System.out.println("-----------KONTUA SORTU-----------");
        System.out.print("Erabiltzailea: ");
        String erabiltzailea = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        int pasahitzaHash = pasahitza.hashCode();
        pasahitza = null;


        //Begiratu ea existitzen den
        String sql = "select count(*) from ERABILTZAILEAK where (erabiltzailea = ? or emaila = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, erabiltzailea);
        kontsulta.setString(2, erabiltzailea);

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza!=0){
            System.err.println(erabiltzailea+" erabiltzailearekin kontu bat existitzen da");
        }else {
            
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
