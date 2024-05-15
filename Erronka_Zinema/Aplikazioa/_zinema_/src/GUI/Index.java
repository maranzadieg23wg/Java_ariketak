package GUI;
import DatuBase.Konexioa;
import GUI.LogIn.Konfigurazioa;
import GUI.LogIn.KontuaSortu;
import GUI.LogIn.SaioaHasi;
import Objetuak.DB.Aktoreak;
import Objetuak.DB.Bezero;
import Objetuak.IrudiakDeskargatu;
import Objetuak.DB.Pelikulak;
import Objetuak.cookies.Cookie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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


    private String[] lista;

    private HashMap <JLabel, Pelikulak> pelikulaList;
    private HashMap <JLabel, Aktoreak> aktoreList;

    private JPanel erdi;



    Choice menulist;


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


        pelikulak();
        aktoreak();
        menua();
        menua2();
        erakutsi(); //← Azkeneko gauza egin behar dena

    }

    void sortuLehoia(){
        frame = new JFrame(izena);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi() throws SQLException {






        frame.setLayout(new BorderLayout());

        JPanel menuak = new JPanel(); //← Kontenedore bat sortzen dugu
        menuak.setLayout(new BoxLayout(menuak, BoxLayout.Y_AXIS));

        menuak.add(menua);
        menuak.add(menua2);


        erdi = new JPanel();
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



    void menua() throws SQLException {



        menua = new JPanel();


        aukera1 = new JPanel();
        aukera2 = new JPanel();

        //GridLayout gridLayout = new GridLayout(1, 4);

        //menua.setLayout(gridLayout);

        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


        String izena = "Enigma";
        JLabel label = new JLabel(izena);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {


                try {

                    asierara();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });

        menua.add(label);



        menua.add(zuriaZatia(800));


        //↓Botoiak
        buttonLogin = new JButton("Login");
        buttonSingUp = new JButton("SignUp");

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
        /*JPanel bezIzena = new JPanel();

        izn = "";
        if (bezero !=null){
            izn = this.bezero.getErabiltzaileIzena();
        }

        peliLabel = new JLabel(izn);

        bezIzena.add(peliLabel);

        aukera2.add(bezIzena);*/




        aukera1.setVisible(true);
        aukera2.setVisible(false);

        menua.add(aukera1);
        menua.add(aukera2);


        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


        cook();


    }

    void menua2(){

        menua2 = new JPanel();

        //GridLayout gridLayout = new GridLayout(1, lista.length+2+2+1);

        //menua2.setLayout(gridLayout);


        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait

        for (int i =0;i< lista.length;i++){
            String b = lista[i];
            botoiak = new JButton(b);
            botoiak.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JButton j = (JButton) e.getSource();
                    menuBotoiak(j.getText());

                }
            });

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



        for (Pelikulak pel : peliList(peliKop)){

            JLabel irudia = irudiak(pel.getIrudiaLokalki(), 130, 200);
            pelikulaList.put(irudia, pel);
            irudia.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                    pelikulaAukeratuta(e);

                }
            });

            pelikulak.add(irudia); //← Nola sortu irudiak
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


        asieraraAkto(aktoKop, true);

        /*for (Aktoreak akt : aktoList(aktoKop)){

            JLabel irudia = irudiak(akt.getIrudiaLokalki(), 130, 200);
            aktoreList.put(irudia, akt);
            irudia.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    aktoreaAukeratu(e);

                }
            });

            aktoreak.add(irudia); //← Nola sortu irudiak
        }*/



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

    ArrayList<Pelikulak> peliList(int zenbat){

        try {
            Konexioa conn = new Konexioa();

            return conn.pelikulaList(zenbat);
        }catch (SQLException e){
            return null;
        }

    }

    ArrayList<Aktoreak> aktoList(int zenbat){

        try {
            Konexioa conn = new Konexioa();

            return conn.aktoreLortuLista(zenbat);
        }catch (SQLException e){
            return null;
        }

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

        if (this.bezero ==null){
            this.bezero = SaioaHasi.saioaHasi();
        }



        //assert bezero != null;
        if (bezero!=null){
            /*izn = bezero.getErabiltzaileIzena();
            peliLabel.setText(izn);*/


            saioMenua();

            aukera1.setVisible(false);
            aukera2.setVisible(true);
            //menua();
        }


    }

    void kontuaSortu() throws SQLException {

        this.bezero = KontuaSortu.kontuaSortu();

        if (bezero !=null){
        menua();
        }

    }

    void cook() throws SQLException {
        bezero = Cookie.saioCookie();

        if (bezero !=null){
            System.out.println(bezero);
            logetu();
            //saioMenua();
        }else {
            try {
                Cookie.borratuCache();
            }catch (IOException e){
                System.err.println("cook: ezin izan da borratu cachea");
            }

        }
    }


    void saioMenua(){
        aukera2.removeAll();
        menulist = new Choice();

        menulist.add(bezero.getErabiltzaileIzena());
        menulist.add("Konfigurazioa");
        menulist.add("Saioa itzi");

        menulist.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String aukera = menulist.getSelectedItem();


                    if (aukera.equals(bezero.getErabiltzaileIzena())) {
                        System.out.println(bezero);
                    } else if (aukera.equals("Konfigurazioa")) {
                        System.out.println("Konfigurazioa egiten dago");
                        Konfigurazioa.datuakAldatu(bezero);
                    } else if (aukera.equals("Saioa itzi")) {
                        try {
                            Cookie.borratuCache();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Arazo bat gertatu egin da saioa izteko momentuan", "Saioa itzi", JOptionPane.ERROR_MESSAGE);
                        }

                        bezero = null;
                        aukera2.setVisible(false);
                        aukera1.setVisible(true);


                    } else {
                        System.out.println("Aukeratu egin den aukera ez da ezistitzen");
                    }
                }
            }

        });

        aukera2.add(menulist);



    }


    void menuBotoiak(String izena){

        if (izena.equals(lista[0])){
            menuPelikula();
        } else if (izena.equals(lista[1])) {
            menuAktoreak();
        } else if (izena.equals(lista[2])) {
            menuZuzendaria();
        }else if (izena.equals(lista[3])){
            menuLaguntza();
        }else if (izena.equals(lista[4])){
            menuMyList();
        }else {
            System.err.println("Arazo bat gertatu egin da, aukeratu egin da aukera bat ez dagoena. menuBotoiak()");
        }

    }


    void menuPelikula(){
        asieraraPel(30,false);
        asieraraAkto(-1, false);
    }

    void menuAktoreak(){
        asieraraPel(-1,false);
        asieraraAkto(30, false);
    }

    void menuZuzendaria(){

    }

    void menuLaguntza(){

    }

    void menuMyList(){

    }


    void asierara() throws SQLException {

        asieraraPel(7, true);
        asieraraAkto(7, true);





    }

    void asieraraPel(int z, boolean hasiera){


        if (z == -1){
            pelikulak.setVisible(false);
            peliTitul.setVisible(false);
        }else if (hasiera){
            pelikulak.setVisible(true);
            peliTitul.setVisible(true);
        }else {
            pelikulak.setVisible(true);
            peliTitul.setVisible(false);
        }
        pelikulak.removeAll();

        ArrayList<Pelikulak> nuevasPelikulak = peliList(z);

        for (Pelikulak pel : nuevasPelikulak) {
            JLabel irudia = irudiak(pel.getIrudiaLokalki(), 130, 200);
            pelikulaList.put(irudia, pel);
            irudia.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    pelikulaAukeratuta(e);
                }
            });
            pelikulak.add(irudia);
        }

        pelikulak.revalidate();
        pelikulak.repaint();
    }

    void asieraraAkto(int z, boolean hasiera){
        aktoreak.removeAll();


        if (z == -1){
            aktoreak.setVisible(false);
            aktoreTitul.setVisible(false);
        }else if (hasiera){
            aktoreak.setVisible(true);
            aktoreTitul.setVisible(true);
        }else {
            aktoreak.setVisible(true);
            aktoreTitul.setVisible(false);
        }

        ArrayList<Aktoreak> aktoreBerriak = aktoList(z);

        for (Aktoreak akt : aktoreBerriak) {
            JLabel irudia = irudiak(akt.getIrudiaLokalki(), 130, 200);
            aktoreList.put(irudia, akt);
            irudia.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    aktoreaAukeratu(e);;
                }
            });
            aktoreak.add(irudia);
        }

        aktoreak.revalidate();
        aktoreak.repaint();
    }


}
