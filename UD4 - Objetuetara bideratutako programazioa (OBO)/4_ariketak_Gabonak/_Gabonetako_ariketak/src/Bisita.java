import java.time.LocalDate;

public class Bisita {

    private Bezero bezero;
    private double zenbat =0;
    private LocalDate data;

    Bisita(Bezero bezero, LocalDate data){
        this.bezero = bezero;
        this.data = data;
    }

    public double kalkulatuZenbatekoa(float zenbat){

        this.zenbat = zenbat-(zenbat * bezero.jasoDeskontua()); //←Eskatzen diogu bezero objetuari zein den bere deskontua, ondoren biderkatzen dugu prezioarekin jakiteko zenbat kendu behar zaion eta kentzen diogu.
        return this.zenbat; //←Bueltatzen diogu zein izango den azkeneko prezioa.

    }

    public String toString(){

        return bezero.toString()+"Zenbat: "+zenbat+" -- Data: "+data; //←Bueltatzen du bezeroaren datuak erabiltzen toString funtzioa eta honekin batera zenbat gastatu egin duen egun horretan eta zein egunetan
    }


    public Bezero getBezero(){
        return bezero; //←Daukan bezero objetua bueltatzen du, horrela, bertatikan lortu egin daiteke bezeroak dituen datuak.
    }

    public LocalDate getData(){
        return data; //←Bueltatzen du bisitaren data.
    }


}
