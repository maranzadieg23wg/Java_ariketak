public class Liburutegia {



    //int zenbakia;



    Liburutegia(){
        //this.zenbakia = zenbakia;
    }


    public void bikoitiaDa(int zenbakia){

        boolean bikoiti = zenbakia % 2 == 0;

        if (bikoiti){
            System.out.println("Sartutako zenbakia bikoitia da.");
        }else {
            System.out.println("Sartutako zenbakia ez bikoitia da.");
        }


    }

    public void digituKopurua(int zenbakia){
        int zenbat = (int)(Math.log10(zenbakia)+1);
        System.out.println(zenbat+" digitu ditu zenbaki honek.");
    }

    public void bostDitu(int zenbakia){
        int zenbat = (int)(Math.log10(zenbakia)+1);

        if (zenbat>=5){
            System.out.println("Zenbaki honek 5 digitu baino gehiago ditu.");

        }else {
            System.out.println("Zenbaki honek ez ditu 5 digitu baino gehiago.");
        }

    }

    public void hamarrenMultiploa(int zenbakia){
        boolean hamartar = zenbakia % 10 == 0;

        if (hamartar){
            System.out.println("Sartutako zenbakia hamarren multiploa da.");
        }else {
            System.out.println("Sartutako zenbakia ez da hamarren multiploa.");
        }
    }




}
