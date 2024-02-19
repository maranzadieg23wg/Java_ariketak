import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        AgendaKudeatzaile agenda = new AgendaKudeatzaile("agenda.txt");

        //agenda.erakutsi();

        //Pertsona pertsona1 = new Pertsona("Manolo", 1231231231, "Sevilla");
        //agenda.gehituPertsona(pertsona1);
        agenda.erakutsi();


        Pertsona proba = agenda.pertsonaBilatu("Jacques");

        if (proba != null){
            System.out.println(proba.toString());
        }else {
            System.err.println("Bilatutako pertsona ez dago agendan");
        }

        try {



        }catch (IOException e){
            System.err.println("Arazoren bat gertatu da.");
        }










    }
}