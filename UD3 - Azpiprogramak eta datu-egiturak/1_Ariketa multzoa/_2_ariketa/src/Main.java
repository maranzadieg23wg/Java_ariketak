import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbakia = sc.nextInt();
        sc.close();

        System.out.println("1");

        int deskonposizioa = deskonposizioa(zenbakia,2);





    }

    public static boolean primo (int z1){
        boolean primo = false;

        for (int i = 2;i < z1; i++){
            if (z1 % i == 0){
                primo =false;
                break;
            }
        }

        return primo;

    }

    public static int deskonposizioa (int z1, int zPrimo){

        boolean primo = false;

        while (z1 != 1){
            if (z1 % zPrimo == 0){
                z1 = z1 / zPrimo;
                System.out.println(zPrimo);
                if (z1 == 1){
                    System.exit(1);
                }
            }
            else {
                zPrimo++;

                while (primo == false){
                    primo = primo(zPrimo);

                    deskonposizioa(z1, zPrimo);


                }

            }
        }
        return z1;
    }
}