import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbakia = sc.nextInt();
        System.out.println("Sartu zatitzaile kopurua;");
        int zatitzailea = sc.nextInt();
        sc.close();

        int zatitzaileak = 0;


        if (zenbakia <= 0 || zatitzailea <= 0){
            System.out.println("Errorea: Sarrerako zenbakiak positiboak izan behar dira");
            System.exit(0);
        }


        for (int i = 0; zatitzaileak < zatitzailea;i++){


            if (i > zenbakia){
                System.out.println("Zenbakiak ez ditu hainbeste zatitzaile");
                System.exit(0);
            }

            if (i == 0){

            }
            else if (zenbakia % i == 0){
                System.out.println(i);
                zatitzaileak++;

            }


        }




    }

}
