public class Jokoa {

    private Object[] jokalariak = new Object[10];
    Jokoa(){

    }

    public void gehituJokalaria(Jokalari jokalari){
        for (int i =0;i<jokalariak.length;i++){
            if (jokalariak[i]!=null){
                jokalariak[i]=jokalari;
                i= jokalariak.length+5;
            }
        }
    }

    public int jokalariKop(){
        for (int i =0;i<jokalariak.length;i++){
            if (jokalariak[i]==null){
                return i;
            }

        }
        return 10;
    }


}
