import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu zenbaki oso bat:");
        int zenbakia = sc.nextInt();
        sc.close();

        int guztira = 0;




        if (zenbakia <= 0){
            System.out.println("Errorea: Sarrerako zenbakiak positiboak izan behar dira");
            System.exit(0);
        }


        for (int i = 0; i < zenbakia;i++){




            if (i == 0){

            }
            else if (zenbakia % i == 0){
                guztira = guztira + i;
                //System.out.println(i);
            }


        }

        if (guztira == zenbakia){
            System.out.println(zenbakia+" zenbakia perfektua da");
        }else {
            System.out.println(zenbakia+" zenbakia ez da perfektua");
        }




    }

}
