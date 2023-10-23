import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
int ibilkop;
double min=10;
double bb50 =0;
int kop50 =0;
double min1=10;
String dhelmu="";
String irtmin="";
String helmmin ="";
        Scanner sc= new Scanner(System.in);

        System.out.println("Zenbat ibilbidei buruzko informazioa sartu nahi duzu: ");
        ibilkop = sc.nextInt();
        for (int i =1; i <= ibilkop; i++){
            System.out.println(i+ ". irteera iriko lehen letra: ");
                String irtehiri= sc.next();
                System.out.println("Helmuga hiriko lehen letra:");
                String helmhiri = sc.next();
            System.out.println("Ibilbidearen distantzia:");
                double dist = sc.nextDouble();
            System.out.println("Prezioa: ");
                double prez = sc.nextDouble();

                if (prez<min){

                    min = prez;
                    irtmin = irtehiri;
                    helmmin = helmhiri;
                }

                if (dist>50){

                    bb50 = bb50 + dist;
                    kop50++;
                }
                if (irtehiri == "D"){
                    if (prez < min1){
                        min1 = prez;
                        dhelmu = helmhiri;
                    }


                }
        }
        System.out.println("Ibilbide merkeenaren irteera " + irtmin + " da eta helmuga " + helmmin );
        System.out.println("50km baino gehiagoko ibilbideen bataz beztekoa: " + bb50/kop50 + "da.");
        System.out.println("Donostiatik irteten den ibilbide merkeenaren prezioa " +min1+ "€ dira eta helmuga " + dhelmu);
sc.close();
    }
}