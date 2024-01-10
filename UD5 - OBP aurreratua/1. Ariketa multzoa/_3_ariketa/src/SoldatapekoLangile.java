public class SoldatapekoLangile extends Langile{
    private float astekoSoldata;

    SoldatapekoLangile(String izena, String abizena, int gsz, float astekoSoldata){
        super(izena, abizena, gsz);
        this.astekoSoldata = astekoSoldata;

        if (this.astekoSoldata <0){
            this.astekoSoldata =0;
        }


    }
    public double irabaziak(){
        return astekoSoldata;
    }

    public String toString(){
        return super.toString()+" Asteko Soldata: "+astekoSoldata;
    }
}
