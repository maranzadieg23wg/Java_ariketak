import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        byte egia = 0;
        long ehunGehiago = 0;
        long zenbat10 = 0;
        long batazbestekoa = 0;
        while (egia == 0){

            System.out.println("Sartu zenbaki oso bat: ");
            long zenbakia = sc.nextLong();



            if (zenbakia == 0){
                egia =1;
                break;
            }

            if (zenbakia<0){
                System.out.println("Sartutako zenbakia negatiboa da, zenbaki positiboak sartu.");
                System.exit(0);
            }

            long z1 = batukaria(zenbakia);
            long z2 = faktoriala(zenbakia);

            if (z1 > 100){
                ehunGehiago++;
            }

            if (zenbakia < 10){
                zenbat10++;
                batazbestekoa = batazbestekoa + zenbakia;
            }

            System.out.println(zenbakia +" zenbakiaren batukaria da: "+z1+" eta faktoriala da: "+z2);

        }

        batazbestekoa = batazbestekoa / zenbat10;
        System.out.println("100 baino gehiagoko batukaria eman duten zenbakien kopurua: "+ehunGehiago);
        System.out.println("Sartu diren zenbakien artean 10 baino txikiagoen batezbestekoa: "+batazbestekoa);

        sc.close();

    }

    public static long batukaria (long z1){
        long batuka =0;
        for (long i = 1;i<z1+1;i++){

            batuka = batuka +i;


        }
        return  batuka;
    }
    public static long faktoriala (long z1){
        long batuka =1;
        for (long i = 1;i<z1+1;i++){

            batuka = batuka *i;


        }
        return  batuka;
    }

    }