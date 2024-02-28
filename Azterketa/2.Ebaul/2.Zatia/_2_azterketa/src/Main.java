import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Streamer s1 = new Streamer("Juja", "2000/01/01");
        Streamer s2 = new Streamer("Ibai", "2000/01/01");
        Streamer s3 = new Streamer("Axoxer", "2000/01/01");

        Streamer s4 = new Streamer("Aligeitor", "2000/01/01");
        Streamer s5 = new Streamer("Illojuan", "2000/01/01");






        s1.gehituBideojokoa("Kenshi");
        for (int i =0;i<15;i++){
            s1.gehituBideojokoa("WoW"+i);
        }




        s2.gehituBideojokoa("LoL");
        s3.gehituBideojokoa("WoW");


        System.out.println(s1.toString());

        StreamerKomunitate k = new StreamerKomunitate();


        ArrayList<Streamer>youtube = new ArrayList<>();
        youtube.add(s1);
        youtube.add(s2);
        k.gehituStreamerak("Youtube", youtube);

        ArrayList<Streamer>twitch = new ArrayList<>();
        twitch.add(s3);
        twitch.add(s4);
        twitch.add(s5);
        k.gehituStreamerak("twitch", twitch);


        ArrayList<Streamer> a = k.aLetrakoStreamerak();
        for (Streamer st:a) {
            System.out.println(st);
        }

        ArrayList<Streamer> jokoa = k.jolastenDute("WoW");
        for (Streamer st:jokoa) {
            System.out.println(st);
        }

        System.out.println("--------------------------------");
        k.erakutsi();


    }
}