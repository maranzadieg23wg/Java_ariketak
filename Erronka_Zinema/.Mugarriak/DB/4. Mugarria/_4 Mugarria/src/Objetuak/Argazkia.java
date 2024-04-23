package Objetuak;

import java.util.Date;
import java.util.Objects;

public class Argazkia {

    private int ID;
    private String izena;
    private Date data;
    private String url;
    private int IDArgazkilari;
    private int bistaratzeKop;

    public Argazkia(int ID, String izena, Date data, String url, int bistaratzeKop, int IDArgazkilari) {
        this.ID = ID;
        this.izena = izena;
        this.data = data;
        this.url = url;
        this.IDArgazkilari = IDArgazkilari;
        this.bistaratzeKop = bistaratzeKop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Argazkia argazkia = (Argazkia) o;
        return ID == argazkia.ID && bistaratzeKop == argazkia.bistaratzeKop && Objects.equals(izena, argazkia.izena) && Objects.equals(data, argazkia.data) && Objects.equals(url, argazkia.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, izena, data, url, bistaratzeKop);
    }

    public int getIDArgazkilari() {
        return IDArgazkilari;
    }


    @Override
    public String toString() {
        return "Argazkia{" +
                "ID=" + ID +
                ", izena='" + izena + '\'' +
                ", data=" + data +
                ", url='" + url + '\'' +
                ", IDArgazkilari=" + IDArgazkilari +
                ", bistaratzeKop=" + bistaratzeKop +
                '}';
    }
}
