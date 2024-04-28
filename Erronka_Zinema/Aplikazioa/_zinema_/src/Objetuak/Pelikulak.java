package Objetuak;

import java.util.Objects;

/**
 * Erabiltzen da pelikula bat jasotzen denean datu basetikan, hemen dauden datuekin betetzen da.
 * @author Manex Aranzadi Egaña
 */

public class Pelikulak {

    int IDPelikula;
    String tituloa;
    String generoa;
    long irabaziak;
    long aurrekontua;
    String trailera;
    String irudia;
    String irudiaLokalki;
    int idEstrenaldia;
    int idZuzendaria;


    public Pelikulak(int IDPelikula, String tituloa, String generoa, long irabaziak, long aurrekontua, String trailera, String irudia, int idEstrenaldia, int idZuzendaria) {
        this.IDPelikula = IDPelikula;
        this.tituloa = tituloa;
        this.generoa = generoa;
        this.irabaziak = irabaziak;
        this.aurrekontua = aurrekontua;
        this.trailera = trailera;
        this.irudia = irudia;
        this.idEstrenaldia = idEstrenaldia;
        this.idZuzendaria = idZuzendaria;
    }

    @Override
    public String toString() {
        return "Pelikulak{" +
                "IDPelikula=" + IDPelikula +
                ", tituloa='" + tituloa + '\'' +
                ", generoa='" + generoa + '\'' +
                ", irabaziak=" + irabaziak +
                ", aurrekontua=" + aurrekontua +
                ", trailera='" + trailera + '\'' +
                ", irudia='" + irudia + '\'' +
                ", irudiaLokalki='" + irudiaLokalki + '\'' +
                ", idEstrenaldia=" + idEstrenaldia +
                ", idZuzendaria=" + idZuzendaria +
                '}';
    }

    /**
     * Lokalean zein karpetan eta zein izenarekin ezartzeko balio du*/
    public void setirudiaLokalki(String irudiaLokalki) {
        this.irudiaLokalki = irudiaLokalki;
    }

    /**
     * Lortzen dugu non gorde egin den lokalki.
     * Irudiak ./img/pelikulak karpetan gorde egiten dira*/
    public String getIrudiaLokalki() {
        return irudiaLokalki;
    }

    /**
     * Online nun dagoen gordeta irudia bueltatzen du.*/

    public String getIrudia() {
        return irudia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelikulak pelikulak = (Pelikulak) o;
        return IDPelikula == pelikulak.IDPelikula && irabaziak == pelikulak.irabaziak && aurrekontua == pelikulak.aurrekontua && idEstrenaldia == pelikulak.idEstrenaldia && idZuzendaria == pelikulak.idZuzendaria && Objects.equals(tituloa, pelikulak.tituloa) && Objects.equals(generoa, pelikulak.generoa) && Objects.equals(trailera, pelikulak.trailera) && Objects.equals(irudia, pelikulak.irudia) && Objects.equals(irudiaLokalki, pelikulak.irudiaLokalki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDPelikula, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, irudiaLokalki, idEstrenaldia, idZuzendaria);
    }
}
