import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int egia = 1;
        float letraKantitatea = 0;
        float zenbat = 0;
        Scanner sc = new Scanner(System.in);

        while (egia == 1) {
            System.out.println("Sartu beste hitz bat, bukatu $ karaketerea sartuz;");
            String hitza = sc.nextLine();

            int kantitatea = hitza.length();
            letraKantitatea = letraKantitatea + kantitatea;

            if (hitza.equals("$")){
                egia = 0;
            }
            zenbat = zenbat +1;
        }

        sc.close();
        zenbat = zenbat -1;
        letraKantitatea = letraKantitatea -1;

        //System.out.println(lista.toString());
        float guztira = 0;

        //System.out.println("Letra kantitatea: "+letraKantitatea);
        //System.out.println("Zenbat letra: "+zenbat);

        guztira = letraKantitatea / zenbat;

        if (letraKantitatea==0){
            System.out.println("Sartutako hitzen batezbesteko letren kopurua 0 da.");

        }else {
            System.out.println("Sartutako hitzen batezbesteko letren kopurua "+guztira+" da.");
        }

    }
}