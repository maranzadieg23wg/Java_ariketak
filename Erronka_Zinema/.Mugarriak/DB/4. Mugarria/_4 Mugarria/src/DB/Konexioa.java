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

                if (!listanDago(argazkilari)){
                    list.add(argazkilari);
                }

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

        if (!pel.next()) {
            return null;
        }


        int IDArgazkilari = pel.getInt("IdArgazkilari");
        String izena = pel.getString("Izena");
        int saritua = pel.getInt("Saritua");


        return new Argazkilari(IDArgazkilari, izena, saritua);


    }
    Argazkia argazkiaObjetua(ResultSet pel) throws SQLException {

        if (!pel.next()) {
            return null;
        }


        int IdArgazki = pel.getInt("IdArgazki");
        String izenburua = pel.getString("Izenburua");
        Date data = pel.getDate("Data");
        String fitxategia = pel.getString("Fitxategia");
        int bistaratzeKop = pel.getInt("BistaratzeKop");
        int idArgazkilaria = pel.getInt("IdArgazkilari");


        return new Argazkia(IdArgazki, izenburua, data, fitxategia, bistaratzeKop, idArgazkilaria);


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
