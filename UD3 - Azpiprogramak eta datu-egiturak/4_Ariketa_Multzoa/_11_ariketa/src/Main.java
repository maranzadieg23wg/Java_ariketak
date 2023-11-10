import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        /*System.out.println("Sartu matrizearen errenkada kopurua: ");
        int errenkada = sc.nextInt();

        System.out.println("Sartu matrizearen zutabe kopurua: ");
        int zutabe = sc.nextInt();*/

        //pertsona kantitatea
        int errenkada = 10;
        //datu kantitatea -1. adibidez, 4 da horaingoa, 3 datu sartu al dira
        int zutabe = 4;

        float [][] matrizea = new float[errenkada][zutabe];

        String []izenak = new String[errenkada];


        int aukera = 0;

        while (aukera !=4){

            System.out.println("Aukeratu aukera bat: ");
            System.out.println("1. Partaide bat erregistratu");
            System.out.println("2. Datuak erakutsi");
            System.out.println("3. Marka onenak ikusi");
            System.out.println("4. Bukatu programa");

            aukera = sc.nextInt();


            //menu

            switch (aukera){
                case 1:
                    if (zenbatIzen(izenak)<errenkada){

                        int urtea = 2020;

                        System.out.println("Sartu partaidearen izena:");
                        String borratu = sc.nextLine();
                        izenak[zenbatIzen(izenak)]= sc.nextLine();

                        for (int i = 0;i <3;i++){
                            System.out.println("Sartu partaidearen "+(urtea+i)+"ko marka:");
                            matrizea[zenbatIzen(izenak)-1][i+1]=sc.nextFloat();
                        }


                    }else {
                        System.out.println("ERROR: Sartuta daude 10 kirolali, ezin dira gehiago sartu.");

                    }
                    break;
                case 2:

                    datuGuztiak(matrizea, izenak, zutabe);

                    break;
                case 3:

                    markaOnenak(matrizea,izenak, zutabe);

                    break;
                case 4:
                    System.out.println("Programa bukatu da.");

                    //ikusteko matrizea.
                   // inprimatu(matrizea, errenkada, zutabe);
                    break;
                default:
                    System.out.println("ERROR: Sartutako zenbakia ez da aukeretako bat, sartu berriro:");
                    break;
            }

        }

        //zenbakiak gehitzen ditut matrizera
        for (int i = 0;i< errenkada;i++){
            for (int e = 0;e<zutabe;e++){
                matrizea[i][e]=(int)(Math.random()*9);
            }
        }



        /*matrizea inprimatzen du
        System.out.println("Hau da sarrerako matrizea: ");
        inprimatu(matrizea,errenkada,zutabe);*/







        sc.close();

    }

    public static void inprimatu (float [] []matrizea, int errenkada, int zutabe){

        //inprimatzen du matrizea
        //System.out.println("Hau da bukaerako matrizea: ");

        for (int i = 0;i<errenkada;i++){
            for (int e = 0;e<zutabe;e++){
                System.out.print(matrizea[i][e]+"  ");
            }
            System.out.println(" ");
        }

        //return matrizea[1][1];

    }

    public static int zenbatIzen (String [] izenak){

        int zenbat =0;

        for (int i =0;i<izenak.length;i++){
            if (i == izenak.length-1){
                zenbat = izenak.length-1;
            }
            if (izenak[i]==null){
                zenbat = i;
                i = izenak.length;
            }
        }

        return zenbat;
    }

    public static int posizioaIzenak (String [] lista, String izena){

        int posizioa =0;
        boolean aurkituta = false;

        while (!aurkituta){
            if (lista[posizioa].equals(izena)){
                aurkituta = true;
            }
            if (!lista[posizioa].equals(izena)){
                posizioa++;
            }
        }


        return  posizioa;

    }

    public static void datuGuztiak (float [] []matrizea, String []izenak, int zutabe){

        int zenbat = zenbatIzen(izenak);

        System.out.println("********* Datu guztiak *********");

        for (int i= 0;i<zenbat;i++){
            int urtea = 2020;
            System.out.println("Partaidea: "+izenak[i]);

            for (int e = 1;e<zutabe;e++){
                System.out.print("  "+urtea+"ko marka: "+matrizea[i][e]);
                urtea++;
                System.out.println(" ");
            }
        }

        System.out.println("********************************");

    }

    public static void markaOnenak (float [] []matrizea, String []izenak, int zutabea){

        int zenbat = zenbatIzen(izenak);

        float [] lista=new float [zenbat];
        float [] kopia=new float [zenbat];

        System.out.println("********* Marka onenak *********");

        for (int i = 0; i<zenbat;i++){
            lista [i]= zenbakiHandiena(matrizea,i, zutabea);
            kopia [i]= zenbakiHandiena(matrizea,i, zutabea);

            //System.out.println(izenak[i]+" - "+zenbakiHandiena(matrizea,i, zutabea));
        }



        //Arrays.sort(kopia, Collections.reverseOrder());
        Arrays.sort(kopia);


        for (int i = 0; i < zenbat; i++) {
            for (int j = 0; j < zenbat; j++) {
                if (lista[j] == kopia[zenbat - i - 1]) {
                    System.out.println(izenak[j] + " - " + lista[j]);
                }
            }
        }

        System.out.println("********************************");


    }

    public static float zenbakiHandiena (float[][]matrizea, int zenbat, int zutabe){

        float handiena = 0;
        float [] lista = new float[zutabe];
        for (int i=1;i<zutabe;i++){
            lista[i]=matrizea[zenbat][i];

        }
        Arrays.sort(lista);

        handiena = lista[lista.length-1];

        return handiena;
    }
}