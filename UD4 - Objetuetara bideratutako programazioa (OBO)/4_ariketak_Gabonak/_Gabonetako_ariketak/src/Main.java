import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Ileapaindegia sortzen
        Apaindegi apaindegi = new Apaindegi(10, 20);

        //Bezeroak sortzen.
        apaindegi.gehituBezeroa("Manex", "12345678R");
        apaindegi.gehituBezeroa("Manolo", "98765432A");
        apaindegi.gehituBezeroa("Patxi", "57864321T");


        //Bi bezeroei ezartzen maila
        apaindegi.esleituBazkideMaila(apaindegi.jasoBezeroa("12345678R"), "Urre");
        apaindegi.esleituBazkideMaila(apaindegi.jasoBezeroa("98765432A"), "Premium");

        //Gehitzen bisitak
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("12345678R"), LocalDate.parse("2024-01-02"));
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("98765432A"), LocalDate.parse("2023-12-29"));
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("57864321T"), LocalDate.parse("2024-01-08"));


        //Gehitzen zenbat ordaindu duten.
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("12345678R"), LocalDate.parse("2024-01-02"), 100);
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("98765432A"), LocalDate.parse("2023-12-29"), 22);
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("57864321T"), LocalDate.parse("2024-01-08"), 56);


        apaindegi.erakutsiBezeroak();
        apaindegi.erakutsiBisitak();







    }
}