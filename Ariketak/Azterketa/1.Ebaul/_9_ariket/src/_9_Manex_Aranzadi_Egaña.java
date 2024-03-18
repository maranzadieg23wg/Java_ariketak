import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;
public class _9_Manex_Aranzadi_Egaña {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Adierazi lehen zenbaki osoaren digitu kopurua");
        int z1 = sc.nextInt();

        int []lista = new int[z1];

        System.out.println("Sartu lehen zenbakia digituz digitu");
        for (int i =z1-1;i>=0;i--){
            lista[i]=sc.nextInt();
        }

        System.out.println("Adierazi bigarren zenbaki osoaren digitu kopurua");
        int z2 = sc.nextInt();

        int []lista2 = new int[z1];

        System.out.println("Sartu bigarren zenbakia digituz digitu");
        for (int i =z2-1;i>=0;i--){
            lista2[z1-i-1]=sc.nextInt();
        }


        int zenbat =0;

        int zenbat2 =0;

        for (int i =z1-1;i>=0;i--){

            zenbat+= (lista[i]+lista2[i] +zenbat2) /10;

            zenbat2= (lista[i]+lista2[i]+zenbat2) /10;

        }

        System.out.println("Sartutako zenbakiak: ");
        imprimatu(lista);
        imprimatu(lista2);
        System.out.println("Batuketan "+zenbat+" eramaren d(ir)a.");







        sc.close();


    }





    public static void imprimatu(int []lista){
        for (int i =0;i< lista.length;i++){
            System.out.print(lista[i]);
        }
        System.out.println(" ");
    }
}