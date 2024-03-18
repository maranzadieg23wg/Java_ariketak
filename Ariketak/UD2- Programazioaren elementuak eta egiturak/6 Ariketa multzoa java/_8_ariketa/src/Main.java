import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();

        int zenbakia = 0;

        for (int i = 0;i<zenbat+1;i++){


            for (int r =zenbat;r > i;r--){
                System.out.print("\t");
            }


            for (int e = 1;e < i +1;e++){
                zenbakia++;
                System.out.print(zenbakia);
                System.out.print("\t \t");

            }
            System.out.println("");

        }


    }
}