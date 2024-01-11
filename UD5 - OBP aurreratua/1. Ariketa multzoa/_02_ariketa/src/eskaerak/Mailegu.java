package eskaerak;

import java.util.Date;
import java.time.LocalDate;


public class Mailegu {

    LocalDate hasieraData;
    LocalDate itzuleraData;

    Mailegu(int urtea, int hilabetea, int eguna){
        hasieraData = LocalDate.of(urtea, hilabetea, eguna);
    }

    public void setItzuleraData(int urtea, int hilabetea, int eguna){
        itzuleraData = LocalDate.of(urtea, hilabetea, eguna);
    }

    public void erakutsi(){
        System.out.println("Mailegu data: "+hasieraData+" Itzulera Data: +"+itzuleraData);
    }

}
