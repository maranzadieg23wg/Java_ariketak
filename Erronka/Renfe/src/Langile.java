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


    Langile(int DNI, String izena, String abizena, int telefonoa, int lanekoTelefonoa, String email, int jaiotzeData) {

        this.DNI = DNI;
        this.izena = izena;
        this.abizena = abizena;
        this.telefonoa = telefonoa;
        this.lanekoTelefonoa = lanekoTelefonoa;
        this.email = email;
        this.jaiotzeData = jaiotzeData;

        kurtsoak = new ArrayList<>();
    }


    public void datuakErakutsi() {
        System.out.println("DNI: " + DNI);
        System.out.println("Izen-Abizena: " + izena + " " + abizena);
        System.out.println("Telefono pertsonala: " + telefonoa);
        System.out.println("Laneko telefonoa: " + lanekoTelefonoa);
        System.out.println("Emaila: " + email);
        System.out.println("Jaiotze data: " + jaiotzeData);


    }

    public void datuakAldatu(int DNIberria, String izenBerria, String abizenBerria, int telefonoBerria, int lanekoTelefonoBerria, String emailBerria, int jaiotzeDataBerria) {
        this.DNI = DNIberria;
        this.izena = izenBerria;
        this.abizena = abizenBerria;
        this.telefonoa = telefonoBerria;
        this.lanekoTelefonoa = lanekoTelefonoBerria;
        this.email = emailBerria;
        this.jaiotzeData = jaiotzeDataBerria;
    }

    public void ikusiIkastariak(){
        System.out.println("Ikastaroak: ");
        for (int i =0;i<kurtsoak.size();i+=2){
            System.out.println("ID: "+kurtsoak.get(i));
            System.out.println("Izena: "+kurtsoak.get(i+1));
        }
    }

    public void gehituIkastaroa(int idIkastaroa, String ikastaroIzena){
        kurtsoak.add(idIkastaroa, ikastaroIzena);
    }

    public void borratuIkastaroa(int idIkastaroa){
        for (int i =0;i<kurtsoak.size();i+=2){
            if (kurtsoak.get(i).equals(idIkastaroa)) {
                kurtsoak.remove(i);
                kurtsoak.remove(i + 1);
            }
        }
    }

}
