import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        AgendaKudeatzaile agenda = new AgendaKudeatzaile("agenda.txt");

        agenda.erakutsi();

        Pertsona pertsona1 = new Pertsona("Manolo", "123123123123", "Sevilla");
        agenda.gehituPertsona(pertsona1);
        agenda.erakutsi();









    }
}