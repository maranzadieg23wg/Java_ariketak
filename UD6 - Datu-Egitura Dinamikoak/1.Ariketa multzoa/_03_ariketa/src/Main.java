import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Pelikula p1 = new Pelikula("Beyond the fog", 2023, 100);

        Pelikula p2 = new Pelikula("Poor thinks", 2024, 150);

        Pelikula p3 = new Pelikula("En nombre de la tierra", 2023, 200);

        Zinema z1 = new Zinema("Prinzipe", 5);

        z1.gehituPelikula(p1);
        z1.gehituPelikula(p2,3);
        z1.gehituPelikula(p3);


        /*z1.erakutsi();

        z1.ezabatuPelikula("Poor thinks");

        z1.erakutsi();

        ArrayList<Integer> libre = z1.aretoLibreak();
        System.out.println(libre);


        //z1.garbituZinema();

        ArrayList<Integer> libre2 = z1.aretoLibreak();
        System.out.println(libre2);


        z1.erakutsi();
        z1.aldatuAretoa(p1);
        z1.erakutsi();
        */


        ArrayList<Pelikula> gutxiago = z1.motzagoakBaino(2, 10);
        System.out.println(gutxiago);




    }
}