package elementuak;

public class Disko extends Elementu {

    String diskografia;

    Disko (int kodea, String izenburua, String egilea, String diskografia){
        super(kodea, izenburua, egilea);
        this.diskografia = diskografia;
    }
}
