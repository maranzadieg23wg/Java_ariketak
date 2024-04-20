package Objetuak;

public class Bezero {

    int idErabiltzailea;
    String izena;
    String abizena;
    String emaila;
    String erabiltzaileIzena;
    String pasahitza;
    IkusitakoLista ikusitakoLista;

    public Bezero(int idErabiltzailea, String izena, String abizena, String emaila, String erabiltzaileIzena) {
        this.idErabiltzailea = idErabiltzailea;
        this.izena = izena;
        this.abizena = abizena;
        this.emaila = emaila;
        this.erabiltzaileIzena = erabiltzaileIzena;


    }

    public int getIdErabiltzailea() {
        return idErabiltzailea;
    }
}
