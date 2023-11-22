import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Adierazi matrizearen aldea: ");
        int tamaina = sc.nextInt();


        int posI =0;
        int posE =0;

        boolean triangulo = false;

        int zero =0;



        int matrizea [][]=new int[tamaina][tamaina];

        for (int i =0;i<matrizea.length;i++){
            for (int e =0;e<matrizea.length;e++){
                matrizea[i][e]= sc.nextInt();
                //matrizea[i][e]= i+e;

            }
        }

        for (int i =0;i<matrizea.length;i++){
            for (int e =0;e<matrizea.length;e++){
                if (matrizea[i][e]==0){
                    zero++;
                }
            }
        }



        System.out.println(triangulo);





        imprimatu(matrizea);






        sc.close();

    }





    public static void imprimatu(int [][]lista){
        for (int i =0;i< lista.length;i++){
            for (int e =0;e< lista.length;e++){
                System.out.print(lista[i][e]+" ");
            }
            System.out.println(" ");
        }
    }
}