package Torneo;

import surfPakete.Babesle;
import surfPakete.Surflari;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Torneo {

    private String izena;
    private ArrayList<Surflari> surflariak;

    private Babesle [] babesleLista;


    public Torneo(String izena) {
        this.izena = izena;

        surflariak = new ArrayList<>();

        babesleLista = new Babesle[10];
        //System.out.println(babesleLista[9]);
    }



    public void gehituSurflaria(Surflari surflari){
        int pos = surflari.getRankingPos();

        try {
            if (pos>20){

                throw new Salbuespen("Surflaria ez dago 20 rankinean");
            }
        }catch (Salbuespen e){
            System.err.println(e.getMessage());
        }

        surflariak.add(surflari);

    }

    public ArrayList<Surflari> surflariakBabeslearekin(Babesle babesle){

        ArrayList <Surflari> lista = new ArrayList<>();

        for (Surflari surf: surflariak) {

            if (surf.getBabesle().equals(babesle)){
                lista.add(surf);
            }

        }

        return lista;
    }

    public ArrayList<Surflari> surflariakTorneokoBabelearekin(){

        Babesle babesle = null;

        while (babesle == null){
            int pos = (int)(Math.random()*10);
            //System.out.println(pos);

            babesle = babesleLista[pos];
        }


        return surflariakBabeslearekin(babesle);

    }

    public void gehituBabesle(Babesle babesle){



        for (int i =0;i<babesleLista.length;i++){
            try {
                if (babesleLista[i] != null &&babesleLista[i].equals(babesle)){
                    throw new Salbuespen("Babeslea listan dago");
                }
            }catch (Salbuespen e){
                System.err.println(e.getMessage());
            }

            if (babesleLista[i]==null){
                babesleLista[i]= babesle;
                i = babesleLista.length+2;
            }
        }



    }

    public void igoTorneoKategoria(){
        int top =15;

        ArrayList<Surflari> lista = new ArrayList<>();

        for (Surflari surf:surflariak) {
            if (surf.getRankingPos()<=15){
                lista.add(surf);
            }
        }

        surflariak.clear();
        surflariak = lista;


    }


    public void gordeFitxategian()   {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(".\\fitxategiak\\srflariak.bin"));

            for (Surflari surf:surflariak) {
                String izena = surf.getIzena();
                bw.write(izena+";");
            }
            bw.close();
            System.out.println("gordeta");

        }catch (IOException e){
            System.err.println("Arazo bat gertatu da idaztean datuak.");
        }

    }


}
