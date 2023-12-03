public class Bidai {


    int idBidaia;
    int estimazioDenbora;
    int okupazioa;

    int balorazioa;
    int bidaiKopurua;
    float distantzia;
    String helmuga;

    String bidaiMota;

    Bidai(int idBidaia, String  helmuga, int estimazioDenbora, String bidaiMota, float distantzia){

        this.idBidaia =idBidaia;
        this.helmuga=helmuga;
        this.estimazioDenbora=estimazioDenbora;
        this.okupazioa=0;
        this.balorazioa=0;
        this.bidaiKopurua=0;

        this.bidaiMota=bidaiMota;

        this.distantzia=distantzia;
    }

    public int getEstimazioDenbora(){
        return this.estimazioDenbora;
    }

    public int getOkupazioa(){
        return this.okupazioa;
    }

    public int getIdBidaia(){
        return this.idBidaia;
    }

    public void gehituPertsona(){
        okupazioa++;
    }

    public void setBalorazioa(int nota){
        balorazioa+=nota;
    }

    public float getBalorazioa(){
        return this.balorazioa/this.okupazioa;
    }

    public String getBidaiMota(){
        return this.bidaiMota;
    }

    public float getDistantzia(){
        return this.distantzia;
    }







}
