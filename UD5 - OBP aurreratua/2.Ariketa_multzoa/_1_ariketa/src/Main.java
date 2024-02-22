public class Main {
    public static void main(String[] args) {



        CD cd = new CD(100);
        DVD dvd = new DVD(200);
        SSD ssd = new SSD(1000);
        Binilo binilo = new Binilo(50);
        Frisbee frisbee = new Frisbee();

        cd.biratu();
        dvd.biratu();
        binilo.biratu();
        frisbee.biratu();

        cd.grabatu(100);
        ssd.grabatu(1001);










    }
}