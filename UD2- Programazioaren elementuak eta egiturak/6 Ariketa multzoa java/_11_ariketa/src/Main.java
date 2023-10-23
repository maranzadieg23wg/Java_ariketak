import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();


        for (int i = 0;i<zenbat;i++){
            System.out.print("*");
            System.out.print(" ");
        }

        System.out.println("");

        for (int i = 0;i<zenbat-2;i++){
            System.out.print("*");

            for (int e = 0;e<zenbat-1;e++){

                if (e == zenbat-2){
                    System.out.print(" ");

                }else {
                    System.out.print("  ");

                }


            }
            System.out.print("*");
            System.out.println("");

        }


        for (int i = 0;i<zenbat;i++){
            System.out.print("*");
            System.out.print(" ");
        }

    }
}