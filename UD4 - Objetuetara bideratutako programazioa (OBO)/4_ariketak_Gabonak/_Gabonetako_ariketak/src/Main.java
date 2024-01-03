import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Bezero b1 = new Bezero("Manex", "12345678R");
        Bezero b2 = new Bezero("Manex", "12345678R", "Urre");


        Bisita bi1 = new Bisita(b2, LocalDate.parse("2020-07-06"));


        System.out.println(b1.toString());
        System.out.println(b2.toString());

        System.out.println(bi1.kalkulatuZenbatekoa(100));
        System.out.println(bi1.toString());


    }
}