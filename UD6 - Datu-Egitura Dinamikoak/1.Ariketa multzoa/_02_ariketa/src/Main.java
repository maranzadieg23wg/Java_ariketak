import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {




        Puntua p1 = new Puntua(1, 2);
        Puntua p2 = new Puntua(-1, 2);
        Puntua p3 = new Puntua(-1, -2);
        Puntua p4 = new Puntua(1, -2);

        p1.inprimatuPuntua();
        p2.inprimatuPuntua();
        p3.inprimatuPuntua();
        p4.inprimatuPuntua();

        System.out.println("P3-ren koadrantea da: "+p3.koadrantea());

        ArrayList<Puntua> puntuList = new ArrayList<>();

        puntuList.add(p1);
        puntuList.add(p2);
        puntuList.add(p3);

        PuntuSistema ps = new PuntuSistema(puntuList);

        ps.erakutsi();








    }
}