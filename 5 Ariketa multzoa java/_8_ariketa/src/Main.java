import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maximoa = 801;
        System.out.println("Tunel kopurua: (max: 10):");
        int tunelKopurua = sc.nextInt();
        if (tunelKopurua >10){
            System.out.println("Tunel gehiegi daude, maximo 10");
            System.exit(0);
        }

        for (int i = 0;i<tunelKopurua;i++){


            System.out.println("Errei kopurua: (max: 5):");
            int erreiKopurua = sc.nextInt();


            if (erreiKopurua >5){
                System.out.println("Errei gehiegi daude, maximo 5");
                System.exit(0);
            }

            for (int e = 0;e<erreiKopurua;e++){
                System.out.println("Altura maximoa (max 800cm)");
                int alturaMaximoa = sc.nextInt();

                if (alturaMaximoa >800){
                    System.out.println("Sartutako altuera altuegia da, maximo 800cm");
                    System.exit(0);
                }

                if (alturaMaximoa < maximoa){
                    maximoa = alturaMaximoa;
                }
            }
        }

        System.out.println("Ibilgailuak eduki al duen altuera maximoa da: "+maximoa);


        sc.close();
    }
}