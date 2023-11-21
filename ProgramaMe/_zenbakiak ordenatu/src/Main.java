public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");

        //Hemen sortu egiten dira bi listak eta bi listen baturalen luzeerarekin lortzen dugu ordenatzeko lista.
        int[] lista = new int[5];
        int[] lista2 = new int[5];
        int[] ordenatzeko = new int[lista.length+lista2.length];

        //Sortu egiten dugu balore bat temporala izango dela.
        int temp =0;

        //Gehitzen ditugu zenbaki aleatorioak bi listetan.
        for (int i =0;i<lista.length;i++){
            lista[i]=(int)(Math.random()*10);
            lista2[i]=(int)(Math.random()*10);
        }

        //Hemen elkartzen ditugu bi listak ordenatzeko listan.
        for(int i =0;i< ordenatzeko.length/2;i++){
            ordenatzeko[i]=lista[i];
            ordenatzeko[i+ ordenatzeko.length/2]=lista2[i];
        }
        //Hemen imprimatzen dugu lista ikusteko ea ongi batu egin diren.
        listaImprimatu(lista);
        listaImprimatu(lista2);
        listaImprimatu(ordenatzeko);

        //Hemen ordenatzen ditugu zenbakiak
        //Hemen pasatzen gara zenbaki guztietatik.
        for (int i =0;i< ordenatzeko.length;i++){
            //Hemen berriro ere pasatzen gara zenbaki guztietatik.
            for (int e =i; e< ordenatzeko.length;e++){
                //Hemen begiratzen dugu ea dagoen zenbakia urrengoa baina handiagoa den, handiagoa bada, lekuz aldatzen dira.
                if (ordenatzeko[i]>ordenatzeko[e]){
                    temp = ordenatzeko[i];
                    ordenatzeko[i]=ordenatzeko[e];
                    ordenatzeko[e]=temp;
                }
            }
        }

        listaImprimatu(ordenatzeko);





    }

    public static void listaImprimatu(int[]lista){
        for (int i =0;i<lista.length;i++){
            if (i == lista.length-1){
                System.out.println(lista[i]);
            }else {
                System.out.print(lista[i]+" - ");
            }
        }
    }
}