import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        int guztira = 0;
        List<Integer> lista = new ArrayList<Integer>();
        byte egia = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        while (egia ==0){

            int zenbakia = sc.nextInt();
            System.out.println("Sartu beste zenbaki bat:");

            lista.add(zenbakia);

            int i = 0;
            guztira = guztira + lista.get(i);
            i = i+1;

            if (lista.size() > 9){

                System.out.println("Exekuzioa amaitu da, 10 zenbaki sartu dituzu");
                egia = 1;
            }else if (guztira >=100){
                System.out.println("Exekuzioa amaitu da, sartutako zenbakien batura 100en berdina edo handiagoa da.");

                egia = 1;
            }




            /*for (int i = 0;i < lista.size();i++){


            }*/

        }

        guztira = 0;

        sc.close();

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            guztira = guztira + lista.get(i);
            if (i < lista.size() - 1) {
                System.out.print(" + ");
            }
        }
        System.out.print(" = "+guztira);








    }

}
