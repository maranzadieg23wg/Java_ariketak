public class ZuzenaProba {
    public static void main(String[] args) {

        //Puntuak sortzen
        Puntua p1 = new Puntua(1,2);
        Puntua p2 = new Puntua(-1, 2);

        //Lehenengo zuzena sortzen
        Zuzena z1 = new Zuzena(1, p1);
        //Zuzenari gehitzen bigarren puntu bat
        z1.bigarrenPuntua(p2);


        System.out.println(z1.horizontalaDa());
        System.out.println(z1.bertikalaDa());

        System.out.println(z1.altuena());


    }
}