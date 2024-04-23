import DB.Konexioa;
import GUI.Index;
import Objetuak.Argazkilari;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Konexioa conn = new Konexioa();

        ArrayList<Argazkilari> lista = conn.getList();

        for (Argazkilari arha: lista){
            System.out.println(arha);
        }

        conn.konexioaItxi();


        Index index = new Index("Manex", 800, 600);


    }
}