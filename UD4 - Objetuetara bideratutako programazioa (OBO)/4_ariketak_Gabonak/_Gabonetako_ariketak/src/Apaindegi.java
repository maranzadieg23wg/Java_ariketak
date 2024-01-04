import java.util.ArrayList;

public class Apaindegi {

    private int luzeeraBezero;
    private int luzeeraBisita;

    private Object bezeroList[];
    private Object bisitaList[];

    private int bezeroKant;
    private int bisitaKant;


    Apaindegi(int luzeeraBezero, int luzeeraBisita){

        this.luzeeraBezero = luzeeraBezero;
        this.luzeeraBisita = luzeeraBisita;
        bezeroList = new Object[luzeeraBezero];
        bisitaList = new Object[luzeeraBisita];
        bezeroKant =0;
        bisitaKant =0;
    }

    public void bajaEman(Bezero bezero){
        bezero.setBazkide(false);
    }

    public void esleituBazkideMaila(Bezero bezero, String maila){
        if (maila.equals("Premium") || maila.equals("Urre")|| maila.equals("Zilar")){
            bezero.setMaila(maila);
        }else {
            System.out.println("[-] Sartutako maila ez da ezistitzen");
            System.out.println("[-] Premium -- Urre -- Zilar");
        }
    }

    public Bezero jasoBezeroa(String NAN){
        for (int i =0;i<bezeroList.length;i++){
            Bezero bezero = (Bezero) bezeroList[i];
            if (bezero != null &&NAN.equals(bezero.getNAN())){
                return (Bezero) bezeroList[i];
            }
        }

        return null;
        //return "Ez da aurkitu "+NAN+" NANa daukagun bezeroa.";
    }

    //Bisitak lortzen ditugu honekin
    public Bisita jasoBisita(String NAN, LocalDate data){
        for (int i =0;i<bisitaList.length;i++){
            Bisita bisita = (Bisita) bisitaList[i];
            Bezero bezero = bisita.getBezero();
            if (bisita != null &&bezero.getNAN().equals(NAN)&&bisita.getData().equals(data)){
                return (Bisita) bisitaList[i];
            }
        }

        return null;
        //return "Ez da aurkitu "+NAN+" NANa daukagun bezeroa.";
    }

    public void gehituBezeroa(String izena, String NAN){
        Bezero bezero = new Bezero(izena, NAN);
        bezeroList[bezeroKant]= bezero;
        bezeroKant++;
    }

    public void gehituBisita(Bezero bezero, java.time.LocalDate data){
        Bisita bisita = new Bisita(bezero, data);
        bisitaList[bisitaKant]= bisita;
        //System.out.println("Bisita: "+bisitaKant+ "Lista: "+bisitaList[bisitaKant]);
        bisitaKant++;
    }

    public ArrayList jasoBisitak(Bezero bezero){

        Object listaBisita []= new Object [bisitaKant];
        int kant =0;

        for (int i =0;i<bisitaKant;i++){
            Bisita bisita = (Bisita) bisitaList[i];
            if (bisita.getBezero().equals(bezero)){
                listaBisita[kant]= bisitaList[i];
                kant++;
            }
        }
        return (ArrayList) listaBisita[kant];
    }

    public void erakutsiBezeroak(){
        for (int i =0;i<bisitaList.length;i++){
            Bezero bezero = (Bezero) bisitaList[i];
            System.out.println(bezero.toString());
        }
    }

    public void erakutsiBisitak(){
        for (int i =0;i<bisitaList.length;i++){
            Bisita bisita = (Bisita) bisitaList[i];
            System.out.println(bisita.toString());
        }
    }






}
