public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        int zenbatekoa =3;


        int [][]matrizea = new int[zenbatekoa][zenbatekoa];

        int []lista=new int[zenbatekoa];

        for (int i =0; i<zenbatekoa;i++){
            for (int e =0;e<zenbatekoa;e++){

                matrizea[i][e]=(int)(Math.random()*9);

            }
        }

        for (int i =0; i<zenbatekoa;i++){
            for (int e =0;e<zenbatekoa;e++){
                if (i-e == 0){
                    lista[i]=matrizea[i][e];
                    //System.out.println(matrizea[i][e]);
                }
            }
        }

        for (int i =0;i<lista.length;i++){
            System.out.println(lista[lista.length-1-i]);
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