import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int [] zenbakiak1 = new int[10];
        int [] zenbakiak2 = new int[10];


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

        // System.out.print(" - "+zenbakiak[0]);
        for (int i = 0;i<10;i++){
            System.out.print(zenbakiak1[i]);
            if (i <9){
                System.out.print(" - "+zenbakiak2[i]+" - ");
            }else {
                System.out.print(" - "+zenbakiak2[i]);
            }
        }





        sc.close();

    }
}