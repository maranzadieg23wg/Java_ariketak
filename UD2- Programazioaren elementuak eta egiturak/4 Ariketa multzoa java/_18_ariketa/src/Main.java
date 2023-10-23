import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int egia = 1;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        while (egia == 1) {
            System.out.println("Sartu beste hitz bat, bukatu $ karaketerea sartuz;");
            String hitza = sc.nextLine();

            int kantitatea = hitza.length();
            lista.add(kantitatea);

            if (hitza.equals("$")){
                egia = 0;
            }
        }

        sc.close();
        lista.remove(lista.size()-1);

        //System.out.println(lista.toString());
        float guztira = 0;
        for (int i = 0;i < lista.size();i++){
            guztira = guztira + lista.get(i);
        }

        guztira = guztira / lista.size();

        if (lista.size()==0){
            System.out.println("Sartutako hitzen batezbesteko letren kopurua 0 da.");

        }else {
            System.out.println("Sartutako hitzen batezbesteko letren kopurua "+guztira+" da.");
        }

    }
}