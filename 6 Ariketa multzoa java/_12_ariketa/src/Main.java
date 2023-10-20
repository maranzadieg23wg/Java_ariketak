import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        int zenbakia = 0;
        String tab = " ";



        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbat = sc.nextInt();
        sc.close();

        zenbat--;

        for (int i = 0;i<zenbat;i++){
            System.out.print("\t");
        }
        System.out.println(1);
        for (int i = 1;i<=zenbat;i++){

            for (int a = zenbat;a>i;a--){
                System.out.print("\t");
            }
            System.out.print("1");
            System.out.print("\t \t");


            // hirugarren filan, 3 zenbaki daude kalkulatzeko, 4 filan baita ere 4 zenbaki kalkulatzkeo.
            for (int e = 1;e<= i;e++){
                //i = zenbagarren fila
                //e = zenbagarren zenbakia kalkulatu behar den.
                zenbakia = triangulo(i,e);
                System.out.print(zenbakia);
                System.out.print("\t \t");

            }
            System.out.println("");

        }




    }


    public static int factorial (int z1){

        int n = 1;
        // faktoriala kalkulatzen du.
        for (int i = 1;i<=z1;i++){
            n = n*i;
        }

        return n;

    }
    public static int triangulo (int fila, int posizioa){
        int zenbakia = 0;
        // (x!/y!(x-y)!)      x = fila  y = posizioa
        zenbakia = (factorial(fila))/(factorial(posizioa)*factorial(fila-posizioa));

        return zenbakia;

    }

}