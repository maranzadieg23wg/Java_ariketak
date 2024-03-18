import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zembaki oso bat:");
        int zenbakia = sc.nextInt();
        sc.close();

        if (zenbakia <0){
            System.out.println("Error: sartutako zenbakia negatiboa da");
            System.exit(0);
        }

        for (int i = 2; i < zenbakia /2;i++){
            if (zenbakia % i == 0){
                System.out.println("Sartutako zenbakia ez da lehena");
                System.exit(0);
            }
        }
        System.out.println("Sartutako zenbakia lehena da");


    }
}