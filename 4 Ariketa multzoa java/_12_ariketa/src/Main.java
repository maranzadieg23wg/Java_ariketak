import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu lehen zenbakia:");
        int zenbakia1 = sc.nextInt();
        System.out.println("Sartu bigarren zenbakia:");
        int zenbakia2 = sc.nextInt();
        System.out.println("Sartu hirugarren zenbakia:");
        int zenbakia3 = sc.nextInt();
        System.out.println("Sartu laugarren zenbakia:");
        int zenbakia4 = sc.nextInt();
        System.out.println("Sartu bosgarren zenbakia:");
        int zenbakia5 = sc.nextInt();
        sc.close();




        ArrayList lista = new ArrayList<>();
        lista.add(zenbakia1);
        lista.add(zenbakia2);
        lista.add(zenbakia3);
        lista.add(zenbakia4);
        lista.add(zenbakia5);

        Collections.sort(lista);

        System.out.println("Zenbaki handiena "+lista.get(4) +" da eta txikiena "+lista.get(0)+ " da");

    }
}