import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int zenbat = 1;

        while (zenbat != 0) {
            System.out.println("***********************");
            System.out.print("Pertsona kantitatea: ");
            zenbat = sc.nextInt();
            System.out.println("***********************");




            String borratu=sc.nextLine();

            String komensal=sc.nextLine();

            boolean norbaitekEzDuJaten = false;



            if (komensal.length()>zenbat) {
                System.out.println("ERROR: Sartutako komensal kantitatea ez dator bat, sartu dituzun komensal kopuruarekin.");

            }else if (komensal.contains("D.I") || komensal.contains("I.D")){

                norbaitekEzDuJaten = false;

            }else {

                //letrak eskubira mugitzen ditu
                char[] stringtoChar = komensal.toCharArray();
                char[] kopia = komensal.toCharArray();

                int mugitu =2;
                if (zenbat>=3){
                    mugitu = 1;
                }
                //karaktereak eskubira mugitu
                for (int i = 0;i<mugitu;i++) {

                    for (int e = 0; e < stringtoChar.length - 1; e++) {
                        //System.out.print("AZKENA: "+azkena+" - ");

                        //lehenengo zenbakia
                        kopia[0] = kopia[stringtoChar.length - 1];

                        //Beste zenbakiak jartzen ditu.
                        kopia[e + 1] = stringtoChar[e];
                    }

                    for (int e = 0; e < stringtoChar.length - 1; e++) {
                        stringtoChar[e] = kopia[e];
                    }
                }

                String komensal2 = new String(kopia);

                if (komensal2.contains("D.I") || komensal2.contains("I.D")){

                    norbaitekEzDuJaten = false;

                }else{
                    norbaitekEzDuJaten = true;
                }


            }

            if (!norbaitekEzDuJaten){
                System.out.println("Norbaitek ez du jaten");
            }else {
                System.out.println("Guztiek jaten dute");
            }

        }



    }
}