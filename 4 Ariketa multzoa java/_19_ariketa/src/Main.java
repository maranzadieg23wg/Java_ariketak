import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        int aleatorio = (int)(Math.random() * 10);
        if (aleatorio == 0){
            aleatorio = 10;
        }
        int asmatu = 0;



        Scanner sc = new Scanner(System.in);
        System.out.println("1 eta 10 arteko zenbaki ezkutua asmatu:");

        while (asmatu == 0){
            int zenbakia = sc.nextInt();
            if (zenbakia != aleatorio){
                System.out.println("Ez duzu asmatu, saiatu berriro:");
            }else {
                System.out.println("Oso ondo, asmatu duzu! "+ aleatorio+" da zenbaki ezkutua");
                asmatu = 1;
            }


        }

        sc.close();



    }
}