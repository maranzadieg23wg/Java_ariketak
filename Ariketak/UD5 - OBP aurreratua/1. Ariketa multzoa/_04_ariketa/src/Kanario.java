public class Kanario extends Txori {


    private float tamaina;

    public Kanario(char sexua, int adina, DatuPertsonal izenak) {
        super(sexua, adina, izenak);
    }




    public Kanario(char sexua, int adina, float tamaina, DatuPertsonal izenak) {
        super(sexua, adina, izenak);
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

    void abestu() {}

}
