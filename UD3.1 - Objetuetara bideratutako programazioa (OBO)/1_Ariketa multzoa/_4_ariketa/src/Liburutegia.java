public class Liburutegia {



    //int zenbakia;



    Liburutegia(int zenbakia){
        //this.zenbakia = zenbakia;
    }


    public void bikoitiaDa(int zenbakia){

        boolean bikoiti = false;

        if (zenbakia%2 ==0){
            bikoiti=true;
        }

        if (bikoiti){
            System.out.println("Sartutako zenbakia bikoitia da.");
        }else {
            System.out.println("Sartutako zenbakia ez bikoitia da.");
        }


    }

    public void digituKopurua(int zenbakia){
        int zenbat = (int)(Math.log10(zenbakia)+1);
    }




}
