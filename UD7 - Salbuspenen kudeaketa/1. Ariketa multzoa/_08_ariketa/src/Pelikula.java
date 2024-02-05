import java.util.Objects;

public class Pelikula {

    private String izenburua;
    private int urtea;
    private int iraupena; //← minututan

    public Pelikula(String izenburua, int urtea, int iraupena)throws PelikulaSalbuespena {

        if (izenburua == null || izenburua.equals("")){
            throw new PelikulaSalbuespena("Pelikula batek ezin du ez izan izenik");
        }

        if (zenbakiaDa(String.valueOf(iraupena))){
            iraupena=Integer.parseInt(String.valueOf(iraupena));
        }else {
            throw new PelikulaSalbuespena("Pelikula baten iraupena ezin da izan letra bat");
        }

        if (zenbakiaDa(String.valueOf(urtea))){
            urtea=Integer.parseInt(String.valueOf(urtea));

        }else {
            throw new PelikulaSalbuespena("Pelikula batek urtea ezin da izan letra bat");
        }

        if (urtea<1900){
            //System.out.println("111111111111111111"+izenburua);
            throw new PelikulaSalbuespena("Pelikula baten urtea ezin da 1900 baino lehenagokoa izan");
        }else {
            //System.out.println("22222222222222222222222222"+izenburua);
        }

        if (iraupena<=0){
            throw new PelikulaSalbuespena("Pelikula baten iraupena ezin da 0 baino txikiagoa izan");
        }


        this.izenburua = izenburua;
        this.urtea = urtea;
        this.iraupena = iraupena;


    }

    public String toString() {
        return "Izenburua: "+izenburua+" Urtea: "+urtea+ " Iraupena: "+iraupena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelikula pelikula = (Pelikula) o;
        return urtea == pelikula.urtea && this.iraupena <= pelikula.iraupena+5 && Objects.equals(izenburua, pelikula.izenburua);
    }

    public String getIzenburua() {
        return izenburua;
    }

    public int getUrtea() {
        return urtea;
    }

    public int getIraupena() {
        return iraupena;
    }

    boolean zenbakiaDa (String zenbakia){
        boolean erantzuna;

        try {
            Integer.parseInt(zenbakia);
            erantzuna = true;
        } catch (NumberFormatException excepcion) {
            erantzuna = false;
        }

        return erantzuna;
    }
}
