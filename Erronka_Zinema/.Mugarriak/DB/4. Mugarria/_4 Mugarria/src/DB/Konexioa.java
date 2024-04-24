package DB;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import Objetuak.Argazkia;
import Objetuak.Argazkilari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Konexioa {

    private Connection conn;

    private static boolean bai = false;

    private ArrayList<Argazkilari> list;




    public Konexioa() {

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

            }

            lortuIrudiak();
        }catch (SQLException e){
            //System.err.println("e: "+e.getErrorCode());
            System.err.println("Ezin izan da lortu argazkilarien informazioa");
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
