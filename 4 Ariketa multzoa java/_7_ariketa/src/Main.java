import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu esaldi bat:");
        String esaldia = sc.nextLine();
        System.out.println("Sartu hitz bat:");
        String hitz = sc.nextLine();
        sc.close();


        ArrayList<String> list = new ArrayList<>(Arrays.asList(esaldia.split(" ")));
        int i = 0;
        int D = 0;
        for (int l = list.size() - 1;l >= 0;l--){

            if (list.get(i).equals(hitz)){
                D = 1;
            }else {
            }
            i = i+1;

        }

        if (D == 1){
            System.out.println("Esaldian sartutako hitza dago");
        }else{
            System.out.println("Esaldian ez dago sartutako hitza");

        }
        //inprimatu listan dauden hitz guztiak
        //System.out.println(list);

    }
}