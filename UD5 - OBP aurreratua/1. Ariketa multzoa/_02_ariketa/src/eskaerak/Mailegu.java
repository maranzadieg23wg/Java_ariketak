package eskaerak;

import java.util.Date;

public class Mailegu {

    Date hasieraData;
    Date itzuleraData;

    Mailegu(){
        hasieraData = new Date();
    }

    public void setItzuleraData(){
        itzuleraData = new Date();
    }

    public void erakutsi(){
        System.out.println("Mailegu data: "+hasieraData+" Itzulera Data: +"+itzuleraData);
    }

}
