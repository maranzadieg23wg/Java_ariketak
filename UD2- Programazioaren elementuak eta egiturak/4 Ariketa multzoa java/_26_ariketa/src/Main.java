import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        int aleatorio = (int)(Math.random() * 100);
        if (aleatorio == 0){
            aleatorio = 100;
        }
        int asmatu = 0;

        int saiakera = 0;

       // System.out.println(aleatorio);
        Scanner sc = new Scanner(System.in);
        System.out.println("1 eta 100 arteko zenbaki ezkutua asmatu:");

        while (asmatu == 0){
            int zenbakia = sc.nextInt();

            if (zenbakia < 1 || zenbakia > 100){
                System.out.println("Sartutako zenbakia ez da 1 eta 100 tartean.");
                zenbakia = 100;
            }

            if (zenbakia != aleatorio){

                if (saiakera > 8){
                    System.out.println("Ez duzu zenbakia asmatzea lortu, saiatu berrir, zenbakia zen "+aleatorio);
                    System.exit(0);
                }
                if (zenbakia < aleatorio){
                    System.out.println("Ez duzu asmatu, zenbaki ezktua handiagoa da.");
                    saiakera++;
                }else {
                    System.out.println("Ez duzu asmatu, zenbaki ezktua txikiagoa da.");
                    saiakera++;
                }

            }else {
                asmatu = 1;
                saiakera++;

                if (saiakera <3){
                    System.out.println("Asmatu duzu, zorte onekoa zara, ezta?");
                } else if (saiakera<5) {
                    System.out.println("Asmatu duzu, benetan azkarra zara!");
                } else if (saiakera <7) {
                    System.out.println("Asmatu duzu, nahiko ondo moldatu zara.");
                } else if (saiakera <9) {
                    System.out.println("Asmatu duzu, kostata ala?");
                } else if (saiakera <11){
                    System.out.println("Asmatu duzu, baina hurrengorako laguntzarik behar al duzu?");

                }else if (saiakera >10){
                    System.out.println("Ez duzu zenbakia asmatzea lortu, saiatu berrir, zenbakia zen "+aleatorio);
                    System.exit(0);
                }

            }


        }

        sc.close();



    }
}