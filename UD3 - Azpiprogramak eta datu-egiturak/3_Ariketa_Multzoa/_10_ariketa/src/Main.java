import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] zenbakiak = new int[6];





        System.out.println("Sartu 5 zenbaki oso:");

        for (int i = 0;i<zenbakiak.length-1;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;

        }


        System.out.println("Array-a txertatu behar den zenbaki oso");
        int txertatu = sc.nextInt();

        zenbakiak[zenbakiak.length-1]=txertatu;

        Arrays.sort(zenbakiak);



        System.out.println("Hau da bukaerako array-a:");
        for (int i = 0;i< zenbakiak.length;i++){
            if (i < zenbakiak.length-1){
                System.out.print(zenbakiak[i]+" - ");
            }else {
                System.out.print(zenbakiak[i]);

            }
        }



        sc.close();

    }
}
