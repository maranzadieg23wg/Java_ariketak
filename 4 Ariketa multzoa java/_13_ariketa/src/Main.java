import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu ordu bat hh:mm:ss formatuan:");
        String ordua1 = sc.nextLine();
        System.out.println("Sartu beste ordu bat hh:mm:ss formatuan:");
        String ordua2 = sc.nextLine();
        sc.close();

        String[] lista1 = ordua1.split(":");
        String[] lista2 = ordua2.split(":");

        if (Integer.parseInt(lista1[0])>=24 || Integer.parseInt(lista1[1]) >= 60 || Integer.parseInt(lista2[0])>=24 || Integer.parseInt(lista2[1]) >= 60 ||Integer.parseInt(lista1[2])>=60 || Integer.parseInt(lista2[2]) >= 60){
            System.out.println("Sartu duzun ordua ez dago ongi sartuta");
            System.exit(0);
        }

        int segunduak = 0;
        int minutuak = 0;
        int orduak = 0;

        segunduak = Integer.parseInt(lista1[2])+Integer.parseInt(lista2[2]);
        if (segunduak >=60){
            segunduak = segunduak-60;
            minutuak = minutuak +1;
        }

        minutuak = Integer.parseInt(lista1[1])+ Integer.parseInt(lista2[1])+minutuak;
        if (minutuak >=60){
            minutuak = minutuak-60;
            orduak = orduak +1;
        }

        orduak = Integer.parseInt(lista1[0])+Integer.parseInt(lista2[0])+orduak;
        if (orduak >=24){
            orduak = orduak-24;
        }

        System.out.println("Orduen batura hau da: "+orduak+":"+minutuak+":"+segunduak);
    }
}
