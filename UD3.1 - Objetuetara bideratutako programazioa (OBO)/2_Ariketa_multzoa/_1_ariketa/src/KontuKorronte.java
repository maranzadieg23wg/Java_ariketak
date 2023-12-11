public class KontuKorronte {


    String izena;
    float dirua;

    KontuKorronte (String izena){
        this.izena=izena;

        this.dirua=0;
    }

    KontuKorronte(String izena, float dirua){
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
