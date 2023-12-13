public class KontuKorronte {


    int id;
    String izena;
    float dirua;

    KontuKorronte (int id,String izena){

        this.id=id;
        this.izena=izena;

        this.dirua=0;
    }

    KontuKorronte(int id,String izena, float dirua){

        this.id=id;
        this.izena=izena;

        this.dirua=dirua;
    }


    public void diruGordailua(float gehituDirua){

        this.dirua+=gehituDirua;
    }

    public void diruaKendu(float kenduDirua){

        this.dirua-=kenduDirua;
    }

    public void erakutsiKontua(){
        System.out.println("Izena: "+izena);
        System.out.println("Dirua: "+dirua);
    }


}
