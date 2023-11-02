import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak1 = new int[10];
        int [] zenbakiak2 = new int[10];
        int [] zenbakiak3 = new int[20];

        System.out.println("Bete lehen array-a hamar zenbaki osoekin:");

        for (int i = 0;i<10;i++){
            int zenb = sc.nextInt();
            zenbakiak1 [i] = zenb;
        }

        System.out.println("Bete bigarren array-a hamar zenbaki osoekin:");

        for (int i = 0;i<10;i++){
            int zenb = sc.nextInt();
            zenbakiak2 [i] = zenb;
        }

        System.out.println("Eskatutako emaitza: ");

        for (int i = 0;i<10;i++){
            zenbakiak3 [i] = zenbakiak1[i];
            zenbakiak3[i+10]=zenbakiak2[i];
        }
        boolean zen1 = true;
        int e = 0;
        int a = 0;
        for (int i = 0;i<20;i++){

            if (zen1){
                if (i <19){
                    System.out.print(zenbakiak3[a]+" - ");
                }else {
                    System.out.print(zenbakiak3[a]);
                }
                zen1 = false;
                a++;
            }else {
                if (i <19){
                    System.out.print(zenbakiak3[e+10]+" - ");
                }else {
                    System.out.print(zenbakiak3[e+10]);
                }
                zen1 = true;
                e++;
            }

        }

        sc.close();

    }
}
