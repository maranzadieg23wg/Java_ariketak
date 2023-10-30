import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] kopia = new int[10];

        //ordenatuta
        boolean ordenatuta = false;
        //alderantziz
        boolean alderantziz = false;
        //berdinak
        boolean berdinak = false;
        //ez ordenatuta
        boolean ez_ordenatuta = false;

        System.out.println("Bete array bat 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
            kopia [i] = zenb;
        }

        for (int i =1;i<zenbakiak.length;i++) {
            if (zenbakiak[i] > zenbakiak[i - 1] && !alderantziz) {
                ordenatuta = true;



            }

            if (zenbakiak[i] < zenbakiak[i - 1] && !ordenatuta) {
                alderantziz = true;



            }
            if (zenbakiak[i] == zenbakiak[0]) {
                berdinak = true;
            }



        }
        Arrays.sort(kopia);
        for (int i =0;i<zenbakiak.length;i++) {
            if (zenbakiak[i] != kopia[i] && zenbakiak[i] != kopia[9-i]){
                ez_ordenatuta = true;
                i = zenbakiak.length;
            }
        }

        if (ez_ordenatuta){
            System.out.println("Array-a desordenatuta dago.");
        } else if (ordenatuta) {
            System.out.println("Array-a goraka ordenatuta dago.");
        } else if (alderantziz) {
            System.out.println("Array-a beheraka ordenatuta dago");
        } else if (berdinak){
            System.out.println("Zenbaki guztiak berdina dira, ezin da esan ordenaturik dagoen.");
        } else {
           System.out.println("ERROR");
        }

        sc.close();

    }
}
