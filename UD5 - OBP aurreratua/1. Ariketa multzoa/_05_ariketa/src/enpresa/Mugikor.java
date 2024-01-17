package enpresa;

public class Mugikor {

    private String zenbakia;
    private int bateria;

    public Mugikor(String zenbakia, int bateria) {
        this.zenbakia = zenbakia;
        this.bateria = bateria;
    }

    public  void erabili(){
        this.bateria -= 1;
    }

    public int getBateria(){
        return bateria;
    }
}
