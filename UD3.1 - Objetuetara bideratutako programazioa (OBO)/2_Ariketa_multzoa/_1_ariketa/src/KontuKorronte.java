public class KontuKorronte {


    int id;
    Pertsona pertsona;
    float dirua;
    boolean zenbakiGorrian;


    public KontuKorronte (Pertsona pertsona){

        this.pertsona=pertsona;

        this.dirua=0;
        this.zenbakiGorrian =false;

    }

    public KontuKorronte(Pertsona pertsona, float dirua){


        this.pertsona=pertsona;

        this.dirua=dirua;

        if (this.dirua<0){
            this.zenbakiGorrian=true;
        }else {
            this.zenbakiGorrian=true;
        }
    }


    public void diruGordailua(float gehituDirua){

        this.dirua+=gehituDirua;

        if (this.dirua<0){
            this.zenbakiGorrian=true;
        }else {
            this.zenbakiGorrian=true;
        }
    }

    public void diruaKendu(float kenduDirua){

        this.dirua-=kenduDirua;

        if (this.dirua<0){
            this.zenbakiGorrian=true;
        }else {
            this.zenbakiGorrian=true;
        }
    }

    public void erakutsiKontua(){
        System.out.println("----------------------------------");
        System.out.println("Izena: "+pertsona.getIzena());
        System.out.println("Nan: "+pertsona.getDNI());
        System.out.println("Adina: "+pertsona.getAdina());

        System.out.println("Dirua: "+dirua);
        System.out.println("Zenbaki gorritan "+zenbakiGorrian);
        System.out.println("----------------------------------");

    }


}
