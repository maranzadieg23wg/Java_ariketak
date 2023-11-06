import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] zenbakiak2 = new int[10];
        int [] zenbakiak3 = new int[20];

        int temp = 0;






        System.out.println("Bete array bat goraka ordenatutako 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            if (i !=0){
                if (zenb < zenbakiak[i-1]){
                    System.out.println("ERROR: sartutako zenbakiak ez daude ordenatuta");
                    zenb = 0;
                }
            }
            zenbakiak [i] = zenb;



        }

        System.out.println("Bete beste array bat goraka ordenatutako 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            if (i !=0){
                if (zenb < zenbakiak2[i-1]){
                    System.out.println("ERROR: sartutako zenbakiak ez daude ordenatuta");
                    zenb = 0;
                }
            }
            zenbakiak2 [i] = zenb;

        }





        //zenbakiak arraya kopiatzen zenbakiak 3 arrayra
        for (int i = 0;i<zenbakiak3.length/2;i++){

            zenbakiak3 [i] = zenbakiak[i];
            zenbakiak3[i+10]=zenbakiak2[i];

        }


        //zenbakiak ordenatu
        for (int i =0;i< zenbakiak3.length;i++){
            for (int e = 1; e < zenbakiak3.length - i; e++) {

                if (zenbakiak3[e-1]>zenbakiak3[e]){
                    temp =zenbakiak3[e-1];
                    zenbakiak3[e-1]=zenbakiak3[e];
                    zenbakiak3[e]=temp;
                }

            }

        }





        //Arrays.sort(zenbakiak3);



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
