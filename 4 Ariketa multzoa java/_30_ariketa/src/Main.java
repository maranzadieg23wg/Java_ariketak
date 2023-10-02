import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException{

        /*Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbakia = sc.nextInt();
        sc.close();*/


        int ordua = 0;
        int minutua = 0;
        int segundua = 0;

        while (true){
            Thread.sleep(1000);

            segundua++;

            if (segundua > 59){
                segundua = 0;
                minutua++;
            }
            if (minutua > 59){
                minutua = 0;
                ordua++;
            }
            if (ordua > 23 && minutua > 59 && segundua > 59){
                ordua = 0;
                segundua = 0;
                minutua = 0;
                System.out.println("Egun oso bat pasa egin da.");
            }
            System.out.printf("%02d:%02d:%02d\n", ordua, minutua, segundua);
        }


    }
}