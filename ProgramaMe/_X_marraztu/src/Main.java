import java.util.Scanner; //Importatu objetua
public class Main {
    public static void main(String[] args) {

        System.out.println("Sartu zenbatekoa izan behar den");

        Scanner sc = new Scanner(System.in);
        /*boolean balioDu = false;

        while (!balioDu){
            //int zenbat = sc.nextInt();
            //balioDu =zenbakiaEskatu(zenbat);
        }*/


        int zenbat = sc.nextInt();

        if (zenbat <4 || zenbat %2 ==0){
            System.out.println("ERROR: Sartutako zenbakiak ez du balio.");
            zenbat =0;
        }




        for (int i =0;i<zenbat;i++){
                for (int e =0;e<zenbat;e++){
                    //System.out.print(i+e + "  ");

                    if (i+e == zenbat-1 || i-e == 0 || i ==0 || i == zenbat-1){
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }
                }
        System.out.println(" ");


            sc.close();
    }


    public static boolean zenbakiaEskatu(int zenbat){

        if (zenbat <4 || zenbat %2 !=0){
            System.out.println("ERROR: Sartutako zenbakiak ez du balio.");
            return false;
        }else {
            return true;
        }




    }

}