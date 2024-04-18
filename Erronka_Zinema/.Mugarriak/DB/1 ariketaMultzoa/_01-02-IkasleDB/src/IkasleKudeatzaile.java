import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;


import java.sql.*;
import java.util.ArrayList;

public class IkasleKudeatzaile {

    private ArrayList<Ikasle> ikasleLista = new ArrayList<>();
    private ArrayList<Ikastaro> ikastaroLista = new ArrayList<>();
    private Connection conn;

    public IkasleKudeatzaile() throws ClassNotFoundException, SQLException {

        Class.forName("org.mariadb.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/IkasleDB", "root", "root");
        System.out.println("Datu basera konektatuta");

        ikasleLortu();
        ikastaroLortu();

    }

    private void ikasleLortu() throws SQLException {
        String sql = "select * from Ikasleak";
        Statement kontsulta = conn.createStatement();
        ResultSet emaitza = kontsulta.executeQuery(sql);
        while (emaitza.next())
        {
            Ikasle ikasle = new Ikasle(emaitza.getString("Id"), emaitza.getString("Izena"), emaitza.getString("Herria"), emaitza.getLong("Telefonoa"), emaitza.getDate("JaiotzeData"), emaitza.getInt("IkastaroKodea"));

            ikasleLista.add(ikasle);

        }
    }

    private void ikastaroLortu() throws SQLException {
        String sql = "select * from Ikastaroak";
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

    Ikasle bilatuIkasle(String id){

        for (Ikasle ikasle : ikasleLista){


            String id1 = ikasle.getId();

            if (id.equals(id1)){
                return ikasle;
            }

        }

        System.err.println(id+"-arekin sartutako ikaslea ez da ezistitzen");
        return null;

    }

    void ezabatuIkaslea(String id) throws SQLException {

        Ikasle ikasle = bilatuIkasle(id);

        if (ikasle !=null){
            String sql = "DELETE FROM Ikasleak WHERE Id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            ikasleLortu();

        }

    }

    void gehituIkaslea(Ikasle ikaslea) throws SQLException {
        String id = ikaslea.getId();
        String izena = ikaslea.getIzena();
        String herria = ikaslea.getHerria();
        long telefonoa = ikaslea.getTelefonoa();
        java.sql.Date jaiotzeData = ikaslea.getJaiotzeData();
        int ikastaroKodea = ikaslea.getIkastaroKodea();

        String sql = "INSERT INTO Ikasleak VALUES ('" + id + "', '" + izena + "', '" + herria + "', '" + telefonoa + "', '" + jaiotzeData + "', " + ikastaroKodea + ")";
        Statement kontsulta = conn.createStatement();
        int aldatuFilak = kontsulta.executeUpdate(sql);

        ikasleLortu();

    }

    void modifikatuIkaslea(String id) throws SQLException {
        Ikasle ikasle = bilatuIkasle(id);

        if (ikasle != null){
            Ikasle ik = new Ikasle(ikasle);


            String id1 = ik.getId();
            String izena = ik.getIzena();
            String herria = ik.getHerria();
            long telefonoa = ik.getTelefonoa();
            java.sql.Date jaiotzeData = ik.getJaiotzeData();
            int ikastaroKodea = ik.getIkastaroKodea();

            String sql = "update Ikasleak set Id ="+id1+", Izena ="+izena +", Herria ="+herria+", Telefonoa ="+telefonoa+", JaiotzeData ="+jaiotzeData+", IkastaroKodea ="+ikastaroKodea+" where Id ="+id;
            Statement kontsulta = conn.createStatement();
            ResultSet emaitza = kontsulta.executeQuery(sql);
            ikasleLortu();

        }
    }

    void erakutsiIkastaroa(String id){
        Ikasle ikasle = bilatuIkasle(id);

        if (ikasle != null){

            int ikastaroKodea = ikasle.getIkastaroKodea();

            for (Ikastaro ikastaro : ikastaroLista){

                    int id1 = ikastaro.getId();

                    if (ikastaroKodea == id1){
                        System.out.println(ikastaro.toString());
                        break;
                    }

            }

        }
    }

    void ikasleakIkusi(){

        ArrayList<Ikasle> lista = ikasleZerrenda();

        for (Ikasle ikas : lista){
            System.out.println(ikas);
        }

    }




    public void itxi() {
        try {
            conn.close();
            System.out.println("Datu-basetik deskonektatuta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
