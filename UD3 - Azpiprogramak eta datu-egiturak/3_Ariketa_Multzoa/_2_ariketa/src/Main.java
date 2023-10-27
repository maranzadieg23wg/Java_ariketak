import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int [] zenbakiak = new int[10];

        System.out.println("Sartu hamar zenbaki oso:");

        for (int i = 0;i<10;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
        }

        System.out.println("Eskatutako emaitza: ");

       // System.out.print(" - "+zenbakiak[0]);
        for (int i = 0;i<5;i++){
            System.out.print(zenbakiak[i]);
            if (i <4){
                System.out.print(" - "+zenbakiak[9-i]+" - ");
            }else {
                System.out.print(" - "+zenbakiak[9-i]);

            }
        }





        sc.close();

    }
}