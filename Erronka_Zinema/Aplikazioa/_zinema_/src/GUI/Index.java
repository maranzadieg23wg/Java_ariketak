package GUI;
import DatuBase.Konexioa;
import Objetuak.Aktoreak;
import Objetuak.Bezero;
import Objetuak.IrudiakDeskargatu;
import Objetuak.Pelikulak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

public class Index {

    private int x;
    private int y;
    private String izena;


    private JFrame frame;
    private JPanel menua, menua2, pelikulak, aktoreak, peliTitul, aktoreTitul;
    private JPanel aukera1, aukera2;
    private JButton buttonLogin, buttonSingUp, botoiak;
    private JTextField bilatu;
    private JList<String> aukerak;

    private String[] lista;

    private HashMap <JLabel, Pelikulak> pelikulaList;
    private HashMap <JLabel, Aktoreak> aktoreList;

    private CardLayout menuLista;

    private String izn;
    JLabel peliLabel;


    private Bezero bezero;


    public Index(int x, int y, String izena) throws SQLException {
        this.x = x;
        this.y = y;
        this.izena = izena;

        lista = new String[]{"Pelikulak", "aktoreak", "zuzendariak", "laguntza", "myList"};

        pelikulaList = new HashMap<>();
        aktoreList = new HashMap<>();


        this.bezero = null;


        sortuLehoia();
        menua();
        menua2();
        pelikulak();
        aktoreak();



        erakutsi(); //← Azkeneko gauza egin behar dena

    }

    void sortuLehoia(){
        frame = new JFrame(izena);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi() {
        frame.setLayout(new BorderLayout());

        JPanel menuak = new JPanel(); //← Kontenedore bat sortzen dugu
        menuak.setLayout(new BoxLayout(menuak, BoxLayout.Y_AXIS));

        menuak.add(menua);
        menuak.add(menua2);


        JPanel erdi = new JPanel();
        erdi.setLayout(new BoxLayout(erdi, BoxLayout.Y_AXIS));

        erdi.add(peliTitul);
        erdi.add(pelikulak);
        erdi.add(aktoreTitul);
        erdi.add(aktoreak);
        //erdi.add(aktoreTitul);
        //erdi.add(aktoreak);

        frame.add(menuak, BorderLayout.NORTH);

        frame.add(erdi, BorderLayout.CENTER);
        //frame.add(centerPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }



    void menua(){



        menua = new JPanel();


        aukera1 = new JPanel();
        aukera2 = new JPanel();

        //GridLayout gridLayout = new GridLayout(1, 4);

        //menua.setLayout(gridLayout);

        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


        String izena = "Enigma";
        JLabel label = new JLabel(izena);

        menua.add(label);



        menua.add(zuriaZatia(800));


        //↓Botoiak
        buttonLogin = new JButton("Login");
        buttonSingUp = new JButton("SingUp");

        buttonLogin.setPreferredSize(new Dimension(80, 30));
        buttonSingUp.setPreferredSize(new Dimension(80, 30));



        buttonLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    logetu();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        buttonSingUp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    kontuaSortu();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });



        aukera1.add(buttonLogin);
        aukera1.add(buttonSingUp);


        //System.out.println(this.bezero.getErabiltzaileIzena());
        JPanel bezIzena = new JPanel();

        izn = "proba";
        if (bezero !=null){
            izn = this.bezero.getErabiltzaileIzena();
        }

        peliLabel = new JLabel(izn);

        bezIzena.add(peliLabel);

        aukera2.add(bezIzena);


        aukera1.setVisible(true);
        aukera2.setVisible(false);

        menua.add(aukera1);
        menua.add(aukera2);


        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait



    }

    void menua2(){

        menua2 = new JPanel();

        //GridLayout gridLayout = new GridLayout(1, lista.length+2+2+1);

        //menua2.setLayout(gridLayout);


        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait

        for (int i =0;i< lista.length;i++){
            String b = lista[i];
            botoiak = new JButton(b);

            menua2.add(botoiak);
        }

        menua2.add(zuriaZatia(450));

        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait

        Choice aukerak = new Choice();
        for (int i =0;i< lista.length;i++){
            String b = lista[i];


            aukerak.add(b);
        }
        menua2.add(aukerak);

        bilatu = new JTextField("Search");
        bilatu.setPreferredSize(new Dimension(250, 30));
        menua2.add(bilatu);


        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


    }


    void pelikulak() throws SQLException {

        peliTitul = new JPanel();
        pelikulak = new JPanel();

        int peliKop = 7;

        

        //↓ Gehitzeko pelikulak textua
        String peli = "Pelikulak";
        JLabel peliLabel = new JLabel(peli);

        peliTitul.add(peliLabel);

        pelikulak.add(peliTitul);


        //GridLayout gridLayout = new GridLayout(4, aktoreKop+2+1);

        //erdikoa.setLayout(gridLayout);

        pelikulak.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait




        for (int i =0;i<peliKop;i++){


            Pelikulak pel = pelikulaAleatorio();
            JLabel irudia = irudiak(pel.getIrudiaLokalki(), 130, 200);
            if (pelikulaList.containsKey(irudia)){
                System.out.println(i);
                i--;
            }else {
                irudia.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        pelikulaAukeratuta(e);

                    }
                });

                pelikulak.add(irudia); //← Nola sortu irudiak

                pelikulaList.put(irudia, pel);
            }






        }



        pelikulak.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait




    }

    void aktoreak() throws SQLException {

        aktoreTitul = new JPanel();
        aktoreak = new JPanel();

        int aktoKop = 7;



        //↓ Gehitzeko pelikulak textua
        String akto = "Aktoreak";
        JLabel aktoLabel = new JLabel(akto);

        aktoreTitul.add(aktoLabel);

        aktoreak.add(aktoreTitul);


        //GridLayout gridLayout = new GridLayout(4, aktoreKop+2+1);

        //erdikoa.setLayout(gridLayout);

        aktoreak.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait




        for (int i =0;i<aktoKop;i++){


            Aktoreak akt = aktoreAleatorio();
            //System.out.println(akt.getIrudiaLokalki());
            JLabel irudia = irudiak(akt.getIrudiaLokalki(), 130, 200);
            if (aktoreList.containsKey(irudia)){
                System.out.println(i);
                i--;
            }else {
                irudia.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        aktoreaAukeratu(e);

                    }
                });

                aktoreak.add(irudia); //← Nola sortu irudiak

                aktoreList.put(irudia, akt);
            }



        }



        aktoreak.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait




    }

    JLabel irudiak(String url, int x, int y){
        ImageIcon originalIcon = new ImageIcon(url);

        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon thedark = new ImageIcon(img1);

        JLabel label = new JLabel();
        label.setIcon(thedark);
        return label;
    }

    Pelikulak pelikulaAleatorio() throws SQLException {
        Konexioa con = new Konexioa();

        Pelikulak pel = con.pelikulaLortu();

        con.konexioaItxi();

        String url = pel.getIrudia();

        IrudiakDeskargatu irudiakDeskargatu = new IrudiakDeskargatu(url,"./irudiak/pelikula");

        pel.setirudiaLokalki(irudiakDeskargatu.getFitxategiarenIzena());


        //System.out.println(pel.getIrudiaLokalki());
        return pel;
    }

    Aktoreak aktoreAleatorio() throws SQLException {
        Konexioa con = new Konexioa();

        Aktoreak akt = con.aktoreaLortu();

        con.konexioaItxi();

        String url = akt.getIrudia();

        IrudiakDeskargatu irudiakDeskargatu = new IrudiakDeskargatu(url,"./irudiak/aktore");

        akt.setirudiaLokalki(irudiakDeskargatu.getFitxategiarenIzena());


        //System.out.println(pel.getIrudiaLokalki());
        return akt;
    }

    void pelikulaAukeratuta(MouseEvent e){
        Pelikulak pel = pelikulaList.get(e.getSource());
        System.out.println(pel);
    }

    void aktoreaAukeratu(MouseEvent e){
        Aktoreak akto = aktoreList.get(e.getSource());
        System.out.println(akto);
    }

    JLabel zuriaZatia (int luzeera){
        JLabel zuria = new JLabel();
        zuria.setPreferredSize(new Dimension(luzeera, 30));

        return zuria;
    }


    void logetu() throws SQLException {

        this.bezero = SaioaHasi.saioaHasi();



        izn = bezero.getErabiltzaileIzena();
        peliLabel.setText(izn);
        aukera1.setVisible(false);
        aukera2.setVisible(true);
        menua();


    }

    void kontuaSortu() throws SQLException {

        this.bezero = KontuaSortu.kontuaSortu();

        menua();

    }
}
