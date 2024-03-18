package index;
import javax.swing.*;
import java.awt.*;

public class Index {

    private int x;
    private int y;
    private String izena;


    private JFrame frame;
    private JButton buttonLogin, buttonSingUp, pelikulak, aktoreka, zuzendariak, produktorak, laguntza, myList;
    private JTextField bilatu;
    private JList<String> aukerak;


    public Index(int x, int y, String izena) {
        this.x = x;
        this.y = y;
        this.izena = izena;

        sortuLehoia();




        erakutsi(); //← Azkeneko gauza egin behar dena

    }

    void sortuLehoia(){
        frame = new JFrame(izena);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi(){
        frame.pack();
        frame.setVisible(true);
    }
}
