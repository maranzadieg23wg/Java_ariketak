import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int zenbat = 1;
        int[] monasterio = new int[5];

        int e = 0;

        while (zenbat != 0) {
            System.out.println("***********************");
            System.out.print("Monasterio kantitatea: ");
            zenbat = sc.nextInt();
            System.out.println("***********************");

            int monasterioak = 0;





            int[] mendiak = new int[zenbat + 1];

            for (int i = 0; i < zenbat; i++) {

                System.out.print("Mendiaren altura: ");
                mendiak[i] = sc.nextInt();




            }

            for (int i = 0;i<zenbat;i++){
                if (mendiak[i] > mendiak[i + 1]) {
                    monasterioak++;
                }
            }

            monasterio[e]=monasterioak;
            e++;

        }

        for (int i = 0;i<e-1;i++){
            System.out.print("Monasterio kantitatea: ");
            System.out.println(monasterio[i]);
        }

    }
}