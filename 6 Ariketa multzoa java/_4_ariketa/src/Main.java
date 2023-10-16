import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();

        boolean egia = true;
        for (int i = 0;i<zenbat+1;i++){


            for (int e = 1;e < i +1;e++){
                if (egia == true){
                    System.out.print(1);
                    egia = false;
                } else if (egia == false) {
                    System.out.print(0);
                    egia = true;
                }

            }
            System.out.println("");

        }
    }
}