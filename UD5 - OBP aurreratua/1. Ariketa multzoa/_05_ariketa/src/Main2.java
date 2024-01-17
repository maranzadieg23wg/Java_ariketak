import enpresa.Enpresa;
import enpresa.Langile;
import enpresa.Mugikor;

public class Main2 {
    public static void main(String[] args) {


        Mugikor m1 = new Mugikor("qwerty", 100);
        Langile l1 = new Langile("Patxi", "12345678R", 175, 85, 0, m1);

        Mugikor m2 = new Mugikor("poiuyt", 100);
        Langile l2 = new Langile("Imanol", "87654321T", 160, 55, 0, m2);


        Enpresa e1 = new Enpresa("Patxi S.L.", 0, l1, l2);
        System.out.println(e1.toString());

        e1.lana();
        System.out.println(e1.toString());

    }
}