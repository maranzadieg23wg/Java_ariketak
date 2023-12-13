public class KontuKorronte {


    int id;
    Pertsona pertsona;
    float dirua;

    public KontuKorronte (int id,Pertsona pertsona){

        this.id=id;
        this.pertsona=pertsona;

        this.dirua=0;
    }

    public KontuKorronte(int id, Pertsona pertsona, float dirua){

        this.id=id;
        this.pertsona=pertsona;

        this.dirua=dirua;
    }


    public void diruGordailua(float gehituDirua){

        this.dirua+=gehituDirua;
    }

    public void diruaKendu(float kenduDirua){

        this.dirua-=kenduDirua;
    }

    public void erakutsiKontua(){
        System.out.println("Izena: "+pertsona.getIzena());
        System.out.println("Nan: "+pertsona.getDNI());
        System.out.println("Adina: "+pertsona.getAdina());

        System.out.println("Dirua: "+dirua);
    }


}
