package eskaerak;

import elementuak.Elementu;

import java.util.Date;
import java.time.LocalDate;


public class Mailegu {

    LocalDate hasieraData;
    LocalDate itzuleraData;
    Elementu elementu;

    public Mailegu(int urtea, int hilabetea, int eguna, Elementu elementu){
        hasieraData = LocalDate.of(urtea, hilabetea, eguna);
        itzuleraData = null;
        this.elementu = elementu;
    }

    public void setItzuleraData(int urtea, int hilabetea, int eguna){
        itzuleraData = LocalDate.of(urtea, hilabetea, eguna);
    }

    public Elementu getElementu(){
        return elementu;
    }



    public void erakutsi(){
        System.out.println("-----------------------------------------");
        if (itzuleraData !=null){
            System.out.println("Mailegu data: "+hasieraData+" Itzulera Data: "+itzuleraData+ " Elementua: "+elementu.getErakutsi());
        }else {
            System.out.println("Mailegu data: "+hasieraData+" Ez da itzuli "+ " Elementua: "+elementu.getErakutsi());

        }
    }

}
