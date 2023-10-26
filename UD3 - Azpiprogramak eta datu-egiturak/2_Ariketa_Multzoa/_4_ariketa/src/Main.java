import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu hamar ikasleen izenak:");

        String [] izenak = new String[10];

        for (int i = 0;i<10;i++){
            String izena = sc.nextLine();
            izenak [i] = izena;

        }

        System.out.println("Sartu hamar nota (zenbaki hamartarrak):");

        float [] notak = new float[10];

        for (int i = 0;i<10;i++){
            float nota = sc.nextFloat();
            notak [i] = nota;

        }

        for (int i = 0;i<10;i++){
            String letra = kalifikazioa(notak[i]);
            System.out.println("Ikaslea: "+izenak[i]+" - Nota: "+notak[i]+" - Kalifikazioa: "+ letra);
        }

        sc.close();


    }

    public static String kalifikazioa (float z1){
        if (z1 < 5) {
            return "D";
        } else if (z1 < 7) {
            return "C";
        } else if (z1 < 9) {
            return "B";
        } else {
            return "A";
        }

    }
}