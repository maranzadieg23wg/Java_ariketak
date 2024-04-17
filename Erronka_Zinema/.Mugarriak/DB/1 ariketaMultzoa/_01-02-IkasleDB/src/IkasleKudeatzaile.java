import org.mariadb.*;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import org.mariadb.jdbc.client.result.ResultSetMetaData;


import java.sql.*;
import java.util.ArrayList;

public class IkasleKudeatzaile {

    private ArrayList<Ikasle> ikasleLista = new ArrayList<>();
    private ArrayList<Ikastaro> ikastaroLista = new ArrayList<>();
    private Connection conn;

    public IkasleKudeatzaile() throws ClassNotFoundException, SQLException {

        Class.forName("org.mariadb.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/ikasleDB", "irakasle", "pasahitza");

        ikasleLortu();
        ikastaroLortu();

    }

    private void ikasleLortu() throws SQLException {
        String sql = "select * from ikaselak";
        Statement kontsulta = conn.createStatement();
        ResultSet emaitza = kontsulta.executeQuery(sql);
        while (emaitza.next())
        {
            Ikasle ikasle = new Ikasle(emaitza.getInt("Id"), emaitza.getString("Izena"), emaitza.getString("Herria"), emaitza.getLong("Telefonoa"), emaitza.getDate("JaiotzeData"), emaitza.getInt("IkastaroKodea"));

            ikasleLista.add(ikasle);

        }
    }

    private void ikastaroLortu() throws SQLException {
        String sql = "select * from ikastaroak";
        Statement kontsulta = conn.createStatement();
        ResultSet emaitza = kontsulta.executeQuery(sql);
        while (emaitza.next())
        {
            Ikastaro ikastaro = new Ikastaro(emaitza.getInt("Kodea"), emaitza.getString("Izena"), emaitza.getInt("Orduak"));

            ikastaroLista.add(ikastaro);

        }
    }

    ArrayList<Ikasle> ikasleZerrenda(){
        return ikasleLista;
    }

    Ikasle bilatuIkasle(int id){

        for (Ikasle ikasle : ikasleLista){


            int id1 = ikasle.getId();

            if (id == id1){
                return ikasle;
            }

        }

        System.err.println(id+"-arekin sartutako ikaslea ez da ezistitzen");
        return null;

    }

    void ezabatuIkaslea(int id){
        
    }


    public void itxi(Connection conn) {
        try {
            conn.close();
            System.out.println("Datu-basetik deskonektatuta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
