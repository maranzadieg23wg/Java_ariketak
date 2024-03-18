import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int [] zenbakiak1 = new int[9];
        int [] zenbakiak2 = new int[9];
        int [] zenbakiak3 = new int[18];




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

        for (int i = 0;i<9;i++){
            zenbakiak3 [i] = zenbakiak1[i];
            zenbakiak3[i+9]=zenbakiak2[i];
        }
        System.out.println("Eskatutako emaitza: ");

       /* for (int i =0;i<(zenbakiak1.length+zenbakiak2.length)/3+2;i+=3){
            for (int e =0;e<3;e++){
                System.out.print(zenbakiak1[i+e]+" - ");
              //System.out.print("i="+i+" / ");
            }
            for (int e =0;e<3;e++){
                if (i <6){
                    System.out.print(zenbakiak2[i+e]+" - ");
                }else {
                    e =3;
                    System.out.print(zenbakiak2[i]+" - ");
                    System.out.print(zenbakiak2[i+1]+" - ");
                    System.out.print(zenbakiak2[i+2]);
                }

            }
        }*/

        int a = 0;
        int e = 0;
        for (int i = 0; i < 18; i += 3) {
            //System.out.println("I: "+i);
            if (i % 6 == 0) {
                System.out.print(zenbakiak3[a] + " - ");
                System.out.print(zenbakiak3[a + 1] + " - ");
                System.out.print(zenbakiak3[a + 2] + " - ");
                a += 3;
            } else {
                System.out.print(zenbakiak3[e + 9] + " - ");
                System.out.print(zenbakiak3[e + 10] + " - ");
                if (i == 15){
                    System.out.print(zenbakiak3[e + 11]);
                }else {
                    System.out.print(zenbakiak3[e + 11] + " - ");
                }

                e += 3;
            }
        }









        sc.close();

    }
}