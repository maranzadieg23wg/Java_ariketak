import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float berrekizuna = 0;
        int berretzailea = 0;
        byte egia = 0;
        while (egia == 0){
            System.out.println("Sartu berrekizuna");
            berrekizuna = sc.nextFloat();

            System.out.println("Sartu berretzailea");
            berretzailea = sc.nextInt();

            float z1 = berrekizuna / berretzailea;

            float z2 = berrekizuna % berretzailea;

            System.out.println(berrekizuna+"/"+berretzailea+" = "+z1);
            System.out.println("Ondarra = "+z2);


            System.out.println("Jarraitu nahi duzu? B/E");
            sc.nextLine();

            String bai = sc.nextLine();

            if (bai.equals("E")|| bai.equals("e")){
                System.out.println("Programa gelditu egingo da");
                System.exit(0);
            }

        }


    }
}