import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu hiru hitz");
        String hitz1 = sc.nextLine();
        String hitz2 = sc.nextLine();
        String hitz3 = sc.nextLine();
        sc.close();

        long hitza1 = kontatu(hitz1);
        long hitza2 = kontatu(hitz2);
        long hitza3 = kontatu(hitz3);
        long hitzaGuztira = hitza1 + hitza2 + hitza3;

        System.out.println("Lehenengo hitzaren luzeera da " + hitza1);
        System.out.println("Bigarren hitzaren luzeera da " + hitza2);
        System.out.println("Hirugarren hitzaren luzeera da " + hitza3);
        System.out.println("Hitz guztien luzeera da " + hitzaGuztira);

    }
    public  static long kontatu(String hitza){

        int letraCantitatea = hitza.length();

        return  letraCantitatea;

    }

}