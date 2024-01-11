import  elementuak.*;
import  eskaerak.*;
public class Main {
    public static void main(String[] args) {

        Liburu l1 = new Liburu(1, "Cuentos de terramar", "Ursula K.", 150);

        Bezero b1 = new Bezero("12345678T", "Patxi");

        Mailegu m1 = new Mailegu(2024,1,11, l1);

        b1.gehituMailegu(m1);
        b1.gehituMailegu(m1);
        b1.gehituMailegu(m1);
        b1.gehituMailegu(m1);
        b1.gehituMailegu(m1);
        //b1.gehituMailegu(m1);
        b1.erakutsi();


        b1.kenduMailegu(m1);

        b1.erakutsi();

        b1.gehituMailegu(m1);
        b1.gehituMailegu(m1);
        b1.erakutsi();


    }
}