public class Estatistika {


    int zenbakia =0;
    int zenbat =0;


    public Estatistika(int zenbakia){
        this.zenbakia += zenbakia;
        this.zenbat+=1;
    }

    public void zenbatZenbaki(){
        System.out.println("Sartu dira: "+zenbat+" zenbaki.");
    }

    public void media(){
        System.out.println("Sartu diren zenbakien media: "+zenbakia/zenbat);
    }






}
