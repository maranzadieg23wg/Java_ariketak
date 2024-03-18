import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zatikizuna:");
        double n = sc.nextDouble();
        System.out.println("Sartu zatitzailea:");
        double m = sc.nextDouble();
        sc.close();




        double Nresult = ((Math.PI*n)/n)-(1/(Math.log(n)));
        double Mresult = 1/Math.pow(10, m);

        System.out.println(Nresult);
        System.out.println(Mresult);
        if (Nresult > Mresult){
            System.out.println("Mayor");
        }else {
            System.out.println("Menor");
        }



    }
}