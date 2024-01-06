import java.time.LocalDate;

public class Bisita {

    private Bezero bezero;
    private double zenbat =0;
    private java.time.LocalDate data;

    Bisita(Bezero bezero, LocalDate data){
        this.bezero = bezero;
        this.data = data;
    }

    public double kalkulatuZenbatekoa(float zenbat){

        this.zenbat = zenbat-(zenbat * bezero.jasoDeskontua()); //←eskatzen diogu bezero objetuari zein den bere deskontua, ondoren biderkatzen dugu prezioarekin jakiteko zenbat kendu behar zaion eta kentzen diogu.
        return this.zenbat;

    }

    public String toString(){

        return bezero.toString()+"Zenbat: "+zenbat+" -- Data: "+data; //←Bueltatzen du bezeroaren datuak erabiltzen toString funtzioa eta honekin batera zenbat gastatu egin duen egun horretan eta zein egunetan
    }


    public Bezero getBezero(){
        return bezero; //←Daukan bezero objetua bueltatzen du, horrela, bertatikan lortu egin daiteke bezeroak dituen datuak.
    }

    public java.time.LocalDate getData(){
        return data; //←Bueltatzen du bisitaren data.
    }


}
