import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // https://aceptaelreto.com/problem/statement.php?id=123

        Scanner sc = new Scanner(System.in);

        /*int errenkada = 3;
        int zutabe = 6;*/

        /*System.out.println("Sartu matrizearen errenkada kopurua: ");
        int errenkada = sc.nextInt();

        System.out.println("Sartu matrizearen zutabe kopurua: ");
        int zutabe = sc.nextInt();*/


        String verbo =sc.nextLine();

        String [] atzizkiaA = new String[6];
        String [] atzizkiaP = new String[6];
        String [] atzizkiaF = new String[6];
        String [] prefijo = new String[6];

        atzizkiaA[0]="o";
        atzizkiaA[1]="s";
        atzizkiaA[2]="";
        atzizkiaA[3]="os";
        atzizkiaA[4]="is";
        atzizkiaA[5]="n";

        atzizkiaP[0]="e";
        atzizkiaP[1]="ste";
        atzizkiaP[2]="o";
        atzizkiaP[3]="mos";
        atzizkiaP[4]="steis";
        atzizkiaP[5]="on";

        atzizkiaF[0]="e";
        atzizkiaF[1]="as";
        atzizkiaF[2]="a";
        atzizkiaF[3]="emos";
        atzizkiaF[4]="eis";
        atzizkiaF[5]="an";

        char aei= 'a';

        aei =verbo.charAt(verbo.length()-2);

        System.out.println(aei);
















        //System.out.println("Bete 4x4 matrize bat zenbaki osoekin:");

        String aditza = sc.nextLine();
        String denbora = sc.nextLine();


        //zenbakiak gehitzen ditut matrizera
        for (int i = 0;i< 6;i++){

        }



        //matrizea inprimatzen
        /*System.out.println("Hau da emaitza matrizea: ");
        inprimatu(saltar,errenkada,zutabe);*/








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