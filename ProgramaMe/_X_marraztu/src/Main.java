public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        int zenbat = 7;

        for (int i =0;i<zenbat;i++){
            for (int e =0;e<zenbat;e++){
               // System.out.print(i+e + " ");

                if (i+e == zenbat-1 || i ==0 || i == zenbat-1){
                    System.out.print("* ");
                }
            }
            System.out.println(" ");
        }


    }
}