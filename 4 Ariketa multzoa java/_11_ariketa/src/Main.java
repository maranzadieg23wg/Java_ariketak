import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Sartu produkto koputu bat");
        int zenbat = sc.nextInt();
        System.out.println("Sartu produktoaren prezioa");
        float prezioa = sc.nextFloat();
        sc.close();

        if (prezioa <0 || zenbat <0){
            System.out.println("Kopurua edo prezioa ezin dira negatiboak izan");
            System.exit(0);
        }

        float guztira = 0;
        int deskontua = 0;

        float numero = prezioa;
        BigDecimal bd = new BigDecimal(Float.toString(numero));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        prezioa = bd.floatValue();

        if (zenbat > 10){
            int aleatorio = (int)(Math.random() * 101);
            //System.out.println(aleatorio);
            if (aleatorio <25){
                //descuento del 20%
                System.out.println("%20ko deskontua duzu");
                deskontua = 20;
            }else {
                //descuento del 10%
                System.out.println("%10ko deskontua duzu!");
                deskontua = 10;
            }

        }else {
            System.out.println("Ez duzu deskonturik");
            //sin descuento
            deskontua = 0;
        }

        guztira = zenbat * prezioa;
        guztira = guztira - (deskontua*guztira/100);

        System.out.println("Ordaindu beharrekoa "+guztira+"€ dira.");

    }
}