package Objetuak;

public class Pelikulak {

    int IDPelikula;
    String tituloa;
    String generoa;
    long irabaziak;
    long aurrekontua;
    String trailera;
    String irudia;
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
                ", idEstrenaldia=" + idEstrenaldia +
                ", idZuzendaria=" + idZuzendaria +
                '}';
    }
}
