import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");

        int [] lista = new int[10];

        for (int i = 0;i<10;i++){
            int zenbakia = sc.nextInt();
            lista [i] = zenbakia;

        }

        for (int i = 0;i<10;i++){
            System.out.println(i+". posizioan "+lista[i]+" balioa gorde da.");
        }

        sc.close();

    }
}