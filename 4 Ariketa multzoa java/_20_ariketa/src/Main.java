import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu berrekizuna:");
        double berrekizuna = sc.nextDouble();
        System.out.println("Sartu berretzailea:");
        double berretzailea = sc.nextDouble();
        sc.close();

        double guztira = berrekizuna;
        double a = 0;

        if (berretzailea < 0){
            a = berretzailea;
            berretzailea = berretzailea * -1;
        }


        for (int i = 0; i<berretzailea-1;i++){
            guztira = guztira * berrekizuna;
        }

        if (berretzailea == 0){
            guztira = 1;
        }

        if (a < 0){
            guztira = 1 / guztira;
        }


        System.out.println("Berreketaren emaitza "+guztira+" da");

    }
}