public class Zatiki {

    private int zatikizuna;
    private int zatitzailea;

    public Zatiki() {
        this.zatikizuna = 1;
        this.zatitzailea =1;
    }

    public Zatiki(int zatikizuna, int zatitzailea) {
        this.zatikizuna = zatikizuna;
        this.zatitzailea = zatitzailea;
    }

    public String toString(){
        return zatikizuna +" / "+zatitzailea;
    }

    Zatiki batu(Zatiki zatiki){
        int zatikizuna1 = zatiki.getZatikizuna();
        int zatitzailea1 = zatiki.getZatitzailea();

        int era1 = zatikizuna1 * this.zatitzailea;
        int era2 = zatikizuna * zatitzailea1;
        int behekoa = zatitzailea1*zatitzailea;

        int guztira = era1+era2;

        int sinpli = sinplifikatu(era1, era2);

        guztira = guztira /sinpli;
        behekoa = behekoa /sinpli;

        return new Zatiki(guztira, behekoa);


        //System.out.println(era1/sinpli +" / "+era2/sinpli);
    }

    Zatiki kendu(Zatiki zatiki){
        int zatikizuna1 = zatiki.getZatikizuna();
        int zatitzailea1 = zatiki.getZatitzailea();

        int era1 = zatikizuna1 * this.zatitzailea;
        int era2 = zatikizuna * zatitzailea1;
        int behekoa = zatitzailea1*zatitzailea;

        int guztira = era1-era2;

        int sinpli = sinplifikatu(era1, era2);

        guztira = guztira /sinpli;
        behekoa = behekoa /sinpli;

        return new Zatiki(guztira, behekoa);


        //System.out.println(era1/sinpli +" / "+era2/sinpli);
    }

    Zatiki bider(Zatiki zatiki){

        int zatikizuna1 = zatiki.getZatikizuna();
        int zatitzailea1 = zatiki.getZatitzailea();

        int goiko = zatikizuna1 * this.zatikizuna;
        int behekoa = zatitzailea1*zatitzailea;


        int sinpli = sinplifikatu(goiko, behekoa);

        goiko = goiko /sinpli;
        behekoa = behekoa /sinpli;

        return new Zatiki(goiko, behekoa);


        //System.out.println(era1/sinpli +" / "+era2/sinpli);
    }

    Zatiki zati(Zatiki zatiki){

        int zatikizuna1 = zatiki.getZatikizuna();
        int zatitzailea1 = zatiki.getZatitzailea();

        int goiko = zatikizuna * zatitzailea1;
        int behekoa = zatikizuna1*zatitzailea;


        int sinpli = sinplifikatu(goiko, behekoa);

        goiko = goiko /sinpli;
        behekoa = behekoa /sinpli;

        return new Zatiki(goiko, behekoa);


        //System.out.println(era1/sinpli +" / "+era2/sinpli);
    }

    int sinplifikatu(int era1, int era2){

        //System.out.println(era1 + " / "+era2);
            while (era1 != 0){


                if (era2 !=0){
                    int temp =  era1 % era2;
                    //System.out.println("Temp: "+temp +" = "+era1+" / "+era2);
                    era1 = era2;
                    era2 = temp;
                }else {
                    if (era1<0){
                        return era1*-1;

                    }else {
                        return era1;
                    }

                }


            }
            return era1;

    }


    public int getZatikizuna() {
        return zatikizuna;
    }

    public int getZatitzailea() {
        return zatitzailea;
    }
}
