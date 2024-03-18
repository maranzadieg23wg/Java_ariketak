import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        LangileKudeatzailea kudeatzailea = new LangileKudeatzailea("langileak");

        Langile l1 = new Langile("Manolo", 1000, new Mugikor(5, 100));
        Langile l2 = new Langile("Julen", 1111, new Mugikor(6, 50));
        Langile l3 = new Langile("Ima", 6666, new Mugikor(10, 20));
        Langile l4 = new Langile("Aimar", 11, new Mugikor(102, 60));
        Langile l5 = new Langile("Aivan", 1, new Mugikor(15, 11));


        ArrayList<Langile> lista = new ArrayList<>();
        lista.add(l1);
        lista.add(l2);
        lista.add(l3);
        lista.add(l4);
        lista.add(l5);


        kudeatzailea.gordeLangileak(lista);

        kudeatzailea.erakutsiLangileak();

        System.out.println("---------------------------------------------------------------");

        System.out.println(kudeatzailea.bilatuLangilea("Ima"));
        System.out.println("---------------------------------------------------------------");

        kudeatzailea.sortuMugikorrenFitxategia("mugikorrak");
        System.out.println("---------------------------------------------------------------");

        kudeatzailea.lanEgin();
        kudeatzailea.erakutsiLangileak();




    }
}