package index;
import javax.swing.*;
import java.awt.*;

public class Index {

    private int x;
    private int y;
    private String izena;


    private JFrame frame;
    private JPanel menua, menua2;
    private JButton buttonLogin, buttonSingUp, pelikulak, aktoreak, zuzendariak, produktorak, laguntza, myList;
    private JTextField bilatu;
    private JList<String> aukerak;

    private String[] lista;


    public Index(int x, int y, String izena) {
        this.x = x;
        this.y = y;
        this.izena = izena;

        sortuLehoia();
        menua();



        erakutsi(); //← Azkeneko gauza egin behar dena

    }

    void sortuLehoia(){
        frame = new JFrame(izena);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi(){

        frame.add(menua, BorderLayout.NORTH);


        frame.pack();
        frame.setVisible(true);
    }

    void menua(){

        menua = new JPanel();

        GridLayout gridLayout = new GridLayout(1, 4);

        menua.setLayout(gridLayout);

        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait


        String izena = "zinema";
        JLabel label = new JLabel(izena);

        menua.add(label);


        //↓Botoiak
        buttonLogin = new JButton("Login");
        buttonSingUp = new JButton("SingUp");

        buttonLogin.setPreferredSize(new Dimension(80, 30));
        buttonSingUp.setPreferredSize(new Dimension(80, 30));



        menua.add(buttonLogin);
        menua.add(buttonSingUp);

        menua.add(new JLabel()); //← Gehitzeko utzik dagoen zerbait



    }
}
