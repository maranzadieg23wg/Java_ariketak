import java.util.ArrayList;
import  java.util.Collections;
import java.util.Iterator;

public class PuntuSistema {

    private ArrayList<Puntua> puntuList = new ArrayList<>();

    public PuntuSistema(ArrayList<Puntua> puntuList) {
        this.puntuList = puntuList;
    }

    public PuntuSistema(Puntua puntua){
        this.puntuList.add(puntua);
    }


    public void erakutsi(){
        for (Puntua puntua : puntuList){
            System.out.print(puntua+" ");
        }
        System.out.println(" ");
    }

    public ArrayList alderantzizkatu(){

        ArrayList<Puntua> it = puntuList;
        Collections.reverse(it);
        return it;

    }

    public Puntua bigarrenKoadrantean(){
        Iterator<Puntua> it = this.puntuList.iterator();

        int i =0;
        while (it.hasNext()){

            if (puntuList.get(i) != null){
                Puntua puntua = puntuList.get(i);
                if (puntua.koadrantea() ==2){
                    return puntua;
                }else {
                    i++;
                }
            }else {
                i++;
            }

        }
        return null;


    }

    public int zeroZero(){
        Iterator<Puntua> it = this.puntuList.iterator();

        int i =0;
        while (it.hasNext()){

            if (puntuList.get(i) != null){
                Puntua puntua = puntuList.get(i);
                if (puntua.getzX() ==0 && puntua.getzY()==0){
                    return i;
                }else {
                    i++;
                }
            }else {
                i++;
            }

        }
        System.out.println("Ez dago punturik daukana 0,0 posizioa");
        return -1;
    }

    public boolean batBatDago(){
        Iterator<Puntua> it = this.puntuList.iterator();

        int i =0;
        while (it.hasNext()){

            if (puntuList.get(i) != null){
                Puntua puntua = puntuList.get(i);
                if (puntua.getzX() ==1 && puntua.getzY()==1){
                    return true;
                }else {
                    i++;
                }
            }else {
                i++;
            }

        }
        //System.out.println("Ez dago punturik daukana 1,1 posizioa");
        return false;
    }

    public void ezabatuDistantzia10(){
        Iterator<Puntua> it = this.puntuList.iterator();
        while (it.hasNext()){
            Puntua puntua = it.next();

            int x = puntua.getzX();
            int y = puntua.getzY();

            double z = (x*x)+(y*y);

            z = Math.pow(z, 0.5);

            if (z <10){
                puntuList.remove(puntua);
                break;
            }

        }
    }

    public void ezabatu4Koadrantea(){
        Iterator<Puntua> it = this.puntuList.iterator();

        while (it.hasNext()){
            Puntua puntua = it.next();

            if (puntua.koadrantea() == 4){
                puntuList.remove(puntua);
            }
        }
    }




}
