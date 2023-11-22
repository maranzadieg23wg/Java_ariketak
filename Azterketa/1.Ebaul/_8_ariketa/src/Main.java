import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String rubic [][]=new String[3][3];

        for (int i =0;i<rubic.length;i++){
            for (int e =0;e<rubic.length;e++){
                if(i ==0){
                    rubic[i][e]="a";
                }else if (i ==1){
                    rubic[i][e]="b";
                }   else {
                    rubic[i][e]="c";
                }
            }
        }
        System.out.println("Hasierako rubik karratua: ");
        imprimatu(rubic);

        boolean jarraitu = true;
        String temp = "";

        while (jarraitu){
            menua();
            int mugimendua = sc.nextInt();
            System.out.println("Adierazi mugitu nahi duzun errenkada edo zutaberan indizea (0-2): ");
            int zein = sc.nextInt();

            if(mugimendua ==1){
                temp = rubic[zein][rubic.length-1];
                rubic [zein][rubic.length-1] = rubic [zein][rubic.length-2];
                rubic [zein][rubic.length-2] = rubic [zein][rubic.length-3];
                rubic [zein][rubic.length-3] = temp;

            } else if (mugimendua==2) {
                temp = rubic[zein][rubic.length-3];
                rubic [zein][rubic.length-3] = rubic [zein][rubic.length-2];
                rubic [zein][rubic.length-2] = rubic [zein][rubic.length-1];
                rubic [zein][rubic.length-1] = temp;

            } else if (mugimendua==3) {
                temp = rubic[rubic.length-1][zein];
                rubic [rubic.length-1][zein] = rubic [rubic.length-2][zein];
                rubic [rubic.length-2][zein] = rubic [rubic.length-3][zein];
                rubic [rubic.length-3][zein] = temp;


            } else if (mugimendua==4) {
                temp = rubic[rubic.length-3][zein];
                rubic [rubic.length-3][zein] = rubic [rubic.length-2][zein];
                rubic [rubic.length-2][zein] = rubic [rubic.length-1][zein];
                rubic [rubic.length-1][zein] = temp;
            }else {
                System.out.println("Sartu duzun mugimenduak ez du balio.");
            }


            imprimatu(rubic);

            System.out.println("Bukatu nahi al duzu? (Bai/Ez)");
            String ez = sc.nextLine();

            String bai = sc.nextLine();

            if (bai.equals("Ez")){
                jarraitu = false;
            }else {
                jarraitu = true;
            }








        }












        sc.close();

    }





    public static void imprimatu(String [][]lista){
        for (int i =0;i< lista.length;i++){
            for (int e =0;e< lista.length;e++){
                System.out.print(lista[i][e]+" ");
            }
            System.out.println(" ");
        }
    }

    public static void menua(){

        System.out.println("Adierazi zer nola mugimendua egin nahi duzun: ");

        System.out.println("1. Errenkada eskuinera");
        System.out.println("2. Errenkada ezkerrera");
        System.out.println("3. Zutabea behera");
        System.out.println("4. Zutabea gora");
    }


}