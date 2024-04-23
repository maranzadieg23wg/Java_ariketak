package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Konexioa {

    private Connection conn;


 

    public Konexioa() {

        konexiaEgin();
    }


    //************************KONEXIOA*********************************

    /**
     * Datu basera konektatzeko konexioa ireki behar dugu, eta horretarako erabiltzen da funtzio hau.
     * <blockquote>{@code konexioaEgin();}</blockquote>
     */
    void konexiaEgin(){

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/IkasleDB", "root", "root");
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
