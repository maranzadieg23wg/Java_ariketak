package langileak;

public class SoldatapekoKomisioLangile extends KomisioLangile{


    float oinarrizkoSoldata;

    SoldatapekoKomisioLangile(String izena, String abizena, int sgz, float salmenta,float komisioa, float oinarrizkoSoldata){
        super(izena, abizena,sgz,salmenta,komisioa);
        this.oinarrizkoSoldata = oinarrizkoSoldata;
        if (oinarrizkoSoldata<0){
            oinarrizkoSoldata =0;
        }
    }

    public double irabaziak(){
        return oinarrizkoSoldata+salmentak*komisioa;
    }

    public String toString(){
        return super.toString()+" Oinarrizko Soldata: "+oinarrizkoSoldata;
    }


}
