import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki bat:");
        int zenbaki1 = sc.nextInt();
        System.out.println("Sartu beste zenbaki bat:");
        int zenbaki2 = sc.nextInt();
        sc.close();

        if (zenbaki1 == zenbaki2){
            System.out.println("Bi zenbakiak berdinak dira");
        } else if (zenbaki1 > zenbaki2) {
            System.out.println(zenbaki1 + " "+ zenbaki2 + " baino handiagoa da");
        }else {
            System.out.println(zenbaki2 + " "+ zenbaki1 + " baino handiagoa da");
        }

    }
}