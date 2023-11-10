import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //int errenkada = 8;
        //int zutabe = 6;

        System.out.print("Sartu tanto kopurua: ");
        int kopurua = sc.nextInt();

        sc.nextLine();

        String [] lista = new String[kopurua];


        System.out.println("Sartu partidako tantoak: ");
        for (int i =0;i<kopurua;i++){
            lista[i] = sc.nextLine();
        }


        int a =0;
        int b =0;
        if (lista[0].equals("A")){
            System.out.print("K");
            a++;
        }else if (lista[0].equals("B")) {
            System.out.print("C");
            b++;
        }

        for (int i =0;i< lista.length-1;i++){
            if (lista[i].equals(lista[i+1]) && lista[i].equals("A")){
                a++;
            }else if (lista[i].equals(lista[i+1]) && lista[i].equals("B")){
                b++;
            }
            if (i==9 && a-b <3||b-a<3){
                System.out.print(a+"-"+b);
            }
            a =0;
            b =0;

        }



        //matrizea inprimatzen
        System.out.println("Markagailuaren egoera hau da: ");
        System.out.print(a+"-"+b);








        sc.close();

    }

    public static void inprimatu (int [] []matrizea, int errenkada, int zutabe){

        //inprimatzen du matrizea
        //System.out.println("Hau da bukaerako matrizea: ");

        for (int i = 0;i<errenkada;i++){
            for (int e = 0;e<zutabe;e++){
                System.out.print(matrizea[i][e]+"  ");
            }
            System.out.println(" ");
        }

        //return matrizea[1][1];

    }
}