import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

int bataz =0;
int max = 0;
        Scanner sc= new Scanner(System.in);
        System.out.println("1. kalkulatu batazbeztekoa");
        System.out.println();
        System.out.println("2. Kalkulatu maximoa: ");
        int zenb = sc.nextInt();
       switch (zenb){
           case 1: {
               System.out.println("Zenbat zenbaki sartu nahi dituzu?");
               int zenbkop = sc.nextInt();
               for (int i=1; i<=zenbkop; i++){

                   System.out.println("Sartu "+ i + ". zenbakia:");
                   int zenb1 = sc.nextInt();
                   bataz = bataz + zenb1;
               }
               System.out.println(" Sartutako zenbakien bataz beztekoa "+ bataz/zenbkop + " da.");
           }
           case 2: {
               System.out.println("Zenbat zenbaki sartu nahi dituzu?");
               int zenbkop = sc.nextInt();
               for (int j= 1; j<=zenbkop; j++){
                   System.out.println("Sartu "+ j + ". zenbakia: ");
                   int zenb2 = sc.nextInt();
                   if (zenb2> max);
                   max = zenb2;

               }



           }

           case 0: {

               System.out.println("");


           }
sc.close();
       }
    }
}