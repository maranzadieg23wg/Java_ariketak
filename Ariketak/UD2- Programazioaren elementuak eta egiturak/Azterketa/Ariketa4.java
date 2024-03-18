import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        System.out.println("1. Kalkulatu batazbestekoa ");
        System.out.println("2. Kalkulatu maximoa ");
        int zein = sc.nextInt();

        switch (zein){
            case (1):
                System.out.println("1");

                System.out.println("Sartu zenbat zenbakien batazbestekoa nahi den kalkulatu:");
                int zenbat = sc.nextInt();

                int batazbestekoa = 0;
                int batazbestekoa1 =0;
                for (int i = 0;i<zenbat;i++){
                    System.out.println("Sartu batazbestekoa kalkulatu nahi den zenbakia:");
                    batazbestekoa = sc.nextInt();
                    batazbestekoa1 += batazbestekoa;
                }
                batazbestekoa1 = batazbestekoa1/zenbat;

                System.out.println("Sartu duzun zenbakien batazbestekoa da: "+batazbestekoa1);


                break;

            case (2):

                System.out.println("Sartu zenbat zenbakien maximoa nahi den kalkulatu:");
                int zenbat1 = sc.nextInt();

                int maximoa = 0;
                int maximoa1 = 0;


                for (int i = 0;i<zenbat1;i++){
                    System.out.println("Sartu maximoa kalkulatu nahi den zenbakia:");
                    maximoa = sc.nextInt();


                    if (maximoa1 < maximoa){
                        maximoa1 = maximoa;
                    }
                }

                System.out.println("Sartu duzun zebakien artean, zenbaki altuena da: "+maximoa1);

                break;

        }



        sc.close();

    }
}