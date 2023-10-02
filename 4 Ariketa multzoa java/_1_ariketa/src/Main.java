import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                System.out.println("Sartu zure izena");
                String izena = sc.nextLine();
                System.out.println("Sartu zure adina");
                int adina = sc.nextShort();
                sc.close();

                System.out.println("Kaixo " + izena + "," + adina + " urte dituzu");
    }
}