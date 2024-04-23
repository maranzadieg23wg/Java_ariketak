package GUI;

import DB.Konexioa;
import Objetuak.Argazkilari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Index extends JFrame implements ItemListener{


    private int x;
    private int y;
    private String izena;


    private ArrayList<Argazkilari> list;


    private JFrame frame;

    private JPanel menua;

    private JList jlist;
    JComboBox<String> combo;


    public Index(String izena, int x, int y){

        this.x = x;
        this.y = y;
        this.izena = izena;



        sortuLehioa();
        konexioa();

        menua();



        erakutsi();


    }

    void konexioa(){
        Konexioa conn = new Konexioa();
        list = conn.getList();
    }

    void sortuLehioa(){
        frame = new JFrame(izena);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }


    void erakutsi(){

        frame.add(menua);




        frame.pack();
        frame.setVisible(true);
    }


    void menua(){

        menua = new JPanel();

        JPanel temp = new JPanel();
        JPanel temp1 = new JPanel();
        JPanel temp2 = new JPanel();
        JPanel temp3 = new JPanel();

        GridLayout l = new GridLayout(2, 2);


        menua.setLayout(l);


        combo = new JComboBox<>();
        for (Argazkilari arg : list){
            combo.addItem(arg.getIzena());

        }
        combo.addItemListener(this);

        temp.add(combo);
        menua.add(temp);


        jlist = new JList<>();

        temp2.add(jlist);
        menua.add(temp2);


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals(combo)){
            System.out.println(111111);
        }

    }
}
