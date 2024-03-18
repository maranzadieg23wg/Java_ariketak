import java.util.Scanner;
public class _5_Manex_Aranzadi_Egaña {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        int antzinatasuna =0;
        int adina =0;
        int proiektuKopurua=0;

        int adinaBatazbeste =0;
        int zenbat25 =0;

        String proiektuIzena ="";
        double dirua =0;
        double dirua2 =0;


        String proiektuIzenaDiru ="";
        double diruaGeihen =0;


        for (int i =0;i<20;i++){
            System.out.print("Antzinatasuna: ");
            antzinatasuna= sc.nextInt();

            System.out.print("Adina: ");
            adina= sc.nextInt();

            if (antzinatasuna>25){
                adinaBatazbeste += adina;
                zenbat25++;
            }

            System.out.print("Parte artu duen proiektu kopurua: ");
            proiektuKopurua= sc.nextInt();

            for (int e =0;e<proiektuKopurua;e++){
                System.out.print("Proiektuaren izena: ");
                String borratzeko =sc.nextLine();
                proiektuIzena= sc.nextLine();

                System.out.print("Proiektuarekin irabazitako dirua: ");
                dirua2+=dirua= sc.nextInt();

                if (diruaGeihen<dirua){
                    diruaGeihen =dirua;
                    proiektuIzenaDiru =proiektuIzena;
                }
            }
            System.out.println("Langile honek "+proiektuKopurua+" proiektutan-tan lan egin du eta "+dirua2+"€ irabazi ditu.");

            dirua2 =0;

        }

        if (zenbat25 !=0){
            System.out.println("25 urte baino gehiago duten langileen batazbestekoa da:"+adinaBatazbeste/zenbat25);
        }else {
            System.out.println("Empresan lan egiten duten langile guztiek 25 urte baino gutxiagoz lan egiten dute.");
        }

        System.out.println(proiektuIzenaDiru+" proiektuak diru gehein irabazi duen proiektua da, guztira "+diruaGeihen);











        sc.close();

    }
}