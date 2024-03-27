package GUI;

import javax.swing.*;
import java.awt.*;

public class Leihoa extends JFrame{

    private int x;
    private int y;
    private String izena;

    private JFrame frame;

    public Leihoa(String izena, int x, int y){

        this.x = x;
        this.y = y;
        this.izena = izena;

        sortuLehioa();



        erakutsi();

    }

    void sortuLehioa(){
        frame = new JFrame(izena);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi(){

        frame.pack();
        frame.setVisible(true);
    }

}
