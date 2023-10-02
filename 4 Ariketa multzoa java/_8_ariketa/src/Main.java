import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu lau zifretako zenbaki bat:");
        String zenbakia = sc.nextLine();
        sc.close();

        int total = 0;

        int zenbat = zenbakia.length();
        int[] lista = new int[4];
        if (zenbat == 4) {
            for (int i = 0; i < 4; i++){
                int V_X = Character.getNumericValue(zenbakia.charAt(i));
                lista[i] = V_X;
                total = total + lista[i];
            }
            System.out.println(zenbakia+" zenbakiaren zifren batura "+total+" da");
        } else {
            System.out.println("Sartutako zenbakiak ez ditu lau zifra");
        }

    }
}