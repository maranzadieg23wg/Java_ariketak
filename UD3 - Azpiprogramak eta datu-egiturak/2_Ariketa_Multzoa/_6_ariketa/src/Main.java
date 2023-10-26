import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu ikasle kopurua:");
        int ikasleKopurua = sc.nextInt();

        float batazbestekoa = 0;


        float [] notak = new float[ikasleKopurua];

        System.out.println("Sartu ikasleen notak: ");
        for (int i = 0;i<ikasleKopurua;i++){

            float zenbakia = sc.nextFloat();
            notak [i] = zenbakia;

            batazbestekoa += zenbakia;

        }
        batazbestekoa = batazbestekoa/ikasleKopurua;
        System.out.println("Sartutako noten batazbestekoa: "+batazbestekoa);

        System.out.println("Hauek dira batazbestekoak baino altuagoaj diren notak:");
        for (int i = 0;i< ikasleKopurua;i++){
          if (notak[i] > batazbestekoa){
              System.out.println(notak[i]);
          }
        }





        sc.close();

    }
}