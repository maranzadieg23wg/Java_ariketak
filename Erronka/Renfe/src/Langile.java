import java.util.ArrayList;
import java.util.List;

public class Langile {


    int DNI;
    String izena;
    String abizena;
    int telefonoa;
    int lanekoTelefonoa;
    String email;
    int jaiotzeData;

    List<String> kurtsoak;


    Langile(int DNI, String izena, String abizena, int telefonoa, int lanekoTelefonoa, String email, int jaiotzeData){

        this.DNI = DNI;
        this.izena=izena;
        this.abizena=abizena;
        this.telefonoa=telefonoa;
        this.lanekoTelefonoa = lanekoTelefonoa;
        this.email = email;
        this.jaiotzeData = jaiotzeData;

        kurtsoak = new ArrayList<>();
    }

}
