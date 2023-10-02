import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int guztira = 0;
        System.out.println("Sartu 10 zenbaki oso:");
        for (int i = 0; i <=9;i++){


            int zenbakia = sc.nextInt();


            if (zenbakia > 0){
                guztira = guztira +1;
                System.out.println(zenbakia);
            }

        }
        System.out.println("Zenbaki positiboen kopurua: "+guztira);
        sc.close();

    }
}