package Objetuak;

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

    @Override
    public String toString() {
        return "IkusitakoLista{" +
                "pelikula=" + pelikula +
                ", ikusita=" + ikusita +
                ", nota=" + nota +
                ", ikus_kop=" + ikus_kop +
                '}';
    }
}
