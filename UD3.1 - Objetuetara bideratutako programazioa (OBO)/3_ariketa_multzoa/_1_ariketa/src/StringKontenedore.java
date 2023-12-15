public class StringKontenedore {
    private String karakterea;
    private int aldaketa;

    public StringKontenedore(String karakterea){
        this.karakterea=karakterea;
        this.aldaketa =0;
    }
    public StringKontenedore(){
        this.karakterea="";
        this.aldaketa =0;
    }

    public int getAldaketa(){
        return aldaketa;
    }

    public boolean berdinaDa(StringKontenedore stringKontenedore){
        return this.karakterea.equals(stringKontenedore.karakterea);
    }


}
