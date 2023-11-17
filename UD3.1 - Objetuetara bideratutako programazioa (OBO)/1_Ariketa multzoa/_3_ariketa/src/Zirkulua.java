public class Zirkulua {

    String kolorea;

    int erradioa;

    Zirkulua(String kolorea, int erradioa){

        this.kolorea = kolorea;

        this.erradioa = erradioa;
    }

    public void azalera(){
        System.out.println("Azalera da: "+3.14151692*erradioa*erradioa);
    }

    public  void perimetroa(){
        System.out.println("Perimetroa da: "+2*3.14151692*erradioa);
    }

    public void handiaDa(){
        double azalera = 3.14151692*erradioa*erradioa;

        if (azalera>20){
            System.out.println("Zirkulua handia da.");
        }else {
            System.out.println("Zirkulua txikia da.");
        }
    }

    public void berdinaDa(){}

    public void erakutsi(){
        System.out.println("Zirkuluaren kolorea da: "+kolorea);

        System.out.println("Zirkuluaren erradioa da: "+erradioa);
    }

}
