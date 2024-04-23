package Objetuak;

import java.util.ArrayList;
import java.util.Objects;

public class Argazkilari {

    private int ID;
    private String izena;
    public int saritua;
    private ArrayList<Argazkia> list;

    public Argazkilari(int ID, String izena, int saritua) {
        this.ID = ID;
        this.izena = izena;
        this.saritua = saritua;
        list = new ArrayList<>();
    }

    public void gehituArgazki(Argazkia argazki){

        if (!argazkiaDauka(argazki)){
            list.add(argazki);
        }
    }

    boolean argazkiaDauka(Argazkia argazkia){
        for(Argazkia arg: list){
            if (arg.equals(argazkia)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Argazkilari that = (Argazkilari) o;
        return ID == that.ID && Objects.equals(izena, that.izena) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, izena, list);
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Argazkilari{" +
                "ID=" + ID +
                ", izena='" + izena + '\'' +
                ", saritua=" + saritua +
                ", list=" + list +
                '}';
    }
}
