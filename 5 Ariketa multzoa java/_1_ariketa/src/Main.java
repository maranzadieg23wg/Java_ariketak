import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int max;
        int min;
        int batazbestekoa = 0;
        int zortzi =0;
        int notaBajuena =10;
        int notaBajuenaKodea =0;

        int ikaslekopurua = 10;

        for (int i = 0;i<ikaslekopurua;i++){
           // System.out.println("Sartu Ikaslearen kodea:");
            int kodea = sc.nextInt();


           // System.out.println("Sartu Ikaslearen nota:");
            int nota1 = sc.nextInt();
           // System.out.println("Sartu Ikaslearen nota:");
            int nota2 = sc.nextInt();
           // System.out.println("Sartu Ikaslearen nota:");
            int nota3 = sc.nextInt();
          //  System.out.println("Sartu Ikaslearen nota:");
            int nota4 = sc.nextInt();
          //  System.out.println("Sartu Ikaslearen nota:");
            int nota5 = sc.nextInt();

            if (kodea <0||nota1<0||nota2<0||nota3<0||nota4<0||nota5<0){
                System.out.println("ERROR: zenbaki bat sartu duzuna negatiboa da");
                System.exit(0);
            }
            if (nota1 > 10||nota2 > 10||nota3 > 10||nota4 > 10||nota5 > 10){
                System.out.println("Sartu duzun notaren bat 10 baino handiagoa da.");
                System.exit(0);
            }


            byte max_min;

            max_min = 0;

            max = max(nota1, nota2, nota3, nota4, nota5, max_min);
            max_min =1;
            min = max(nota1, nota2, nota3, nota4, nota5, max_min);
            System.out.println("Kodea: "+kodea+" Min: "+min+" Max: "+max);

            batazbestekoa = batazbestekoa + nota1;
            if (nota1 > 8 ||nota2 > 8 ||nota3 > 8 ||nota4 > 8 ||nota5 > 8){
                zortzi = zortzi+1;
            }

            if (min < notaBajuena){
                notaBajuenaKodea = kodea;
                notaBajuena = min;
            }


        }
        sc.close();

        batazbestekoa = batazbestekoa*ikaslekopurua/100;
        System.out.println("Batazbestekoa: "+batazbestekoa);

        System.out.println("8 baino gehiago atera dutenek: "+zortzi);

        System.out.println("Nota bajuena kodea: "+notaBajuenaKodea+" nota bajuena: "+notaBajuena);

    }

    public static int max (int z1, int z2, int z3, int z4, int z5, byte max_min){
        int sobrak = 0;

        if (z1 < z2) {
            sobrak = z1; z1 = z2; z2 = sobrak;
        }
        if (z2 < z3) {
            sobrak = z2; z2 = z3; z3 = sobrak;
        }
        if (z3 < z4) {
            sobrak = z3; z3 = z4; z4 = sobrak;
        }
        if (z4 < z5) {
            sobrak = z4; z4 = z5; z5 = sobrak;
        }
        if (z1 < z2) {
            sobrak = z1; z1 = z2; z2 = sobrak;
        }
        if (z2 < z3) {
            sobrak = z2; z2 = z3; z3 = sobrak;
        }
        if (z3 < z4) {
            sobrak = z3; z3 = z4; z4 = sobrak;
        }
        if (z1 < z2) {
            sobrak = z1; z1 = z2; z2 = sobrak;
        }
        if (z2 < z3) {
            sobrak = z2; z2 = z3; z3 = sobrak;
        }
        if (z1 < z2) {
            sobrak = z1; z1 = z2; z2 = sobrak;
        }

        if (max_min == 0){
            return z1;

        }else {
            return z5;

        }


    }

}