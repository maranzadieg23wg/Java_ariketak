import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu 5 zenbaki oso bat:");

        int [] lista = new int[5];
        int [] listaIn = new int[5];

        for (int i = 0;i<5;i++){
            int zenbakia = sc.nextInt();
            lista [i] = zenbakia;

        }

        int buelta =0;

        for (int i = 4; i >= 0; i--){
            listaIn[buelta] = lista[i];
            buelta += 1;
        }

        System.out.println("Bukaerako array-a:");
        for (int i = 0;i<5;i++){
            System.out.print(listaIn[i]+" ");
        }

        sc.close();

    }
}