import java.time.LocalDate;
import java.util.ArrayList;

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
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("12345678R"), 2024, 1,10);
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("12345678R"),  2024, 3,1);

        apaindegi.gehituBisita(apaindegi.jasoBezeroa("98765432A"),  2024, 12,31);
        apaindegi.gehituBisita(apaindegi.jasoBezeroa("57864321T"),  2024, 3,1);


        //Gehitzen zenbat ordaindu duten.
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("12345678R"),  2024, 1,10, 100);
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("98765432A"), 2024, 12,31, 22);
        apaindegi.gehituZenbatekoa(apaindegi.jasoBezeroa("57864321T"), 2024, 3,1,56);


        //Hemen bezero eta bisita lista lortzen dugu.
        //apaindegi.erakutsiBezeroak();
        apaindegi.erakutsiBisitak();










    }
}