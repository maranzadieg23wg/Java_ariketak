import java.io.*;

public class LangileKudeatzailea {

    private String izena; //← Langilearen datuak serializatuta dagoen fitxategia da

    public LangileKudeatzailea(String izena) {
        this.izena = izena;
    }

    void gordeLangileak(Langile[]langieak) throws IOException {

        FileOutputStream f1 = null;
        ObjectOutputStream steam = null;


        f1 = new FileOutputStream(".\\Fitxategiak\\"+izena+".dat");

        steam = new ObjectOutputStream(f1);

        for (Langile langile : langieak) {
            steam.writeObject(langile);
        }
        steam.writeObject(null);

        steam.close();

    }
}
