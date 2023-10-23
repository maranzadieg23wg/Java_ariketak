import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu data bat uuuu hh ee formatuan:");
        String ordua1 = sc.nextLine();
        sc.close();

        String[] lista = {"Urtarrila", "Otsaila", "Martxoa", "Apirila", "Maiatza", "Ekaina", "Uztaila", "Abuztua", "Iraila", "Urria", "Azaroa", "Abendua"};

        String[] lista1 = ordua1.split(" ");

        int urtea = Integer.parseInt(lista1[0]);
        int hilabetea = Integer.parseInt(lista1[1]);
        int eguna = Integer.parseInt(lista1[2]);

        if (hilabetea >12 || hilabetea == 0){
            System.out.println("Errorea: Hilabete zenbakia ezin da 12 baino handiagoa izan edo 0 izan");
            System.exit(0);
        }
        if (hilabetea == 2 && eguna >28){
            System.out.println("Errorea: Otsailak 28 egun baino gehaigo ez ditu");
            System.exit(0);
        }
        if (hilabetea%2 != 0){
            if (eguna >30){
                System.out.println("Errorea: "+ lista[hilabetea-1]+" ez ditu 30 baino egun gehaigo.");
                System.exit(0);

            }
        }else {
            if (eguna > 31) {
                System.out.println("Errorea: " + lista[hilabetea - 1] + " ez ditu 30 baino egun gehaigo.");
                System.exit(0);


            }
        }

        System.out.println(urtea+"(e)ko "+lista[hilabetea-1]+" "+eguna);

    }
}