import enpresa.Langile;
import enpresa.Mugikor;

public class Main {
    public static void main(String[] args) {

        Mugikor m1 = new Mugikor("qwerty", 100);
        Langile l1 = new Langile("Patxi", "12345678R", 175, 85, 0, m1);

        l1.lanEgin();
        System.out.println(l1.toString());

    }
}