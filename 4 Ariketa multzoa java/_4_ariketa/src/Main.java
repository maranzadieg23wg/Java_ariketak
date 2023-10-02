import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu diru kopuru bat:");
        float dirua = sc.nextFloat();
        sc.close();

        float kantitatea = 0;
        int i = 0;

        float[] bileteak = {200, 100, 50, 20, 10, 5, 2, 1, 0.5f, 0.2f, 0.1f, 0.05f, 0.02f, 0.01f};
        System.out.println("Hau da diruaren banaketa:");
        for (int l = bileteak.length - 1;l >= 0;l--){

            kantitatea = dirua / bileteak[i];

            //System.out.println(kantitatea+" kantitatea");
            //System.out.println(bileteak[i]+" lista");

            int a = (int) kantitatea;


            if (i <= 4){
                int V_X = (int) bileteak[i];
                System.out.println(V_X+" euroko"+" "+a+" bilete");
            }else if (i <=7){
                int V_X = (int) bileteak[i];
                System.out.println(V_X+" euroko"+" "+a+" txanpon");
            }else {
                float V_O = bileteak[i]*100;
                int V_X = (int) V_O;
                System.out.println(V_X+" zentimoko"+" "+a+" txanpon");
            }


            dirua = dirua - (bileteak[i]*a);

            i= i+1;
        }



    }


}