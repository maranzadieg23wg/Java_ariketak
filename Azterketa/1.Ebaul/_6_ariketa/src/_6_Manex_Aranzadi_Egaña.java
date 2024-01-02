import java.util.Scanner;
public class _6_Manex_Aranzadi_Egaña {
    public static void main(String[] args) {



        int lista []= new int [6];

        int zenbakiak []= new int [6];

        int sarituak =0;


        System.out.println("Sartu zure apustua: ");

        for (int i =0;i<lista.length;i++){
            lista[i]=zenbakiak(lista);
        }

        for (int i =0;i<lista.length;i++){
            zenbakiak[i]=aleatorio();
        }

        System.out.println("Zure apustua hau da: ");
        imprimatu(lista);

        System.out.println("Zenbaki sarituak hauek dira: ");
        imprimatu(zenbakiak);

        for (int i =0;i<lista.length;i++){
            for (int e =0;e<zenbakiak.length;e++){
                if (lista[i]==zenbakiak[e]){
                    sarituak++;
                }
            }
        }

        System.out.println("Asmatutakoen kopurua: "+sarituak);




        //sc.close();

    }

    public static int zenbakiak (int []lista){
        Scanner sc = new Scanner(System.in);

        int zenbakia = sc.nextInt();

        while (zenbakia >50 || zenbakia<1 ){
            System.out.println("Zenbakia 1 eta 49 artean egon behar du. Sartu beste bat: ");
            zenbakia = sc.nextInt();

        }
        for (int i =0;i< lista.length;i++){
            while (zenbakia==lista[i]){
                System.out.println("Sartutako zenbakia errepikatuta dago. Sartu beste bat: ");
                zenbakia = sc.nextInt();
            }
        }
        return zenbakia;
        //sc.close();
    }

    public static int aleatorio(){
        return  (int)(Math.random()*50);
    }

    public static void imprimatu(int []lista){
        for (int i =0;i< lista.length;i++){
            if (i != lista.length-1){
                System.out.print(lista[i]+" ");
            }else {
                System.out.println(lista[i]);
            }
        }
    }
}