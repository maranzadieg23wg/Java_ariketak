public class Main {
    public static void main(String[] args) throws ZatikiSalbuespena {




        Zatiki z1 = new Zatiki(2, 0);

        Zatiki z2 = new Zatiki(3, 9);

        Zatiki zB = z1.batu(z2);

        Zatiki zK = z1.kendu(z2);

        Zatiki zBi = z1.bider(z2);

        Zatiki zZ = z1.zati(z2);

        System.out.println(zB.toString());
        System.out.println(zK.toString());
        System.out.println(zBi.toString());
        System.out.println(zZ.toString());


    }
}