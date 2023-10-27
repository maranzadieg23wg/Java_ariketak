import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        float batazbestekoaPositibo = 0;
        float batazbestekoaNegatibo = 0;
        int zero = 0;
        int zenbatNegatibo = 0;
        int zenbatPositibo =0;
        float [] zenbakiak = new float[10];

        System.out.println("Sartu hamar zenbaki oso:");

        for (int i = 0;i<10;i++){
            int zenb = sc.nextInt();
            zenbakiak [i] = zenb;
        }

        for (int i = 0;i<10;i++){
            if (zenbakiak[i]==0){
                zero++;
            }
            else if (zenbakiak[i]<0){
                batazbestekoaNegatibo += zenbakiak[i];
                zenbatNegatibo++;
            }else {
                batazbestekoaPositibo += zenbakiak[i];
                zenbatPositibo++;
            }
        }
        batazbestekoaPositibo = batazbestekoaPositibo/zenbatPositibo;
        batazbestekoaNegatibo = batazbestekoaNegatibo/zenbatNegatibo;

        System.out.println("Zenbaki positiboen batazbtestekoa: "+batazbestekoaPositibo);
        System.out.println("Zenbaki negatiboen batazbtestekoa: "+batazbestekoaNegatibo);
        System.out.println("Zero izandako zenbakien kopurua: "+zero);





        sc.close();

    }
}