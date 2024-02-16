import java.io.*;

public class AgendaKudeatzaile {


    private String izena; //← Fitxategiaren izena izan behar den

    private  BufferedReader f1;

    public AgendaKudeatzaile(String izena) {
        this.izena = izena;
        try {
            this.f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        }catch (IOException e){
            System.err.println("Fitxategia ez da aurkitu");
        }

    }


    void erakutsi() throws IOException {

        this.f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        String line;
        while ((line = f1.readLine()) !=null){
            System.out.println(line);
        }

    }

    void gehituPertsona(Pertsona pertsona) throws IOException {

        BufferedWriter w1 = new BufferedWriter(new FileWriter(".\\agenda\\"+this.izena, true));

        String izena = pertsona.getIzena();
        String telefonoa = pertsona.getTelefonoa();
        String herria = pertsona.getHerria();

        //System.out.println(izena+ telefonoa+ herria);
        w1.newLine();
        w1.write(izena+"    "+telefonoa+"   "+herria);
        w1.close();
    }
}
