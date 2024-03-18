import java.util.Scanner;

public class ZatiZero {

    Scanner sc = new Scanner(System.in);


    static void main(){
        Scanner sc = new Scanner(System.in);

        try {
            int z1 = sc.nextInt();
            int z2 = sc.nextInt();

            System.out.println(z1/z2);
        }catch (ArithmeticException e){
            System.err.println("ERROREA. Zati zero");
        }catch (Exception e){
            System.err.println("Zenbakiak sartu behar dira, ez letrak");
        }
    }
}
