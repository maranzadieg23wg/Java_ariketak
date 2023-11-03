import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] zenbakiak2 = new int[10];
        int [] zenbakiak3 = new int[20];





        System.out.println("Bete array bat goraka ordenatutako 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;

        }

        System.out.println("Bete beste array bat goraka ordenatutako 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak2 [i] = zenb;

        }

        //Bi arrayak batzen
        for (int i = 0;i<10;i++){
            zenbakiak3 [i] = zenbakiak[i];
            zenbakiak3[i+10]=zenbakiak2[i];
        }



        Arrays.sort(zenbakiak3);



        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< zenbakiak3.length;i++){
            if (i < zenbakiak3.length-1){
                System.out.print(zenbakiak3[i]+" - ");
            }else {
                System.out.print(zenbakiak3[i]);

            }
        }



        sc.close();

    }
}
