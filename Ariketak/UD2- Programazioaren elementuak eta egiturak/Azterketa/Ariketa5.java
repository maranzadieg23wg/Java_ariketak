import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Idatzi 25 eta 75 tartean dauden bi zenbaki: ");
        System.out.println("Lehenengo zenbakia:");
        double  zenbakia = sc.nextFloat();
        System.out.println("Bigarren zenbakia:");
        double  zenbakia1 = sc.nextFloat();


        double  z1 = 0;
        double  z2 = 0;
        double  z3 = 0;
        double  z4 = 0;
        double  z5 = 0;
        double  z6 = 0;

        z1 = zenbakia/10;
        z3 = zenbakia1/10;

        z2 = z1;
        z4 = z3;

        z5 = z2;
        z6 = z4;

        z5 = Math.floor(z5);
        z6 = Math.floor(z6);

        //.out.println("z5: "+z5);

        if (z2 > z5){
            z2 = z2 - z5;
        }else {
            z2 = z5 - z2;
        }

        if (z4 > z6){
            z4 = z4 - z6;
        }else {
            z4 = z6 - z4;
        }


        z2 = z2 *10;
        z4 = z4 *10;

        z2 = Math.floor(z2);
        z4 = Math.floor(z4);


        z1=Math.floor(z1);
        z3=Math.floor(z3);





        System.out.println(z1+" "+z2+" "+z3+" "+z4);

        if (z1 == z2 || z1 == z3 || z1 == z4 || z2 == z3|| z2 == z4 || z3 == z4){
            System.out.println("Sartutako zenbakien digituren bat berbera da.");
        }else {
            System.out.println("Sartutako zenbakien digituak guztiak desberdina dira.");
        }





        sc.close();

    }
}