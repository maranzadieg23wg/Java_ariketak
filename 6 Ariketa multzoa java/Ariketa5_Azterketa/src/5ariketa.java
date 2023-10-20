import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Sartu 25 eta 75 arteko zanbaki bat:");
            int zenb = sc.nextInt();

        System.out.println("Sartu 25 eta 75 arteko bigarren zanbakia bat:");
            int zenb2 = sc.nextInt();



                   int dig11= zenb/10;
                   int dig12 = zenb%10;
                   int dig21 = zenb2/10;
                   int dig22 = zenb2%10;

                   if (dig11== dig21|| dig11 == dig22 || dig12== dig21 || dig12 == dig22){

                       System.out.println("Sartutako zenbakien digituren bat berdinak dira.");

                   }
                   else {
                       System.out.println("Sartutako zenbakien digituen artean ez dago berdinik.");
                   }




sc.close();



    }
}