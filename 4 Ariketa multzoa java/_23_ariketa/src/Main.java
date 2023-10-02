import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu Fibonacci segidaren zenbaki kopurua;:");
        double zenbat = sc.nextDouble();
        sc.close();

        if (zenbat < 0){
            System.out.println("Errorea: Sarrerako zenbakia positiboa izan behar da.");
            System.exit(0);
        }


        System.out.println("Hau da Fibonacci segida:");
        int a = 1;
        int b = 0;
        int fibonacci = 0;

        for (int i = 0;i < zenbat;i++){

            fibonacci = a +b;



            System.out.println(fibonacci);
            a = b;
            b = fibonacci;






        }

    }
}