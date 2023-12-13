import java.util.ArrayList;
import java.util.List;
public class Banku {


    String izena;

    List<KontuKorronte> kontuKorronteLista;

    Banku(String izena){
        this.izena=izena;

        kontuKorronteLista = new ArrayList<>();

    }

    public void gehituKontuKorronte(KontuKorronte korrontea){
        kontuKorronteLista.add(korrontea);
    }

    public void kenduKontuKorronte(KontuKorronte korrontea){
        kontuKorronteLista.remove(korrontea);
    }

    public void ikusiKontuKorronte(KontuKorronte korrontea){
        korrontea.erakutsiKontua();
    }




}
