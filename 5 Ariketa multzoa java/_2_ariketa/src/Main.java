import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int ikasgaiKopurua = 10;


        int kodea = 0;
        float zortziOrduTeoriko = 0;
        float zortziOrduPraktiko = 0;
        float bostOrduTeoriko = 0;
        float bostOrduPraktiko = 0;
        float notaHoberena = 0;
        int orduKopurua = 0;
        int ikasleHoberena =0;
        int orduKantitatea = 0;
        int zortziKopuru=0;

        String emakumea = "e";
        String gizona = "g";
        String ezBinario = "z";

        for (int i = 0; i <ikasgaiKopurua;i++){
            notaHoberena =0;
            //System.out.println(i);
            System.out.println("Sartu ikasgaiako kodea:");
            kodea = sc.nextInt();

            System.out.println("Sartu ikasgaiaren ordu kantitatea:");
            orduKantitatea = sc.nextInt();

            System.out.println("Sartu ikasle kopurua:");
            int ikasleKopurua = sc.nextInt();

            orduKopurua = orduKopurua + orduKantitatea;

            for (int e = 0; e <ikasleKopurua;e++){
               // System.out.println(e);

                System.out.println("Sartu ikaslearen sexua:");
                sc.nextLine();

                String sexua = sc.nextLine();


                System.out.println("Sartu ikaslearen nota teorikoa:");
                float teoriko = sc.nextFloat();

                System.out.println("Sartu ikaslearen nota praktikoa:");
                float praktiko = sc.nextFloat();

                if (orduKantitatea > 8){
                    zortziOrduTeoriko = zortziOrduTeoriko + teoriko;
                    zortziOrduPraktiko = zortziOrduPraktiko + praktiko;
                    zortziKopuru++;
                }
                if (orduKantitatea >= 5 && orduKantitatea <=15){

                    float bostOrdu = teoriko+praktiko;

                    System.out.println("5 orduko eta 15 orduko klasea da.");
                    bostOrdu = bostOrdu*10 / 20;
                    System.out.println("Praktiko eta teorikoen media: "+ bostOrdu);

                }

                if (notaHoberena < praktiko){
                    //System.out.println("Sexua: "+sexua);

                    if (sexua.equals(emakumea)){
                        ikasleHoberena = 1;
                        notaHoberena = praktiko;

                    }
                    if (sexua.equals(gizona)) {
                        ikasleHoberena = 2;
                        notaHoberena = praktiko;

                    }
                    if (sexua.equals(ezBinario)) {
                        ikasleHoberena = 3;
                        notaHoberena = praktiko;
                    }
                }
            }


            //System.out.println("ikasle Hoberena " + ikasleHoberena);



            if (ikasleHoberena == 1){
                System.out.println("Nota hoberena dauka emakume batek dauka");
            } else if (ikasleHoberena == 2) {
                System.out.println("Nota hoberena dauka gizon batek dauka");
            } else if (ikasleHoberena == 3) {
                System.out.println("Nota hoberena dauka ez-binario batek dauka");
            }




        }


        orduKopurua = orduKopurua/ikasgaiKopurua;
        System.out.println("Batazbesteko ordu kopurua da: "+ orduKopurua);

//konpondu behar da
        System.out.println("8 ordu baino gehiago duten ikasgaiak: ");
        zortziOrduTeoriko = zortziOrduTeoriko / zortziKopuru;
        System.out.println("Teorikoa: "+ zortziOrduTeoriko);
        zortziOrduPraktiko = zortziOrduPraktiko / zortziKopuru;
        System.out.println("Praktiko: "+ zortziOrduPraktiko);




        sc.close();

    }
}