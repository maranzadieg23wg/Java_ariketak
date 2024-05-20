package Objetuak.DB;

/**
 * Objetu honen bitartez, lortzen dugu jakitea zein nota heman dion bezero batek pelikula konkretu bateri
 * @author Manex Aranzadi Egaña
 */
public class IkusitakoLista {

    Bezero bezero;
    Pelikulak pelikula;
    int ikusita;
    float nota;
    int ikus_kop;


    public IkusitakoLista(Bezero bezero, Pelikulak pelikula, int ikusita, float nota, int ikus_kop) {
        this.bezero = bezero;
        this.pelikula = pelikula;
        this.ikusita = ikusita;
        this.nota = nota;
        this.ikus_kop = ikus_kop;
    }

    public IkusitakoLista() {

    }

    @Override
    public String toString() {
        return "IkusitakoLista{" +
                "pelikula=" + pelikula +
                ", ikusita=" + ikusita +
                ", nota=" + nota +
                ", ikus_kop=" + ikus_kop +
                '}';
    }

    public int getIkusita() {
        return ikusita;
    }

    public float getNota() {
        return nota;
    }

    public int getIkus_kop() {
        return ikus_kop;
    }

    public Pelikulak getPelikula() {
        return pelikula;
    }
}
