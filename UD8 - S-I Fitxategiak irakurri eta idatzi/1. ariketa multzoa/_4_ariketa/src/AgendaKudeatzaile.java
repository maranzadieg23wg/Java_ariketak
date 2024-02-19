import java.io.*;

import static java.lang.Long.parseLong;

public class AgendaKudeatzaile {


    private String izena; //← Fitxategiaren izena izan behar den

    //private  BufferedReader f1;

    public AgendaKudeatzaile(String izena) {
        this.izena = izena;
        try {
            BufferedReader f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        }catch (IOException e){
            System.err.println("Fitxategia ez da aurkitu");
        }

    }


    void erakutsi() throws IOException {

        BufferedReader f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        String line;
        while ((line = f1.readLine()) !=null){
            System.out.println(line);
        }
        f1.close();

    }

    void gehituPertsona(Pertsona pertsona) throws IOException {

        BufferedWriter w1 = new BufferedWriter(new FileWriter(".\\agenda\\"+this.izena, true));

        String izena = pertsona.getIzena();
        long telefonoa = pertsona.getTelefonoa();
        String herria = pertsona.getHerria();

        //System.out.println(izena+ telefonoa+ herria);
        w1.newLine();
        w1.write(izena+"    "+telefonoa+"   "+herria);
        w1.close();

    }

    Pertsona pertsonaBilatu(String izena) throws IOException {

        BufferedReader f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        String line;
        while ((line = f1.readLine()) !=null){

            String[] datuak = line.split(" ");

            if (datuak[0].equals(izena)){
                return new Pertsona(datuak[0], parseLong(datuak[1]), datuak[2]);
            }
        }
        f1.close();
        return null;



    }
}
