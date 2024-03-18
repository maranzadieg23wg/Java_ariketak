public class Main {
    public static void main(String[] args) {

        System.out.println("TRIPLES PITAGÓRICOS");


        int zenbat = 500;

        int z1 = 0;
        int z2 = 0;
        int z3 = 0;

        for (int i = 1;i<zenbat+1;i++){
            z1 +=3;
            z2 +=4;
            z3 +=5;

            System.out.println(i+": "+z1+", "+z2+", "+z3);
        }


    }
}