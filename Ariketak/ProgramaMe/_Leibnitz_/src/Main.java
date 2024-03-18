import java.util.Scanner;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        //double m = sc.nextDouble();
        sc.close();

        double guztira =1;
        byte egia = 0;
        double e = 1;

        //System.out.println("proba");
        for (int i=0;i<n;i++){
            e = e+2;
            //System.out.println(i);
            if (egia ==0){
                //System.out.println("egia "+guztira);
                guztira = guztira - 1/e;

                egia =1;
            } else{
                //System.out.println("egia "+guztira);
                guztira = guztira + 1/e;
                egia =0;
            }

            /*System.out.println(e);
            System.out.println(guztira);*/

        }
        //System.out.println(guztira);
        guztira = guztira *4;

        System.out.println(guztira);
    }
}