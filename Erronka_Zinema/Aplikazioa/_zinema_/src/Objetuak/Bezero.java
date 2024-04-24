package Objetuak;



/**
 * Erabiltzen da sortzeko Bezero objetua, honekin autentifikatu egiten da eta lortu daitezke
 * ikusitako pelikulak
 * @author Manex Aranzadi Egaña
 * */

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

    /**
     * Lortzeko erabiltzailea ID-a eta honekin, eskaerak egin datu baseari*/
    public int getIdErabiltzailea() {
        return idErabiltzailea;
    }

    public String getErabiltzaileIzena() {
        return erabiltzaileIzena;
    }
}
