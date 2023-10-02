import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zembaki oso luze bat:");
        String zenbakia = sc.nextLine();
        sc.close();

        int total = 0;

        int zenbat = zenbakia.length();
        int[] lista = new int[zenbakia.length()];

        for (int i = 0; i < zenbakia.length(); i++){
            int V_X = Character.getNumericValue(zenbakia.charAt(i));
            lista[i] = V_X;
            total = total + lista[i];

        }
        System.out.println(zenbakia+" zenbakiaren zifren batura "+total+" da");

    }

}
