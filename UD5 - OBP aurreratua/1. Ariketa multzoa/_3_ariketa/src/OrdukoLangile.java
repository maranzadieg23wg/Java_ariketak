public class OrdukoLangile extends Langile{

    int orduak;
    float tarifa;

    OrdukoLangile(String izena, String abizena, int gsz, int orduak, float tarifa){
        super(izena, abizena, gsz);
        this.orduak = orduak;
        this.tarifa = tarifa;


        if (orduak<0){
            this.orduak =0;
        }
        if (tarifa<0){
            this.tarifa =0;
        }
    }


    public double irabaziak(){
        if (orduak <40){
            return orduak*tarifa;
        }else {
            return orduak*(tarifa*1.5);
        }

    }

    public String toString(){
        return super.toString()+" Orduak: "+orduak+" Tarifak: "+tarifa;
    }

}
