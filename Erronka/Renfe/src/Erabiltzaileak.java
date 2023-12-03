import java.util.ArrayList;
import java.util.List;

public class Erabiltzaileak {

    String DNI;
    String izena;
    String abizena;
    double puntuak;
    List<Object> bidaiak;





    Erabiltzaileak(String DNI, String izena, String abizena){
        this.DNI = DNI;
        this.izena=izena;
        this.abizena=abizena;
        this.puntuak = 0;

        bidaiak = new ArrayList<>();

    }

    public void estimazioOkupazioa(Bidai bidai){
        int denbora= bidai.getEstimazioDenbora();
        int okupazioa=bidai.getOkupazioa();
        System.out.println("Bidaiaren luzeera: "+denbora);
        System.out.println("Okupazioa: "+okupazioa);
    }

    public void gehituBidaia(Bidai bidai){
        int bidaia= bidai.getIdBidaia();
        bidaiak.add(bidaia);
        bidai.gehituPertsona();




    }


    public void baloratu(Bidai bidai, int nota){
        int id=bidai.getIdBidaia();
        for (int i =0;i<bidaiak.size();i++){
            if (bidaiak.get(i).equals(id)){

                bidai.setBalorazioa(nota);

            }
        }
    }

    public void balorazioa(Bidai bidai){
        float nota = bidai.getBalorazioa();
        int id = bidai.getIdBidaia();
        System.out.println(id+" bidaiaren nota da: "+nota);
    }

    public double getPuntuak(){
        return puntuak;
    }

    public void puntuakIkuasi(){
        System.out.println("Izena: "+this.izena);
        System.out.println("Puntuak: "+this.puntuak);
    }

    public void lortuPuntuak(Bidai bidai, PuntuSistema puntuSistema){
        float distantzia = bidai.getDistantzia();
        String mota = bidai.getBidaiMota();

        double zenbat = puntuSistema.puntuakLortu(distantzia,mota);

        this.puntuak+=zenbat;
    }

    





}
