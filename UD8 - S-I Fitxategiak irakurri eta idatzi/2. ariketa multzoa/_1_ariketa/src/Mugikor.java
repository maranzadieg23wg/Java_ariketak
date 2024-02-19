import java.io.Serializable;

public class Mugikor implements Serializable {

    private long telefonoa;
    private int bateria;

    public Mugikor(long telefonoa, int bateria) {
        this.telefonoa = telefonoa;
        this.bateria = bateria;
    }

    void erakutsi(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Mugikor{" +
                "telefonoa=" + telefonoa +
                ", bateria=" + bateria +
                '}';
    }

    void kargatu(int bateria){
        setBateria(bateria);
    }

    void deitu(int minutu){
        int bateria = getBateria();

        setBateria(minutu*2-bateria);
    }

    private void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getBateria() {
        return bateria;
    }
}
