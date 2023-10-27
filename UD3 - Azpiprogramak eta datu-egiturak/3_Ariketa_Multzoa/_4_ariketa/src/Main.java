import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int [] zenbakiak1 = new int[9];
        int [] zenbakiak2 = new int[9];


        System.out.println("Bete lehen array-a bederatzi zenbaki osoekin:");

        for (int i = 0;i<zenbakiak1.length;i++){
            int zenb = sc.nextInt();
            zenbakiak1 [i] = zenb;
        }


        System.out.println("Bete bigarren array-a bederatzi zenbaki osoekin:");

        for (int i = 0;i<zenbakiak2.length;i++){
            int zenb = sc.nextInt();
            zenbakiak2 [i] = zenb;
        }

        System.out.println("Eskatutako emaitza: ");

        for (int i =0;i<(zenbakiak1.length+zenbakiak2.length)/3+2;i+=3){
            for (int e =0;e<3;e++){
                System.out.print(zenbakiak1[i+e]+" - ");
            }
            for (int e =0;e<3;e++){
                if (i <(zenbakiak1.length+zenbakiak2.length)+1){
                    System.out.print(zenbakiak2[i+e]+" - ");
                }else {
                    System.out.print(zenbakiak2[i+e]);
                }

            }
        }







        sc.close();

    }
}