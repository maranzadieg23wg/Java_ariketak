import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int herriKopurua = 0;
        int herriKodea = 0;
        int familiaKopurua =0;
        float soldata = 0;
        float guztira = 0;
        int semeKopurua = 0;
        float azalera2 =0;

        float azaleraHandiena = 0;
        int probintziaAzalera = 0;
        int herri = 0;

        for (int i = 0;i<4;i++){
            System.out.println("Probintzia kodea");
            int ProbintziaKodea = sc.nextInt();
            System.out.println("Herri kopurua:");
            herriKopurua = sc.nextInt();
            soldata =0;
            guztira = 0;

            for (int e = 0;e<herriKopurua;e++){
                System.out.println("Herri kodea:");
                herriKodea = sc.nextInt();
                System.out.println("Herriaren azalera:");
                float azalera = sc.nextFloat();
                System.out.println("Famili kopurua:");
                familiaKopurua = sc.nextInt();



                azalera2 = azalera2+azalera;

                for (int a = 0;a < familiaKopurua;a++){
                    System.out.println("Famili kodea:");
                    int familiaKodea = sc.nextInt();
                    System.out.println("Soldata:");
                    soldata = sc.nextFloat();
                    System.out.println("Seme alaba kopurua:");
                    int semeAlabaKopurua = sc.nextInt();

                    guztira = guztira+ soldata;

                    if (semeAlabaKopurua >= 3){
                        semeKopurua++;
                    }




                }
                System.out.println("Herri kodea: "+herriKodea);
                guztira = guztira / familiaKopurua;
                System.out.println("Soldaten batezbestekoa: "+ guztira);

            }
            System.out.println("Probintzia kodea: "+ProbintziaKodea);
            System.out.println("3 semen-alaba edo gehiago dauden familiak probintzian: "+ semeKopurua);

            if (azaleraHandiena < azalera2){
                azaleraHandiena = azalera2;
                probintziaAzalera = ProbintziaKodea;
                herri = herriKopurua;

            }
            azalera2 = 0;




        }
       // System.out.println("azalera: "+azaleraHandiena+" herria "+herri);
        float total = azaleraHandiena / herri;
        System.out.println("Azalera handiena duen probintzia da: "+probintziaAzalera);
        System.out.println("Azaleraren batazbestekoa da: "+total);
        sc.close();

    }
}