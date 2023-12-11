public class ZuzenaProba {
    public static void main(String[] args) {

        //Puntuak sortzen
        Puntua p1 = new Puntua(1,2);
        Puntua p2 = new Puntua(-1, 2);

        Puntua p3 = new Puntua(1,-2);
        Puntua p4 = new Puntua(-1, -2);

        //Lehenengo zuzena sortzen
        Zuzena z1 = new Zuzena(3, p1);
        //Zuzenari gehitzen bigarren puntu bat
        z1.bigarrenPuntua(p2);

        //Bigarren zuzena sortzen
        Zuzena z2 = new Zuzena(5, p3);
        //Zuzenari gehitzen bigarren puntu bat
        z2.bigarrenPuntua(p4);



        System.out.println("Horizontala da: "+z1.horizontalaDa());
        System.out.println("Bertikala da: "+z1.bertikalaDa());

        System.out.println("Puntu altuenta: "+z1.altuena());

        System.out.println("Luzeera: "+z1.getLuzera());


        System.out.println("Luzeena: "+z1.luzeena(z2));


        z1.erakutsiZuzena();



    }
}