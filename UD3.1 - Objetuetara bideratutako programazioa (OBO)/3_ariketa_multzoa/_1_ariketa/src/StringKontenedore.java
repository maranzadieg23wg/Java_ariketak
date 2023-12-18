public class StringKontenedore {
    private String karakterea;
    private int aldaketa;

    private Palindromo palindromo;

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


    public boolean palindromoaDa(){
        String zuriuneGabe = karakterea.replace(" ","");
        this.palindromo = new Palindromo(zuriuneGabe);
        return this.palindromo.palindromoaDa();
    }

    public String mugituEzkerrera(int zenbat, String aldatu){
        String aldatuta ="";
        for (int i =zenbat;i<this.karakterea.length();i++){

            String temp = String.valueOf(this.karakterea.charAt(i));
            aldatuta +=temp;


        }
        for (int e =0;e<zenbat;e++){
            aldatuta +=aldatu;
        }

        aldaketa++;
        return aldatuta;
    }




}
