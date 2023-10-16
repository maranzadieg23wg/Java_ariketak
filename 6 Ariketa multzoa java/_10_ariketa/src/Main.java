import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();



        for (int i = 1;i<zenbat+1;i++){


            for (int r =zenbat;r > i;r--){
                System.out.print("  ");
            }


            for (int e = 1;e < i*2;e++){
                System.out.print("*");
                System.out.print(" ");

            }
            System.out.println("");

        }
        //alderantziz
        for (int i = 1;i<zenbat+1;i++){


            for (int r =zenbat;r < i;r--){
                System.out.print("  t");
            }


            for (int e = zenbat;e > i/2;e--){
                System.out.print("*");
                System.out.print(" ");

            }
            System.out.println("");

        }

    }
}