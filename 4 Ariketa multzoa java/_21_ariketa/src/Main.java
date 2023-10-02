import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        byte egia = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso positibo eta negatiboen segida, bukatu 0 bat sartuz:");

        ArrayList<Double> lista = new ArrayList<Double>();

        while (egia == 0){

           double berrekizuna = sc.nextDouble();
            lista.add(berrekizuna);
            if (berrekizuna == 0){
                egia = 1;
                lista.remove(lista.size()-1);
            }

        }



        sc.close();

        double positibo = 0;
        double negatibo = 0;

        for (int i = 0;i < lista.size();i++){
            if (lista.get(i) < 0){
                negatibo = negatibo + lista.get(i);
            }else if (lista.get(i)>0){
                positibo = positibo + lista.get(i);
            }
        }

        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for (double numero : lista){
            if (numero < min){
                min = numero;
            }
            if (numero > max){
                max = numero;
            }
        }

        System.out.println("Zenbaki positiboen batura "+positibo+" da.");
        System.out.println("Zenbaki negatiboen batura "+negatibo+" da.");
        System.out.println("Zenbaki handiena "+max+" da.");
        System.out.println("Zenbaki txikiena "+min+" da.");

    }
}
