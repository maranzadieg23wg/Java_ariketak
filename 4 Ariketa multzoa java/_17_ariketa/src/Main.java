import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu hasierako ditu kantitate bat:");
        float zenbakia1 = sc.nextFloat();
        System.out.println("Sartu hilero gehitzeko kantitate bat:");
        float zenbakia2 = sc.nextFloat();
        System.out.println("Sartu hilabete kopuru bat:");
        float zenbakia3 = sc.nextFloat();
        System.out.println("Sartu interes bat:");
        float zenbakia4 = sc.nextFloat();
        sc.close();

        double guztira = zenbakia1;

        if (zenbakia1 <0||zenbakia2<0||zenbakia3<0||zenbakia4<0){
            System.out.println("Errorea: Zenbakiak ezin dira negatikoab izan.");
            System.exit(0);
        }
        //guztira = guztira + zenbakia2;
        for (float i = 0;i < zenbakia3;i++){

            guztira = guztira + zenbakia2;
            guztira = zenbakia4 * guztira /100 + guztira;

        }


        guztira = Math.floor(guztira*100)/100;
        System.out.println("Amaierako diru kantitatea "+ guztira+"€ da.");

    }
}