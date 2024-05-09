package DB;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import GUI.Borratu;
import GUI.Irabazi;
import Objetuak.Argazkia;
import Objetuak.Argazkilari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Konexioa {

    private static Connection conn;

    private static boolean bai = false;

    private static ArrayList<Argazkilari> list;

    static HashMap<Integer, Integer> argazkilariHash;



    public Konexioa() {

        argazkilariHash = new HashMap<>();

        konexiaEgin();
        list = new ArrayList<>();



        lortuArgazkilariak();


    }


    void lortuArgazkilariak(){
        list.clear();

        try {
            String sql = "select * from Argazkilari";
            PreparedStatement kontsulta = conn.prepareStatement(sql);

            ResultSet emaitza = kontsulta.executeQuery();

            while (emaitza.next()){
                Argazkilari argazkilari = argazkilariObejetua(emaitza);

                gehituArgazkilari(argazkilari);

                int id = emaitza.getInt(1);
                int zenbat =bisitaKop(id);
                System.out.println("id: "+id);
                System.out.println("zenbat: "+zenbat);
                argazkilariHash.put(id, zenbat);



            }

            lortuIrudiak();
        }catch (SQLException e){
            //System.err.println("e: "+e.getErrorCode());
            System.err.println("Ezin izan da lortu argazkilarien informazioa");
        }
    }

    int bisitaKop(int id){
        try {
            String sql = "select sum(BistarateKop) from Argazkiak where idArgazkilari =?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, id);


            ResultSet emaitza = kontsulta.executeQuery();


            if (emaitza.next()){
                return emaitza.getInt(1);
            }else {
                return -1;
            }

        }catch (SQLException e){
            System.out.println(e);
            System.out.println(e.getErrorCode());
            return -1;
        }



    }

    void lortuIrudiak(){
        try {
            String sql = "select * from Argazkiak";
            PreparedStatement kontsulta = conn.prepareStatement(sql);

            ResultSet emaitza = kontsulta.executeQuery();


            while (emaitza.next()){



                Argazkia argazkia = argazkiaObjetua(emaitza);


                for (Argazkilari arga : list){
                    if (arga.getID() == argazkia.getIDArgazkilari()){
                        arga.gehituArgazki(argazkia);
                    }
                }




            }
        }catch (SQLException e){
            //System.err.println("e: "+e.getErrorCode());
            System.err.println("Ezin izan da lortu argazkien informazioa");
        }
    }

    void gehituArgazkilari(Argazkilari argazkilari){
        if (!listanDago(argazkilari)){
            list.add(argazkilari);
        }
    }

    boolean listanDago(Argazkilari argazkilari){
        for (Argazkilari argazkilari1 : list){
            if (argazkilari1.equals(argazkilari)){
                return true;
            }
        }

        return false;
    }


    //**************+*********SORTU OBJETUAK***************************

    Argazkilari argazkilariObejetua(ResultSet pel) throws SQLException {




        int IDArgazkilari = pel.getInt("IdArgazkilari");
        String izena = pel.getString("Izena");
        int saritua = pel.getInt("Saritua");


        return new Argazkilari(IDArgazkilari, izena, saritua);


    }
    Argazkia argazkiaObjetua(ResultSet pel) throws SQLException {




        int IdArgazki = pel.getInt(1);
        String izenburua = pel.getString(2);
        Date data = Date.valueOf(pel.getString(3));
        String fitxategia = pel.getString(4);
        int bistaratzeKop = pel.getInt(5);
        int idArgazkilaria = pel.getInt(6);



        return new Argazkia(IdArgazki, izenburua, data, fitxategia, bistaratzeKop, idArgazkilaria);


    }

    public void eguneratu(int id) throws SQLException {

        String sql = "SELECT BistarateKop FROM Argazkiak WHERE IDArgazkia = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, id);



        ResultSet emaitza = kontsulta.executeQuery();
        emaitza.next();



        int zenbat = emaitza.getInt("BistarateKop");
        if (bai){
            zenbat++;

            String sql1 = "update Argazkiak set BistarateKop =? WHERE IDArgazkia = ?";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql1);
            kontsulta2.setInt(2, id);
            kontsulta2.setInt(1, zenbat);

            int rowsAffected = kontsulta2.executeUpdate();
            bai = false;
        }else {
            bai = true;
        }


    }

    static public void irabazi(){

        int zenbat = Irabazi.menua();
        System.out.println(zenbat);
        for (Argazkilari argazkilari : list){

            int id = argazkilari.getID();



            int zen = argazkilariHash.get(id);

            System.out.println("zen"+zen);

            if (zen>=zenbat && zenbat !=-1){
                try {
                    String sql = "update Argazkilari set saritua =1 WHERE IdArgazkilari = ?";
                    PreparedStatement kontsulta = conn.prepareStatement(sql);
                    kontsulta.setInt(1, id);
                    int z = kontsulta.executeUpdate();
                    System.out.println("z: "+z);
                }catch (SQLException e){
                    System.out.println(e.getErrorCode());
                }

            }
        }
    }

    public void borratu() throws SQLException {
        for (Argazkilari argazkilari : list){

            int id = argazkilari.getID();


            int zen = argazkilariHash.get(id);

            String sql = "select * from Argazkiak where idArgazkilari =?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, id);

            ResultSet erantzuna = kontsulta.executeQuery();


            while (erantzuna.next()){
                int zenbat = erantzuna.getInt(5);
                System.out.println("zenbat: "+zenbat);

                if (zenbat<=0){
                    boolean borr = Borratu.menua(erantzuna.getString(2));
                    if (borr){
                        try {
                            String sql1 = "DELETE FROM Argazkiak WHERE IdArgazkia = ?";
                            PreparedStatement kontsulta1 = conn.prepareStatement(sql1);
                            kontsulta1.setInt(1, erantzuna.getInt(1));
                            int z=kontsulta1.executeUpdate();

                            System.out.println("z: "+z);
                        }catch (SQLException e){
                            System.out.println(e.getErrorCode());
                        }
                    }

                }
            }
        }


        lortuArgazkilariak();
        borratuArgazkilaro();

    }

    void borratuArgazkilaro() throws SQLException {
        for (Argazkilari argazkilari : list){

            int id = argazkilari.getID();


            int zen = argazkilariHash.get(id);

            if (zen <=0){
                String sql = "delete from Argazkilari where idArgazkilari = ? and Saritua =0";
                PreparedStatement kontsulta = conn.prepareStatement(sql);
                kontsulta.setInt(1, id);

                kontsulta.executeQuery();
            }
        }

        lortuArgazkilariak();
    }

    //************************Lortu Lista*****************************

    public ArrayList<Argazkilari> getList() {
        return list;
    }


    //************************KONEXIOA*********************************

    /**
     * Datu basera konektatzeko konexioa ireki behar dugu, eta horretarako erabiltzen da funtzio hau.
     * <blockquote>{@code konexioaEgin();}</blockquote>
     */
    void konexiaEgin(){

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ArgazkilariDB", "root", "root");
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
