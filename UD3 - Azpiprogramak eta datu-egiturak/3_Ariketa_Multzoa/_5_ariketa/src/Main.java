import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];

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
        }

        for (int i =1;i<zenbakiak.length;i++) {
            if (zenbakiak[i] > zenbakiak[i - 1]) {
                ordenatuta = true;
            }
            if (zenbakiak[i] < zenbakiak[i - 1]) {
                alderantziz = true;
            }
            if (zenbakiak[i] == zenbakiak[0]) {
                berdinak = true;
            }


        }
        if (ordenatuta) {
            System.out.println("Array-a goraka ordenatuta dago.");
        } else if (alderantziz) {
            System.out.println("Array-a beheraka ordenatuta dago");
        } else if (berdinak){
            System.out.println("Zenbaki guztiak berdina dira, ezin da esan ordenaturik dagoen.");
        } else {
            System.out.println("Array-a desordenatuta dago.");
        }

        sc.close();

    }
}
