import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        IkasleKudeatzaile ku = new IkasleKudeatzaile();

        System.out.println(ku.bilatuIkasle("CCC"));

        ku.modifikatuIkaslea("CCC");

        System.out.println(ku.bilatuIkasle("CCC"));


        ku.itxi();
    }
}