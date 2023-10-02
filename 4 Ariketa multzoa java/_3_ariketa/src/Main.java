import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu segundu kopuru bat:");
        long segundu = sc.nextLong();
        sc.close();

        long guztira = segundu;
        double egun = 0;
        double ordu = 0;
        double minutu = 0;




        if (segundu >= 60)
            minutu = segundu / 60;
            segundu = segundu % 60;

            if (minutu >= 60)
                ordu = minutu / 60;
                minutu = minutu % 60;


                if (ordu >= 24)
                    egun = ordu / 24;
                    ordu = ordu % 24;




        long segunduak = (long) segundu;
        long minutuak = (long) minutu;
        long orduak = (long) ordu;
        long egunak = (long) egun;



        //System.out.println(segunduak);
        System.out.println(guztira + " segundu" + " " + egunak +" egun,"+" "+ orduak+" ordu, "+minutuak+" minutuak"+" "+segunduak+" segundu dira.");






    }



}