public class Dado {


    private int azkZenbakia = 0;
    private int jaurtiketaKop = 0;

    Dado(){

    }

    public void jaurti(){
        this.azkZenbakia=(int) (Math.random()*6+1);
        jaurtiketaKop++;
    }

    public int getAzkZenbakia(){
        return azkZenbakia;
    }

    public void erakutsi(){
        System.out.println("--------------------------------");
        System.out.println("Azkeneko zenbakia: "+azkZenbakia);
        System.out.println("Jaurtiketa kopurua: "+jaurtiketaKop);
        System.out.println("--------------------------------");

    }

}
