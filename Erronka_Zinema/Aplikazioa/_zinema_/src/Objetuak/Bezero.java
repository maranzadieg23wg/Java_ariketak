package Objetuak;


import java.util.Objects;

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

    public String getIzena() {
        return izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public String getEmaila() {
        return emaila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bezero bezero = (Bezero) o;
        return idErabiltzailea == bezero.idErabiltzailea && Objects.equals(izena, bezero.izena) && Objects.equals(abizena, bezero.abizena) && Objects.equals(emaila, bezero.emaila) && Objects.equals(erabiltzaileIzena, bezero.erabiltzaileIzena) && Objects.equals(pasahitza, bezero.pasahitza) && Objects.equals(ikusitakoLista, bezero.ikusitakoLista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idErabiltzailea, izena, abizena, emaila, erabiltzaileIzena, pasahitza, ikusitakoLista);
    }
}
