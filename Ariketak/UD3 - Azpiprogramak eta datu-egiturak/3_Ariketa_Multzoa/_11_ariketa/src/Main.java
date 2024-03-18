import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];





        System.out.println("Bete array bat 10 zenbaki osoekin: ");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;

        }


        System.out.println("Adierazi ezabatu nahi duzun elementuaren indizea:");
        int borratu = sc.nextInt();





        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< zenbakiak.length;i++){
            if (borratu != i){
                if (i < zenbakiak.length-1){
                    System.out.print(zenbakiak[i]+" - ");
                }else {
                    System.out.print(zenbakiak[i]);

                }
            }

        }



        sc.close();

    }
}
