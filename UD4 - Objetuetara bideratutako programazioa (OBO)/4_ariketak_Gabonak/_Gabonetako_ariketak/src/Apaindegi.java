import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Apaindegi {



    private Object bezeroList[];
    private Object bisitaList[];

    private int bezeroKant;
    private int bisitaKant;


    Apaindegi(int luzeeraBezero, int luzeeraBisita){

        bezeroList = new Object[luzeeraBezero]; //←Esartzen zaio bezero listari zein den bere luzeera.
        bisitaList = new Object[luzeeraBisita]; //←Esartzen zaio bisita listari zein den bere luzeera.
        bezeroKant =0; //←Esaten diogu objetua sortzen denean 0 bezero dituela.
        bisitaKant =0; //←Esaten diogu objetua sortzen denean 0 bisita dituela.
    }

    public void bajaEman(Bezero bezero){ //←Funtzio honekin baja hematen diogu bezero bateri. Horretarako bezero objetua jaso behar du.
        bezero.setBazkide(false); //←Bidaltzen zaio setBazkideari 'false' balorea, esateko ez dela bazkidea.
    }

    public void esleituBazkideMaila(Bezero bezero, String maila){ //←Hemen ezartzen da bazkidearen maila.
        if (maila.equals("Premium") || maila.equals("Urre")|| maila.equals("Zilar")){ //←Begiratzen dugu ea sartutako maila ezistitzen den a la ez.
            bezero.setMaila(maila); //←Ezistitzen bada, maila ezartzen zaio.
        }else {
            System.out.println("[-] Sartutako maila ez da ezistitzen"); //←Bestela ez du ezer egiten eta errore mezu bat inprimatzen du.
            System.out.println("[-] Premium -- Urre -- Zilar"); //←Eta baita ere inprimatzen du dauden mailen izena.
        }
    }

    public Bezero jasoBezeroa(String NAN){ //←Hemen bilatzen dugu bezero bat, horretarako, NAN-a erabiltzen dugu.
        for (int i =0;i<bezeroList.length;i++){
            Bezero bezero = (Bezero) bezeroList[i]; //←Ateratzen dugu bezero listatikan bezero objetua.
            if (bezero != null &&NAN.equals(bezero.getNAN())){ //←Begiratzen dugu ea posizio horretan dagoen objetua ez den 'null' eta sartutako NAN-a den bezeroaren NAN berbera.
                return (Bezero) bezeroList[i]; //←Berbera bada, bueltatzen dugu listako objetua.
            }
        }

        return null; //←Berbera ez bada, bueltatzen du 'null' objetua
        //return "Ez da aurkitu "+NAN+" NANa daukagun bezeroa.";
    }

    //Bisitak lortzen ditugu honekin
    public Bisita jasoBisita(String NAN, int urtea, int hilabetea, int eguna){ //←Bilatzen dugu bisita konkretu bat, horretarako bezeroaren NAN-a erabiltzen da, eta bisitaren data.
        Date data = new Date(urtea-1900, hilabetea-1, eguna);
        for (int i =0;i<bisitaList.length;i++){
            Bisita bisita = (Bisita) bisitaList[i]; //←i posizioan dagoen bisita objetua ateratzen dugu.
            Bezero bezero = bisita.getBezero(); //←Bisita objetua dagoen bezero objetua lortzen dugu.
            if (bisita != null && bezero.getNAN().equals(NAN) && bisita.getData().equals(data)){ //←Begiratzen dugu ea posizioa ez den 'null', gero konprobatzen dugu honen NAN-a den eskatu dugun berberarena eta azkenik konprobatzen da data.
                return (Bisita) bisitaList[i]; //←Guztia betetzen badu, bueltatzen du bisita objetua.
            }
        }

        return null; //←Bestela bueltatzen du 'null' objetua.

    }

    public void gehituBezeroa(String izena, String NAN){ //←Bezero bat sortzen erabiltzen da, eta sartzen du bezero listan automatikoki.
        Bezero bezero = new Bezero(izena, NAN);
        bezeroList[bezeroKant]= bezero; //←Sartzen du bezeroa bezeroListan.
        bezeroKant++; //←Bezero kantitateari gehitzen dio posizio bat.
    }
    public void gehituBezeroa(String izena, String NAN, String maila){ //←Goiko gauza bera, baina kasu honetan sortzen du bezeroa maila batekin.
        Bezero bezero = new Bezero(izena, NAN);
        esleituBazkideMaila(bezero, maila); //←Bidaltzen diogu maila funtzio honeri eta konprobatzen du ea esleitutako maila egokia den a la ez.
        bezeroList[bezeroKant]= bezero;
        bezeroKant++;
    }

    public void gehituBisita(Bezero bezero, int urtea, int hilabetea, int eguna){ //←Bisita bat sortu egiten du.
        Date date1= new Date( urtea-1900,  hilabetea-1,  eguna);
        Bisita bisita = new Bisita(bezero, date1); //Bisita bat sortzen da guk ezarritako egunean eta honekin batera, sartutako bezeroa ere bai gehitzen diogu.
        bisitaList[bisitaKant]= bisita;
        //System.out.println("Bisita: "+bisitaKant+ "Lista: "+bisitaList[bisitaKant]);
        bisitaKant++; //← Bisita kopurua kontrolatzeko funtzioari gehitzen diogu zenbaki bat.
    }

    public ArrayList jasoBisitak(Bezero bezero){ //←Bueltatzen du bezero batek eduki dituen bisita guztiak.

        Object listaBisita []= new Object [bisitaKant]; //←Sortzen dugu lista daukana bisita kantitarean tamaina.
        int kant =0; //←Ondoren ezartzen diogu zenbat bisita dauden bezero honenak, ez garenez hasi, 0 ditu.

        for (int i =0;i<bisitaKant;i++){
            Bisita bisita = (Bisita) bisitaList[i]; //←Lortzen ditugu bisita listatikan bisita objetua
            Bezero bezero1 = bisita.getBezero(); //←Bisitatikan lortzen dugu bezero objetua.
            if (bezero.getNAN().equals(bezero1.getNAN())){
                listaBisita[kant]= bisitaList[i]; //←Hemen gehitzen dugu
                kant++;
            }
        }
        return (ArrayList) listaBisita[kant]; //←Hemen bueltatu egiten dugu lista

    }

    public void erakutsiBezeroak(){ //←Bezero guztien datu guztiak erakusten ditu.
        for (int i =0;i<bezeroList.length;i++){
            /*Bisita bisita = (Bisita) bisitaList[i];
            Bezero bezero = bisita.getBezero();
            System.out.println(bezero.toString());*/
            if (bezeroList[i]!=null){ //←Begiratzen du lista guztia, null ez diren baloreak.
                System.out.print(i+1+". "); //←Esaten digu zenbagarren bezeroa den, batetikan hasita.
                System.out.println(bezeroList[i]); //←Hemen inprimatzen dugu informazioa.
            }
        }
    }

    public void erakutsiBisitak(){ //←Bisiten datu guztiak erakusten ditu.
        for (int i =0;i<bisitaList.length;i++){
            /*
            Bisita bisita = (Bisita) bisitaList[i];
            System.out.println(bisita.toString());*/
            if (bisitaList[i]!=null){ //←Begiratzen du lista guztia, null ez diren baloreak.
                System.out.print(i+1+". "); //←Esaten digu zenbagarren bisita den, batetikan hasita.
                System.out.println(bisitaList[i]); //←Hemen inprimatzen dugu informazioa.
            }
        }
    }



    public void gehituZenbatekoa(Bezero bezero, int urtea, int hilabeta, int eguna, float zenbatekoa){ //←Gehitzen diogu zenbatekoa bisita bateri
        String NAN = bezero.getNAN(); //←Lortzen dugu bezeroaren objetua.
        Date data = new Date(urtea-1900, hilabeta-1, eguna);

        for (int i =0;i<bisitaKant;i++){
            Bisita bisita = (Bisita) bisitaList[i]; //←Bisita listatikan lortzen dugu bisita objetua
            Bezero bezero1 = bisita.getBezero(); //←Bisita objetutikan lortzen dugu bezero objetua
            String NAN1 = bezero1.getNAN(); //←Lortzen dugu bisita objetuko bezeroaren NAN-a

            if (NAN.equals(NAN1) && data.equals(bisita.getData())){ //←Begiratzen dugu ea NAN-a berbera den eta bi datak berberak diren
                bisita.kalkulatuZenbatekoa(zenbatekoa); //←Zenbatekoa bidaltzen diogu bisita objetuko kalkulatze zenbateko funtzioari.
                i = bisitaKant; //← For a bukatzen dugu honen bitartez.
            }
        }
    }






}
