package langileak;

public class KomisioLangile extends Langile{
    float salmentak;
    float komisioa;


    KomisioLangile(String izena, String abizena, int gsz, float salmentak, float komisioa){
        super(izena, abizena, gsz);
        this.salmentak = salmentak;
        this.komisioa = komisioa;

        if (this.salmentak <0){
            salmentak =0;
        }
        if (this.komisioa >0 && this.komisioa < 1){
            this.komisioa =0;
        }
    }

    public double irabaziak(){
        return this.salmentak*this.komisioa;
    }

    public String toString(){
        return super.toString()+ " Salmentak: "+salmentak+" Komisioa: "+komisioa;
    }

}
