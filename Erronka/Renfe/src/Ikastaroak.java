import java.util.ArrayList;
import java.util.List;

public class Ikastaroak {
    
    List<Object> kurtsoLista;


    Ikastaroak(){
        kurtsoLista = new ArrayList<>();
    }

    public void ikastaroEgoera(String DNI, int idIkastaroa){
        for (int i = kurtsoLista.size() - 1; i >= 0; i -= 5) {
            if (kurtsoLista.get(i - 4).equals(idIkastaroa) && kurtsoLista.get(i - 3).equals(DNI)) {
               System.out.println("DNI: "+DNI);
               System.out.println("Ikastaro ID: "+idIkastaroa);
               System.out.println("Ikastaroaren egoera: "+kurtsoLista.get(i));
            }
        }


    }

    public void gehituIkastaroak(int idIkastaroa, String DNI, int hasieraData, int bukeraData, String egoera){

        kurtsoLista.add(idIkastaroa);
        kurtsoLista.add(DNI);
        kurtsoLista.add(hasieraData);
        kurtsoLista.add(bukeraData);
        kurtsoLista.add(egoera);


    }

    public  void  borratuIkastaroak(int idIkastaroa, String DNI){
        for (int i = kurtsoLista.size() - 1; i >= 0; i -= 5) {
            if (kurtsoLista.get(i - 4).equals(idIkastaroa) && kurtsoLista.get(i - 3).equals(DNI)) {
                kurtsoLista.subList(i - 4, i + 1).clear();
            }
        }

    }





}
