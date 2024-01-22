import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {




        Puntua p1 = new Puntua(1, 2);
        Puntua p2 = new Puntua(-1, 2);
        Puntua p3 = new Puntua(-1, -2);
        Puntua p4 = new Puntua(1, -2);
        Puntua p5 = new Puntua(2, -10);



        ArrayList<Puntua> puntuList = new ArrayList<>();

        puntuList.add(p1);
        puntuList.add(p2);
        puntuList.add(p3);
        puntuList.add(p4);
        puntuList.add(p5);

        PuntuSistema ps = new PuntuSistema(puntuList);

        ps.erakutsi();
        ps.ezabatuDistantzia10();
        ps.erakutsi();

        ArrayList<Puntua> alderantziz = ps.alderantzizkatu();

        for (Puntua puntua : alderantziz){
            System.out.print(puntua+" ");
        }









    }
}