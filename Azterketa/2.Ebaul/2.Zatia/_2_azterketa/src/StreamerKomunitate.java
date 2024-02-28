import java.util.ArrayList;
import java.util.HashMap;

public class StreamerKomunitate {

    private HashMap<String, ArrayList<Streamer>> lista;

    StreamerKomunitate() {
        this.lista = new HashMap<>();
    }

    void gehituStreamerak(String plataforma, ArrayList<Streamer>streamerak){

        try {
            if (lista.containsKey(plataforma)){
                throw new Exception(plataforma+" dagoeneko listan dago");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        lista.put(plataforma, streamerak);


    }

    ArrayList<Streamer> aLetrakoStreamerak(){

        ArrayList<Streamer> list = new ArrayList<>();

        for (String plat:lista.keySet()) {
            ArrayList<Streamer> temp = new ArrayList<>();

            temp = lista.get(plat);
            for (Streamer st:temp) {
                if (st.getIzena().startsWith("a") || st.getIzena().startsWith("A")){
                    list.add(st);
                }
            }
        }
        return list;


    }

    ArrayList<Streamer> jolastenDute(String game){
        ArrayList<Streamer> list = new ArrayList<>();

        for (String plat:lista.keySet()) {
            ArrayList<Streamer> temp = new ArrayList<>();

            temp = lista.get(plat);
            for (Streamer st:temp) {

                String []jokoak = st.getBideojoak();

                for (int i =0;i< jokoak.length;i++){
                    if (jokoak[i] != null &&jokoak[i].equals(game)){
                        list.add(st);
                        i = jokoak.length+2;
                    }
                }

            }
        }
        return list;
    }

    void erakutsi(){

        for (String plat:lista.keySet()) {
            ArrayList<Streamer> temp = new ArrayList<>();

            System.out.println(plat+": ");
            temp = lista.get(plat);
            for (Streamer st:temp) {

                System.out.println(st.toString());

            }
        }

    }



}
