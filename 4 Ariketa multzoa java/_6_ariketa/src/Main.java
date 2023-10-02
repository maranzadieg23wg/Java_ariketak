import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu gygabyte kopurua;");
        float GB = sc.nextFloat();
        sc.close();

        float MB = GB * 1024;
        float CD = MB / 700;
        float E = MB % 700;

        if (E == 0){
            int V_X = (int) CD;
            System.out.println(GB + " GB gordetzeko "+V_X+" CD behar dira");
        }else {
            int V_X = (int) CD;
            V_X = V_X +1;
            System.out.println(GB + " GB gordetzeko "+V_X+" CD behar dira");
        }



    }
}