import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] kopia = new int[10];



        System.out.println("Sartu 9 zenbaki oso 10 elementuko array batean:");

        for (int i = 0;i<zenbakiak.length;i++){
            int zenb = sc.nextInt();
            if (zenb<0 || zenb > 20){

            }
            zenbakiak [i] = zenb;
        }

        System.out.println("1etik 20 arteko zenbaki ausazkoen array-a:");
        for (int i = 0;i< zenbakiak.length;i++){
            if (i < zenbakiak.length-1){
                System.out.print(zenbakiak[i]+" - ");
            }else {
                System.out.println(zenbakiak[i]);

            }
        }

        for (int e = 0; e < zenbakiak.length-1; e++) {
            kopia[e+1] = zenbakiak[e];
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
