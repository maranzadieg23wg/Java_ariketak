public class Partida {
    public static void main(String[] args) {


        Jokalari j1 = new Jokalari("Manolo");
        Jokalari j2 = new Jokalari("Patxi");
        Jokalari j3 = new Jokalari("Begoña");


        int [] puntuak = new int[3];

        int [] sei = new int[3];


        for (int i =0;i<6;i++){
            //Dadoa jaurtitzen du
            j1.jaurti();
            j2.jaurti();
            j3.jaurti();

            //Jaurtiketen zenbakia lortu eta batu
            puntuak[0]+= j1.getAzkZenbakia();
            puntuak[1]+= j2.getAzkZenbakia();
            puntuak[2]+= j3.getAzkZenbakia();

            //Ikusten dugu 6 ateratzen bada, +1 egiten da.
            if (j1.getAzkZenbakia()==6){
                sei[0]++;
            }
            if (j2.getAzkZenbakia()==6){
                sei[1]++;
            }
            if (j3.getAzkZenbakia()==6){
                sei[2]++;
            }

        }

        //Jakiteko zeinek daukan zenbaki altuena
        //Ordenatzen ditu zenbakiak
        int puntuakOrdenatuta= max(puntuak);

        //Ikusten dugu zeinek irabazi egin duen konparatzen listako lehenengo zenbakia puntuak listan dauden zenbakiekin.
        System.out.println("--------------------------------");
        System.out.println("PUNTU GEHIEN: ");

        if (puntuak[0]==puntuakOrdenatuta){
            System.out.println("Irabazlea da: "+j1.getIzena());
            System.out.println("Puntuak: "+puntuak[0]);
        }else if (puntuak[1]==puntuakOrdenatuta){
            System.out.println("Irabazlea da: "+j2.getIzena());
            System.out.println("Puntuak: "+puntuak[1]);
        }else {
            System.out.println("Irabazlea da: " + j3.getIzena());
            System.out.println("Puntuak: " + puntuak[2]);
        }


        int seiMax = max(sei);
        System.out.println("--------------------------------");
        System.out.println("SEI GEHIENEZ ATERATA: ");

        if (sei[0]==seiMax){
            System.out.println("Irabazlea da: "+j1.getIzena());
            System.out.println("Sei zenbat aldiz atera da: "+seiMax);
        }
        if (sei[1]==seiMax){
            System.out.println("Irabazlea da: "+j2.getIzena());
            System.out.println("Sei zenbat aldiz atera da: "+seiMax);
        }
        if (sei[2]==seiMax){
            System.out.println("Irabazlea da: " + j3.getIzena());
            System.out.println("Sei zenbat aldiz atera da: "+seiMax);
        }














    }

    public static int[] listaOrdenatu(int[]lista){
        for (int i =0;i<lista.length-1;i++){
            for (int e=0;e< lista.length-1-i;e++){

                if (lista[e] > lista[e + 1]) {
                    int temp = lista[e];
                    lista[e] = lista[e + 1];
                    lista[e + 1] = temp;
                }
            }
        }

        return lista;
    }

    public static int max(int[]lista){
        int seiMax =0;
        for (int i =0;i<lista.length-1;i++){
            if (seiMax<lista[i]){
                seiMax=lista[i];
            }
        }
        return seiMax;
    }



}