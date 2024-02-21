import java.io.*;
import java.util.ArrayList;

public class LangileKudeatzailea {

    private String izena; //← Langilearen datuak serializatuta dagoen fitxategia da

    public LangileKudeatzailea(String izena) {
        this.izena = izena;
    }

    void gordeLangileak(ArrayList<Langile> langileak) throws IOException {

        FileOutputStream f1 = null;
        ObjectOutputStream steam = null;


        f1 = new FileOutputStream(".\\Fitxategiak\\Langilea\\"+izena+".dat");

        steam = new ObjectOutputStream(f1);

        for (Langile langile : langileak) {
            steam.writeObject(langile);
        }
        steam.writeObject(null);

        f1.close();

        steam.close();

    }

    private ArrayList<Langile> erakutsi() throws IOException, ClassNotFoundException {

        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        ArrayList<Langile> lista= new ArrayList<>();

        f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+izena+".dat");
        steam = new ObjectInputStream(f1);

        Langile langile = new Langile("???", 0, null);
        while (langile != null){
            langile = (Langile)steam.readObject();

            if (langile != null){
                lista.add(langile);
            }

        }
        return lista;

    }

    void erakutsiLangileak() throws IOException, ClassNotFoundException {

        ArrayList<Langile> lista = erakutsi();
        for (Langile langile: lista) {
            System.out.println(langile);
        }

    }

    Langile bilatuLangilea (String izena) throws IOException, ClassNotFoundException {
        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+this.izena+".dat");
        steam = new ObjectInputStream(f1);

        Langile langile = new Langile("???", 0, null);
        while (langile != null){
            langile = (Langile)steam.readObject();

            if (langile != null && langile.getIzena().equals(izena)){
                return langile;
            }

        }

        System.out.println(izena+" langilea ez da aurkitu");
        return null;
    }

    void sortuMugikorrenFitxategia (String izena) throws ClassNotFoundException, IOException {
        FileInputStream f1 = null;
        ObjectInputStream steam = null;

        FileOutputStream f2 = null;
        ObjectOutputStream steamP = null;

        f2 = new FileOutputStream(".\\Fitxategiak\\Telefonoa\\"+izena+".dat");

        steamP = new ObjectOutputStream(f2);

        f1 = new FileInputStream(".\\Fitxategiak\\Langilea\\"+this.izena+".dat");
        steam = new ObjectInputStream(f1);

        Langile langile = new Langile("???", 0, null);
        while (langile != null){
            langile = (Langile)steam.readObject();

            if (langile != null){
                Mugikor mugikor = langile.getMugikor();
                steamP.writeObject(mugikor);
                System.out.println(mugikor);
            }
        }

        steamP.writeObject(null);

        f1.close();

        steam.close();


        f2.close();

        steamP.close();
    }

    void lanEgin() throws IOException, ClassNotFoundException {

        ArrayList<Langile> lista = erakutsi();

        ArrayList<Langile> list = new ArrayList<>();


        for (Langile langile:lista) {
            langile.lanEgin();
            list.add(langile);
        }


        gordeLangileak(list);

    }
}
