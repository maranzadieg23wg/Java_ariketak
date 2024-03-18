import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String merkeenaIrteera = "a";
        String merkeenaHelmuga = "a";
        int merkeena = 800000000;

        //50 km baino gehiagoko ibilbideak
        int batazbestekoa = 0;
        int zenbat = 0;

        int donostiMerkeena = 800000000;
        String donostiHelmuga = "a";


        Scanner sc=new Scanner(System.in);

        boolean egia = true;

        while (egia){
            System.out.println("Irteera hiriko lehen letra: ");
            String irteera = sc.nextLine();

            System.out.println("Helmuga hiriko lehen letra: ");
            String helmuga = sc.nextLine();

            System.out.println("Ibilbidearen distantzia: ");
            int distantzia = sc.nextInt();

            System.out.println("Hibilbidearen prezioa: ");
            int prezioa = sc.nextInt();

            //ibilbide merkeena
            if (prezioa < merkeena){
                merkeena = prezioa;
                merkeenaIrteera = irteera;
                merkeenaHelmuga = helmuga;
            }

            //50 km baino gehiago
            if (distantzia > 50){
                batazbestekoa += prezioa;
                zenbat++;
            }

            //donostitik ateratakoak
            if (irteera.equals("D") && donostiMerkeena > prezioa){
                donostiMerkeena = prezioa;
                donostiHelmuga = helmuga;
            }

            if (batazbestekoa != 0){
                batazbestekoa = batazbestekoa/zenbat;
            }

            System.out.println("Beste autobus baten datuak sartu nahi dituzu? B/E");
            String ez = sc.nextLine();
            String bai = sc.nextLine();
            if (bai.equals("E")){
                egia = false;
            }

        }

        System.out.println("Hibilbide merkeenaren irteera da: "+merkeenaIrteera+" eta helmuga: "+merkeenaHelmuga+" guztira ateratzen da: "+merkeena+"€");

        if (batazbestekoa !=0){
            System.out.println("50km baino luzeagogoak diren ibilbideen bataztestekoa da: "+batazbestekoa+"€");
        }else {
            System.out.println("Ez da sartu bidairik 50km baino gehiagokoa");
        }

        if (donostiMerkeena == 800000000){
            System.out.println("Ez da sartu bidairik donostitik ateratzen dena");
        }else {
            System.out.println("Donostitik ateratzen den ibilbide merkenaren prezioa da: "+donostiMerkeena+"€ eta helmuga iria da: "+donostiHelmuga);
        }

        sc.close();








    }
}