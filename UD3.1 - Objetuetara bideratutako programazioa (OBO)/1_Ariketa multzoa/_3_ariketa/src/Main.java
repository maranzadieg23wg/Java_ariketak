public class Main {
    public static void main(String[] args) {


        Zirkulua z1 = new Zirkulua("Gorria", 10);
        Zirkulua z2 = new Zirkulua("Berdea", 100);
        Zirkulua z3 = new Zirkulua("Urdina", 20);
        Zirkulua z4 = new Zirkulua("Gorria", 10);


        z1.azalera();

        z2.perimetroa();

        z3.handiaDa();

        if (z1.equals(z4)){
            System.out.println("Bi objetuak berberak dira.");
        }else {
            System.out.println("Bi objetuak desberdinak dira.");

        }

        z4.erakutsi();

    }
}