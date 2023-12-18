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

    public String mugituEskubira(int zenbat, String aldatu){
        String aldatuta ="";

        for (int e =0;e<zenbat;e++){
            aldatuta +=aldatu;
        }
        for (int i =0;i<this.karakterea.length()-zenbat;i++){

            String temp = String.valueOf(this.karakterea.charAt(i));
            aldatuta +=temp;
        }


        aldaketa++;
        return aldatuta;
    }

    public String biratu(int zenbat, String norabidea){
        String aldatuta ="";

        switch (norabidea){
            case "R":
                //String-aren azkeneko "zenbat" karaktereak asieran jartzen ditu
                for (int e =karakterea.length()-zenbat;e<karakterea.length();e++){
                    aldatuta +=String.valueOf(this.karakterea.charAt(e));
                }
                //Ondoren gehitzen dio gelditzen diren beste karaktereak, eta azkeneko karaktereak ez dira gehitzen.
                for (int i =0;i<this.karakterea.length()-zenbat;i++){

                    String temp = String.valueOf(this.karakterea.charAt(i));
                    aldatuta +=temp;
                }
                break;
            case "L":

                //Idazten ditu String-aren karaktere guztiak daudenak "zenbatetik" aurrera
                for (int i =zenbat;i<this.karakterea.length();i++){

                    String temp = String.valueOf(this.karakterea.charAt(i));
                    aldatuta +=temp;
                }
                //Hemen geitzen saltatu egin diren karaktereak.
                for (int e =0;e<zenbat;e++){
                    aldatuta +=String.valueOf(this.karakterea.charAt(e));
                }
                break;
            default:
                aldaketa++;
                return this.karakterea;
        }










        aldaketa++;
        return aldatuta;
    }






}
