import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] kopia = new int[10];




        //System.out.println("Sartu 9 zenbaki oso 10 elementuko array batean:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = (int)(Math.random()*20+1);
            zenbakiak [i] = zenb;
            kopia [i] =zenb;
        }

        System.out.println("1etik 20 arteko zenbaki ausazkoen array-a:");
        for (int i = 0;i< zenbakiak.length;i++){
            if (i < zenbakiak.length-1){
                System.out.print(zenbakiak[i]+" - ");
            }else {
                System.out.println(zenbakiak[i]);

            }
        }
        System.out.println("Hau da bukaerako array-a");
        int zenbat = sc.nextInt();
        zenbat--;

       //int azkena = 0;

        //zenbakiak mugitu eskubira
        for (int i = 0;i<zenbat+1;i++){
            for (int e = 0; e < zenbakiak.length-1; e++) {
               //System.out.print("AZKENA: "+azkena+" - ");

                //lehenengo zenbakia
                kopia[0]=kopia[zenbakiak.length-1];

                //Beste zenbakiak jartzen ditu.
                kopia[e+1] = zenbakiak[e];
            }

            for (int e = 0; e < zenbakiak.length-1; e++) {
                zenbakiak[e]=kopia[e];
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
