import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[10];
        int [] kopia = new int[10];



        System.out.println("Sartu 9 zenbaki oso 10 elementuko array batean:");

        for (int i = 0;i<zenbakiak.length-1;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
        }
        System.out.println("Sartu txertatu behar den beste zenbaki oso bat:");
        int zenb = sc.nextInt();

        System.out.println("Sartu zenbakia txertatu nahi duzun posizioa (0-9):");
        int posizioa = sc.nextInt();

        for (int i = 0; i<zenbakiak.length;i++){
           if (i == posizioa){
               kopia[i]=zenb;
               kopia[i+1] =zenbakiak[i];
           }else {
               kopia[i] = zenbakiak[i];
           }
        }


        System.out.print(kopia[0]);

        for (int i = 1;i< kopia.length;i++){
            if (i < kopia.length/2-1){
                System.out.print(" - "+kopia[i]+" - ");
            }else {
                System.out.print(" - "+kopia[i]);

            }
        }



        sc.close();

    }
}
