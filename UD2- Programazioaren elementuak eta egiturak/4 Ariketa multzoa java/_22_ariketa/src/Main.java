import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zatikizuna:");
        double zatikizuna = sc.nextDouble();
        System.out.println("Sartu zatitzailea:");
        double zatitzailea = sc.nextDouble();
        sc.close();

        int b = 0;
        int c = 0;

        if (zatikizuna <0 && zatitzailea < 0){
            zatikizuna= zatikizuna * -1;
            b = 1;
            zatitzailea = zatitzailea * -1;
            c = 1;
        }
        else if (zatikizuna <0){
            zatikizuna= zatikizuna * -1;
            b = 1;
        } else if (zatitzailea < 0) {
            zatitzailea = zatitzailea * -1;
            c = 1;
            //System.out.println(zatitzailea);
        }

        byte egia = 0;

        double a = zatitzailea;
        double hondarra = 0;
        int zenbat = 0;

        if (zatitzailea == 0){
            System.out.println("Errorea: zatitzailea ezin da 0 izan.");
            System.exit(0);
        }


        while (egia ==0){
            if (a >= zatikizuna){
                egia =1;
                // si supera o es igual al zatikizuna
                if (a == zatikizuna){
                    hondarra = 0;
                    zenbat++;
                }else {
                    hondarra = a -zatitzailea;
                    hondarra = zatikizuna - hondarra;

                }
            } else{
                a = a+zatitzailea;
               // System.out.println(a);
                zenbat++;
            }
        }

        if (b == 1 && c == 1){
            hondarra = hondarra * -1;
        }
        else if (b == 1){
            zenbat = zenbat * -1;
            hondarra = hondarra * -1;
        } else if (c == 1) {
            zenbat = zenbat * -1;
        }

        System.out.println("Zatidura "+zenbat+" da eta hondarra "+ hondarra+" da.");

    }
}