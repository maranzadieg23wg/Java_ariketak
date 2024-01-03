public class Apaindegi {

    private int luzeera;
    private Object bezeroList []= new Object [luzeera];
    private Object bisitaList []= new Object [luzeera];

    private int bezeroKant;
    private int bisitaKant;


    Apaindegi(int luzeera){

        this.luzeera = luzeera;
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
            if (NAN.equals(bezero.getNAN())){
                i = bezeroList.length +2;
                return (Bezero) bezeroList[i];
            }
        }

        return null;
        //return "Ez da aurkitu "+NAN+" NANa daukagun bezeroa.";
    }

    public void gehituBezeroa(Bezero bezero){
        bezeroList[bezeroKant]= bezero;
        bezeroKant++;
    }

    public void gehituBisita(String NAN, java.time.LocalDate data){
        Bisita bisita = new Bisita(jasoBezeroa(NAN), data);
        bisitaList[bisitaKant]= bisita;
        bisitaKant++;
    }

    




}
