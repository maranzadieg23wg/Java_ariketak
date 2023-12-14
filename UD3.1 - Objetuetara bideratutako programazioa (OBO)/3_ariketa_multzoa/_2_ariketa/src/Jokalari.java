public class Jokalari {

    private String izena;
    private  Dado d1;


    public Jokalari(String izena){
        this.izena=izena;
        this.d1 =new Dado();
    }

    public void jaurti() {
        this.d1.jaurti();
    }

    public void jasoBalioa(){
        System.out.println("Zenbakia: "+this.d1.getAzkZenbakia());
    }


}
