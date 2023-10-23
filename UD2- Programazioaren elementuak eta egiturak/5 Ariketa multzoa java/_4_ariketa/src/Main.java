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

            float z1 = berrekizuna;

            for (int i = 1;i<berretzailea;i++){
                z1 = z1 * berrekizuna;
            }

            System.out.println("Erantzuna da: "+ z1);


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