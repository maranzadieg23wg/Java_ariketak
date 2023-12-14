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

    public int jasoBalioa(){
        //System.out.println("Zenbakia: "+);
        return this.d1.getAzkZenbakia();
    }

    public int getAzkZenbakia(){
        return this.d1.getAzkZenbakia();
    }
    public String getIzena(){
        return this.izena;
    }

    public void erakutsi(){
        System.out.println("--------------------------------");
        System.out.println("Izena: "+izena);
        this.d1.erakutsi();
    }


}
