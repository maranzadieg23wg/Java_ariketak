import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("Sartu 100 zenbaki 1 eta 100 tartekoak");

        int [] lista = new int[100];
        float guztira = 0;
        float batazbestekoa = 0;

        for (int i = 0;i<100;i++){
            int zenbakia = i +1;

           /* if (zenbakia < 1 || zenbakia > 100) {
                System.out.println("Sartu duzun zenbakia ez du balio, sartu behar duzu 1 eta 100 artean dagoen zenbaki bat");
                zenbakia = 1;
            }*/

            lista [i] = zenbakia;

        }

        for (int i = 0;i<100;i++){
            guztira += lista[i];
           // System.out.println(i+": "+lista[i]);
        }
        batazbestekoa = guztira/100;

        System.out.println("Elementu guztien batura "+guztira+" da eta batazbestekoa "+ batazbestekoa+" da.");

        sc.close();

    }


}