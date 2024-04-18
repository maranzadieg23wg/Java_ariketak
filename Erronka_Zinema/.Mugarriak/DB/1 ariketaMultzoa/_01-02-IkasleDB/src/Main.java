import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        IkasleKudeatzaile ku = new IkasleKudeatzaile();

        /*System.out.println(ku.bilatuIkasle("CCC"));

        ku.modifikatuIkaslea("CCC");

        System.out.println(ku.bilatuIkasle("CCC"));*/


        //ku.erakutsiIkastaroa("BBB");



        /*Ikasle ikasle = new Ikasle();

        //ku.gehituIkaslea(ikasle);
        System.out.println(ku.bilatuIkasle("KKK"));*/




        //ku.ezabatuIkaslea("KKK");
        ku.ikasleakIkusi();

        ku.itxi();
    }
}