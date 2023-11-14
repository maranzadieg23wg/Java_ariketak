public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        int zenbatekoa =3;
        boolean simetrikoa = false;

        int [][]matrizea = new int[zenbatekoa][zenbatekoa];


        for (int i =0; i<zenbatekoa;i++){
            for (int e =0;e<zenbatekoa;e++){

                matrizea[i][e]=(int)(Math.random()*9);
                //matrizea[i][e]=1;

            }
        }

        for (int i =0; i<zenbatekoa;i++){
            for (int e =0;e<zenbatekoa;e++){
                if (matrizea[i][e] != matrizea[e][i] && !simetrikoa){
                    simetrikoa = true;
                }
            }
        }

       /* for (int i =0;i<lista.length;i++){
            System.out.println(lista[lista.length-1-i]);
        }*/

        if (!simetrikoa){
            System.out.println("Simetrikoa da.");
        }else {
            System.out.println("Ez da simetrikoa da.");

        }


        System.out.println("Matrizea");
        for (int i =0; i<zenbatekoa;i++){
            for (int e =0;e<zenbatekoa;e++){

                System.out.print(matrizea[i][e]+" ");

            }
            System.out.println(" ");
        }







    }
}