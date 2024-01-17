package enpresa;

public class Mugikor {

    private String zenbakia;
    int bateria;

    public Mugikor(String zenbakia, int bateria) {
        this.zenbakia = zenbakia;
        this.bateria = bateria;
    }

    public  void erabili(int zenbat){
        this.bateria -= zenbat;
    }
}
