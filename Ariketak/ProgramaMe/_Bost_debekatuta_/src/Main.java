import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // https://aceptaelreto.com/problem/statement.php?id=652&cat=41

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int z1 = sc.nextInt();
        int z2 = sc.nextInt();
        sc.close();

        int z3 =0;

        z1 -= bost(z1);
        z2 -= bost(z2);

        z3 = z1*z2;

        z3 += bost(z3);



        System.out.println(z3);


    }
    public static int bost (int z1){

        int zenbat = 0;

        int zenbakia = 5;

        for (int i = zenbakia;i<z1;i += zenbakia){
            zenbat++;
            //System.out.println("zenbat: "+zenbat);
        }
        if (zenbat > 1){
            zenbat--;
        }

        return zenbat;

    }

}