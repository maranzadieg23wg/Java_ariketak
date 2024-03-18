import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] zenbakiak2 = new int[10];


        boolean aurkituta = false;



        System.out.println("Bete array bat goraka ordenatutako 10 zenbaki osoekin:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
            zenbakiak2 [i]=zenb;

        }

        Arrays.sort(zenbakiak2);


        for (int i =0;i<zenbakiak.length;i++){
            if (zenbakiak[i]!=zenbakiak2[i]){
                System.out.println("ERROR: Sartutako zenbakiak ez daude ordenatuta, berriro sartu zenbakiak:");
                //main (null);
                zenbakiak[i]= 0;
            }
        }

        System.out.println("Sartu array-an dagoen zenbaki bat:");
        int zenbaki = sc.nextInt();

        for (int i =0;i<zenbakiak.length;i++){
            if (zenbaki == zenbakiak[i]){
                System.out.println("Sartutako zenbakiaren posizioa "+i+" da.");
                aurkituta = true;
            }
        }

        if (!aurkituta){
            System.out.println("Sartu duzun zebakia ez dago array-an.");
        }







        /*
        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< zenbakiak3.length;i++){
            if (i < zenbakiak3.length-1){
                System.out.print(zenbakiak3[i]+" - ");
            }else {
                System.out.print(zenbakiak3[i]);

            }
        }
        */


        sc.close();

    }
}
