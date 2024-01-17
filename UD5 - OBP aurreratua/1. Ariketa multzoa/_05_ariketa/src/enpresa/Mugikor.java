package enpresa;

public class Mugikor {

    private String zenbakia;
    private int bateria;

    public Mugikor(String zenbakia, int bateria) {
        this.zenbakia = zenbakia;
        this.bateria = bateria;
    }

    void erabili(){
        if (this.bateria <0){
            System.out.println("Mugikorrak ez dauka bateriarik.");
        }else {
            this.bateria -= 1;
        }
    }

    int getBateria(){
        return bateria;
    }
}
