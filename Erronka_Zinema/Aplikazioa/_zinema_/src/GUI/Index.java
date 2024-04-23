package GUI;
import DatuBase.Conexioa;
import Objetuak.IrudiakDeskargatu;
import Objetuak.Pelikulak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton buttonLogin, buttonSingUp, botoiak;
    private JTextField bilatu;
    private JList<String> aukerak;

    private String[] lista;

    private HashMap <JLabel, Pelikulak> pelikulaList;

    private CardLayout menuLista;


    public Index(int x, int y, String izena) throws SQLException {
        this.x = x;
        this.y = y;
        this.izena = izena;

        lista = new String[]{"Pelikulak", "aktoreak", "zuzendariak", "laguntza", "myList"};

        pelikulaList = new HashMap<>();


        sortuLehoia();
        menua();
        menua2();
        pelikulak();



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




        menua.add(buttonLogin);
        menua.add(buttonSingUp);

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
        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait

        aukerak = new JList<>(lista);
        menua2.add(aukerak);

        bilatu = new JTextField("Search");
        menua2.add(bilatu);


        menua2.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


    }


    void erdikoa(){
        erdikoa = new JPanel();

        int peliKop = 7;

        int aktoreKop = 7;



        GridLayout gridLayout = new GridLayout(4, aktoreKop+2+1);

        erdikoa.setLayout(gridLayout);

        erdikoa.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


        //↓ Gehitzeko pelikulak textua
        String peli = "Pelikulak";
        JLabel peliLabel = new JLabel(peli);

        erdikoa.add(peliLabel);
        for (int i =0;i<peliKop;i++){
            erdikoa.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait
        }
        for (int i =0;i<peliKop;i++){
            ImageIcon originalIcon = new ImageIcon("irudiak/pelikula/"+i+".jpg");

            Image img = originalIcon.getImage();
            Image img1 = img.getScaledInstance(130, 200, Image.SCALE_SMOOTH);
            ImageIcon thedark = new ImageIcon(img1);

            JLabel label = new JLabel();
            label.setIcon(thedark);

            erdikoa.add(label);
        }


        //↓ Gehitzeko aktoreak textua
        String akto = "Aktoreak";
        JLabel aktoLabel = new JLabel(akto);


        erdikoa.add(aktoLabel);
        for (int i =0;i<aktoreKop;i++){
            erdikoa.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait
        }
        for (int i =0;i<aktoreKop;i++){
            ImageIcon originalIcon = new ImageIcon("irudiak/aktore/"+i+".jpg");

            Image img = originalIcon.getImage();
            Image img1 = img.getScaledInstance(130, 200, Image.SCALE_SMOOTH);
            ImageIcon thedark = new ImageIcon(img1);

            JLabel label = new JLabel();
            label.setIcon(thedark);

            erdikoa.add(label);
        }

        erdikoa.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


    }
}
