import java.io.*;

import static java.lang.Long.parseLong;

public class AgendaKudeatzaile {


    private String izena; //← Fitxategiaren izena izan behar den

    //private  BufferedReader f1;

    public AgendaKudeatzaile(String izena) throws IOException {
        this.izena = izena;
        BufferedReader f1 = null;
        try {
            f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
        }catch (FileNotFoundException e){
            throw new Salbuespenak("Ezin da "+izena+"-ko agenda aurkitu");
        }finally {
            f1.close();
        }


    }


    void erakutsi() throws IOException {
        BufferedReader f1 = null;
        try {
            f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
            String line;
            while ((line = f1.readLine()) !=null){
                System.out.println(line);
            }
            f1.close();
        }catch (IOException e){
            throw new Salbuespenak("Ezin izan da ireki fitxategia eta ikusi bertan dauden kontaktuak");
        }finally {
            f1.close();
        }


    }

    void gehituPertsona(Pertsona pertsona) throws IOException {
        BufferedWriter w1 = null;
        try {
            w1 = new BufferedWriter(new FileWriter(".\\agenda\\"+this.izena, true));

            String izena = pertsona.getIzena();
            long telefonoa = pertsona.getTelefonoa();
            String herria = pertsona.getHerria();

            //System.out.println(izena+ telefonoa+ herria);
            w1.newLine();
            w1.write(izena+" "+telefonoa+" "+herria);
            w1.close();
        }catch (IOException e){
            throw new Salbuespenak("Ezin izan da gehitu "+izena+" pertsonaren datuak "+izena+" agendara.");
        }finally {
            w1.close();
        }

    }

    Pertsona pertsonaBilatu(String izena) throws IOException {
        BufferedReader f1 = null;
        try {
            f1 = new BufferedReader(new FileReader(".\\agenda\\"+this.izena));
            String line;
            while ((line = f1.readLine()) !=null){

                String[] datuak = line.split(" ");

                if (datuak[0].equals(izena)){
                    f1.close();
                    return new Pertsona(datuak[0], parseLong(datuak[1]), datuak[2]);
                }
            }
            f1.close();

            return null;
        }catch (IOException e){
            throw new Salbuespenak("Ezin izan da ireki "+izena+" agenda");
        }catch (NumberFormatException e){
            throw new Salbuespenak("Bilatzen harin den pertsonak daturen bat gaizki dauka sartuta");
        }
        finally {
            f1.close();
        }




    }
}
