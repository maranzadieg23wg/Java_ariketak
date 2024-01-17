public class Kanario extends Txori {


    private float tamaina;

    public Kanario(char sexua, int adina) {
        super(sexua, adina);
    }
    public Kanario(char sexua, int adina, float tamaina) {
        super(sexua, adina);
        this.tamaina=tamaina;
    }

    void neurtu(){
        if (tamaina>30){
            System.out.println("Handia");
        } else if (tamaina<15) {
            System.out.println("Txikia");
        }else {
            System.out.println("Hertaina");
        }
    }

    void setTamaina(float tamaina){
        this.tamaina = tamaina;
    }
}
