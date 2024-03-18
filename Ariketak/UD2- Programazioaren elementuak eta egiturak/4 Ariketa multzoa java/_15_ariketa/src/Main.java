import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu 1 eta 10 arteko zenbaki bat (biak barne)");
        int zenbakia = sc.nextInt();
        sc.close();

        if (zenbakia < 1 || zenbakia > 10){
            System.out.println("Errorea: Sarrerako zenbakia 1 eta 10 artean egon behar da");
            System.exit(0);
        }
        int guztira = 0;
        for (int i = 1;i <= 10;i++){
            guztira = i * zenbakia;
            System.out.println(zenbakia+" x "+i+" = "+guztira);
        }

    }
}