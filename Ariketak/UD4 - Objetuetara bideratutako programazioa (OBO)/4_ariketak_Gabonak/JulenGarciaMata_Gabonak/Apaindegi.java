import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Apaindegi {

    Object listabisiten[];
    Object jasobizitak[];
    Object listabezeroa[];

    int bezerokant;
    int zenb=0;
    private Bezero bezero;

    int bizitaKantitatea;
    int bezeroKantitatea;

    Bisita bisita;
    public Apaindegi(int bizitaluzera, int bezeroluzera) {
        this.listabisiten= new Object[bizitaluzera];
        this.listabezeroa= new Object[bezeroluzera];
        this.jasobizitak= new Object[bizitaluzera];
        this.bizitaKantitatea=0;
        this.bezeroKantitatea=0;
    }

    public void bajaEman(){

        bezero.bazkideB=false;
    }

    public void esleituBazkideMaila (String maila){
        if (maila.equals("Premium")){
            bezero.bazkideS="Premium";
        } else if (maila.equals("Urre")) {
            bezero.bazkideS="Urre";
        } else if (maila.equals("Zilar")) {
            bezero.bazkideS="Zilar";
        }
    }

    public Bezero jasoBezeroa (String NAN){
        for (int a=0; a<listabezeroa.length; a++){
            Bezero datuak= (Bezero) listabezeroa[a];
            if (datuak!=null && NAN.equals(datuak.emanNAN())){
                return (Bezero) listabezeroa[a];
            }
        }
        return null;
    }

    public void gehituBezeroa (String izena, String Nan){
        Bezero bezero = new Bezero(izena, Nan);
        listabezeroa[bezeroKantitatea]=bezero;
        bezeroKantitatea++;
    }

    public void gehituBizita(Bezero bezero, Date date){
        Bisita bizitagehitu= new Bisita(bezero, date);
        listabisiten[bizitaKantitatea]=bizitagehitu;
        bizitaKantitatea++;
    }

    public void jasoBizitak(Bezero bezero){
        Bisita jasobizita []= (Bisita[]) new Object [bizitaKantitatea];
        int zenb=0;

        for (int a=0; a<bizitaKantitatea;a++){
            if (bisita.emanBezero().equals(bezero)){
                jasobizita[zenb]= (Bisita) listabisiten[a];
            }
        }
        System.out.println(Arrays.toString(jasobizita));
    }

    public String erakutsiBezeroak(){
        return Arrays.toString(listabezeroa);
    }

    public String erakutsiBisita(){
        return Arrays.toString(listabisiten);
    }


}
