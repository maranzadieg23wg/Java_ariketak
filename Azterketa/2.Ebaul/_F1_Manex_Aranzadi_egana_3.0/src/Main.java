import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        HashMap<String, HashMap<Integer, Langile>> F1 = new HashMap<>();

        int z =0;

        while (z !=6){


            System.out.println("1: Erakutsi");
            System.out.println("2: Gehitu talde bat");
            System.out.println("3: Ezabatu talde bat");
            System.out.println("4: Gehitu langile bat");
            System.out.println("5: Aldatu langile bat talde batetik");
            System.out.println("6: Bukatu programa");

            z = sc.nextInt();

            switch (z){
                case 1:
                    erakutsi(F1);
                    break;
                case 2:
                    gehituTaldea(F1);
                    break;
                case 3:
                    borratuTaldea(F1);
                    break;
                case 4:
                    gehituLangile(F1);
                    break;
                case 5:

                    F1=aldatuLangile(F1);
                    break;
                default:
                    System.out.println("Sartutako zenbakiak ez du ezer egiten");
                    break;

            }

        }

    }



}