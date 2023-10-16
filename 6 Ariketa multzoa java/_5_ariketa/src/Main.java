import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();




        for (int i = 0;i<zenbat+1;i++){


            for (int e = 1;e < i +1;e++){
                System.out.print("*");

            }
            System.out.println("");

        }
        for (int i = 0;i<zenbat+1;i++){


            for (int e =zenbat;e > i +1;e--){
                System.out.print("*");

            }
            System.out.println("");

        }


    }
}