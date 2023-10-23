import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean egia = true;
        while (egia){


            System.out.println("Aukeratu eragiketa bat, sartu 0 programa amaitzeko.:");
            System.out.println("1.Batuketa       2.Kenketa");
            System.out.println("3.Biderketa      4.Zatiketa");
            System.out.println("5.Berreketa      6.Hondarra");
            int kasua = sc.nextInt();

            if (kasua == 0){
                System.out.println("Programa amaitu da");
                egia = false;
                System.exit(0);
            }
            if (kasua >= 7 || kasua < 0){
                System.out.println("Sartu duzun aukera ez da egokia.");
                System.exit(0);
            }

            System.out.println("Sartu lehen zenbakia (hamartarra izan daiteke):");
            double z1 = sc.nextDouble();
            System.out.println("Sartu bigarren zenbakia (hamartarra izan daiteke):");
            double z2 = sc.nextDouble();


            double guztira = menu(kasua, z1, z2);

            if (kasua == 6 || kasua == 4){

            }else {
                System.out.println("Eragiketaren emaitza "+guztira+" da.");
            }

        }




        sc.close();




    }


    public static double menu (int kasua, double z1, double z2){



        double guztira = 0;

        switch (kasua){

            case 1:
                guztira = batuketa(z1,z2);
                break;

            case 2:
                guztira = kenketa(z1,z2);

                break;


            case 3:
                guztira = biderketa(z1,z2);

                break;


            case 4:

                guztira = zatiketa(z1,z2);

                break;

            case 5:
                guztira = pow(z1,z2);

                break;
            case 6:
                guztira = hondarra(z1,z2);

                break;

        }
        return  guztira;

    }
    public static double batuketa (double z1, double z2){

        double guztira;

        guztira = z1 + z2;

        return guztira;
    }

    public static double kenketa (double z1, double z2){

        double guztira;

        guztira = z1 - z2;

        return guztira;
    }

    public static double biderketa (double z1, double z2){

        double guztira;

        guztira = z1 * z2;

        return guztira;
    }

    public static double zatiketa (double z1, double z2){

        double guztira;

        if (z1 ==0 || z2 == 0){
            System.out.println("Errorea: Ezin da zati 0 egin");
            z1 = 1;
            z2 = 1;
            return 0;
        }

        guztira = z1 / z2;

        return guztira;
    }

    public static double pow (double z1, double z2){

        double guztira;

        guztira = Math.pow(z1, z2);

        return guztira;
    }

    public static double hondarra (double z1, double z2){

        double guztira;

        if (z1 ==0 || z2 == 0){
            System.out.println("Errorea: Ezin da zati 0 egin");
            z1 = 1;
            z2 = 1;
            return 0;
        }

        guztira = z1 % z2;

        return guztira;
    }


}