import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu NAN zenbaki bat:");
        int zenbakia = sc.nextInt();
        sc.close();

        int guztira = String.valueOf(zenbakia).length();

        if (guztira !=8){
            System.out.println("NAN zenbakiak 8 zifra behar ditu");
            System.exit(0);
        }


        String[] list = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int letra = zenbakia %23;

        System.out.println("NAN zenbakiaren letra "+list[letra]+" da");
        System.out.println("Zure NANa da "+zenbakia+list[letra]);

    }
}