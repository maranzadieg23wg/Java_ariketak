import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] zenbakiak2 = new int[10];





        System.out.println("Bete array bat 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
        }


        zenbakiak2 [0]=zenbakiak[0];
        for (int i = 1;i<zenbakiak.length;i++){
            zenbakiak2[i] = zenbakiak2[i-1] + zenbakiak[i];
        }





        System.out.println("Hau da hasierako array-a:");
        for (int i = 0;i< zenbakiak.length;i++){
            if (i < zenbakiak.length-1){
                System.out.print(zenbakiak[i]+" - ");
            }else {
                System.out.print(zenbakiak[i]);

            }
        }

        System.out.println(" ");

        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< zenbakiak2.length;i++){
            if (i < zenbakiak2.length-1){
                System.out.print(zenbakiak2[i]+" - ");
            }else {
                System.out.print(zenbakiak2[i]);

            }
        }



        sc.close();

    }
}
