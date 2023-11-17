public class Zirkulua {

    String kolorea;

    int erradioa;

    Zirkulua(String kolorea, int erradioa){

        this.kolorea = kolorea;

        this.erradioa = erradioa;
    }

    public void azalera(){
        System.out.println("Azalera da: "+Math.PI*erradioa*erradioa);
    }

    public  void perimetroa(){
        System.out.println("Perimetroa da: "+2*Math.PI*erradioa);
    }

    public void handiaDa(){
        double azalera = Math.PI*erradioa*erradioa;

        if (azalera>20){
            System.out.println("Zirkulua handia da.");
        }else {
            System.out.println("Zirkulua txikia da.");
        }
    }

    //Ez du funtzionatzen
    public void berdinaDa(Object zirkulua){
        if (this.equals(zirkulua)){
            System.out.println("Bi objetuak berberak dira.");
        }else {
            System.out.println("Bi objetuak desberdinak dira.");
        }

    }

    @Override public boolean equals(Object obje) {
        if (this == obje) {
            return true;
        }

        if (obje == null || this.getClass() != obje.getClass()){
            return false;
        }

        Zirkulua p1 = (Zirkulua)obje;

        //Honekin bakarrik funtzionatu egingo zuken
        return this.kolorea.equals(p1.kolorea) && this.erradioa == p1.erradioa;

    }


    public void erakutsi(){
        System.out.println("Zirkuluaren kolorea da: "+kolorea);

        System.out.println("Zirkuluaren erradioa da: "+erradioa);
    }

}
