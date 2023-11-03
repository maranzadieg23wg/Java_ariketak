import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] kopia = new int[10];





        System.out.println("Bete array bat 10 zenbaki osoekin: ");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;

        }
        int k = 0;

        for (int i =0;i< zenbakiak.length;i++){
            if (zenbakiak[i]==0){
                kopia[k]=zenbakiak[i];
                k++;
            }
        }

        for (int i =0;i< zenbakiak.length;i++){
            if (zenbakiak[i]%2!=0 && zenbakiak[i]!=0) {
                kopia[k]=zenbakiak[i];
                k++;
            }
        }

        for (int i =0;i< zenbakiak.length;i++){
            if (zenbakiak[i]%2==0 && zenbakiak[i]!=0){
                kopia[k]=zenbakiak[i];
                k++;
            }
        }







        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< kopia.length;i++){

            if (i < kopia.length-1){
                System.out.print(kopia[i]+" - ");
            }else {
                System.out.print(kopia[i]);

            }

        }



        sc.close();

    }
}
