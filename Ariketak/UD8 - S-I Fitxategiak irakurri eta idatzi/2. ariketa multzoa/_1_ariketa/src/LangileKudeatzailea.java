import java.io.*;
import java.util.ArrayList;

public class LangileKudeatzailea {

    private String izena; //← Langilearen datuak serializatuta dagoen fitxategia da

    private String telIzena; // ← Langileen telefonoak gorde egingo den lista.

    public LangileKudeatzailea(String izena) {
        this.izena = izena;
    }

    void gordeLangileak(ArrayList<Langile> langileak){

        FileOutputStream f1 = null;
        ObjectOutputStream steam = null;


        try{
            f1 = new FileOutputStream(".\\Fitxategiak\\Langilea\\"+izena+".dat");

            steam = new ObjectOutputStream(f1);
        } catch (FileNotFoundException e) {
            System.err.println("Ezin izan da aurkitu \\Langilea\\"+izena+".dat fitxategia");
        } catch (IOException e) {
            System.err.println("Arazo general bat gertatu egin da.");
        }



        for (Langile langile : langileak) {
            try {
                steam.writeObject(langile);
            }catch (IOException e) {
                System.err.println("Ezin izan da "+langile.getIzena()+" langilearen datuak gorde fitxategian.");
            }
        }

        try {
            steam.writeObject(null);

            f1.close();

            steam.close();
        } catch (IOException e) {
            System.err.println("Ezin izan dira itxi fitxategiak bertan datuak gorde al izateko.");
        }


    }

    private ArrayList<Langile> erakutsi() {

        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        ArrayList<Langile> lista= new ArrayList<>();


        try {
            f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+izena+".dat");
            steam = new ObjectInputStream(f1);
        }catch (IOException e){
            System.err.println("Ezin izan da aurkitu \\Langilea\\"+izena+".dat fitxategia");
        }


        Langile langile = new Langile("???", 0, null);
        while (langile != null){

            try {
                langile = (Langile)steam.readObject();
            } catch (IOException e) {
                System.err.println("Ezin izan da "+langile.getIzena()+" langilearen datuak ongi irakurri");
            } catch (ClassNotFoundException e) {
                System.err.println("Fitxategian dagoen datua ez da Langile motakoa.");
            }

            if (langile != null){
                lista.add(langile);
            }

        }
        return lista;

    }

    void erakutsiLangileak(){

        ArrayList<Langile> lista = erakutsi();
        for (Langile langile: lista) {
            System.out.println(langile);
        }

    }

    Langile bilatuLangilea (String izena){
        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        try {
            f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+this.izena+".dat");
            steam = new ObjectInputStream(f1);
        }catch (IOException e){
            System.err.println("Ezin izan da aurkitu \\Langilea\\"+izena+".dat fitxategia");
        }


        Langile langile = new Langile("???", 0, null);
        while (langile != null){

            try {
                langile = (Langile)steam.readObject();
            } catch (IOException e) {
                System.err.println("Ezin izan da "+langile.getIzena()+" langilearen datuak ongi irakurri");
            } catch (ClassNotFoundException e) {
            System.err.println("Fitxategian dagoen datua ez da Langile motakoa.");
                }

            if (langile != null && langile.getIzena().equals(izena)){
                return langile;
            }

        }

        System.out.println(izena+" langilea ez da aurkitu");
        return null;
    }

    void sortuMugikorrenFitxategia (String izena){
        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        FileOutputStream f2 = null;
        ObjectOutputStream steamP = null;

        try {
            f2 = new FileOutputStream(".\\Fitxategiak\\Telefonoa\\"+izena+".dat");
            steamP = new ObjectOutputStream(f2);
        }catch (IOException e){
            System.err.println("Ezin izan da ireki \\Telefonoa\\"+izena+".dat fitxategia.");
        }

        try{
            f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+this.izena+".dat");
            steam = new ObjectInputStream(f1);
        }catch (IOException e){
            System.err.println("Ezin izan da ireki \\Langilea\\"+this.izena+".dat fitxategia.");
        }


        Langile langile = new Langile("???", 0, null);
        while (langile != null){
            try{
                langile = (Langile)steam.readObject();
            }catch (ClassNotFoundException | IOException e){
                System.err.println("Saiatzen den fitxategia irakurtzen, bertan dauden langieak ez dira Langile klasekoak");
            }

            if (langile != null){
                Mugikor mugikor = langile.getMugikor();
                try {
                    steamP.writeObject(mugikor);

                }catch (IOException e){
                    System.err.println("Ezin izan da idatzi telefonoen datuak \\Telefonoa\\\\\"+izena+\".dat fitxategia.");
                }
                // System.out.println(mugikor); //← erakusteko zein datu dauden gehitzen.
            }
        }

        try {
            steamP.writeObject(null);

            f1.close();

            steam.close();


            f2.close();

            steamP.close();
        } catch (IOException e) {
            System.err.println("Ezin izan dira itzi Langile eta Telefonoen fitxategiak");
        }

        telIzena = izena;

    }

    void lanEgin(){

        ArrayList<Langile> lista = erakutsi();

        ArrayList<Langile> list = new ArrayList<>();


        for (Langile langile:lista) {
            langile.lanEgin();
            list.add(langile);
        }


        gordeLangileak(list);
        sortuMugikorrenFitxategia(this.telIzena);

    }
}
