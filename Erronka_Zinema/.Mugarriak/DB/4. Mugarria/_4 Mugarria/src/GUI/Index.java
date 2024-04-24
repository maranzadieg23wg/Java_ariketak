package GUI;

import DB.Konexioa;
import Objetuak.Argazkia;
import Objetuak.Argazkilari;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Index extends JFrame implements ItemListener{
    ArrayList<String> modelData = new ArrayList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    String url = "";
    JLabel irudia;


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


        modelData = new ArrayList<>();
        model = new DefaultListModel<>();
        jlist = new JList(model);
        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                url = (String) jlist.getSelectedValue();
                System.out.println(url);
                irudia = irudiak("./IMG/"+url+".jpg", 100,100);
                temp3.removeAll(); 
                temp3.add(irudia);
                temp3.revalidate();
                temp3.repaint();
            }
        });




        temp2.add(jlist);
        menua.add(temp2);

        url = "";
        irudia = irudiak("./IMG/"+url+".jpg", 100,100);

        temp3.add(irudia);
        menua.add(temp3);


    }

    void eguneratuLista(){
        model.addAll(modelData);
        jlist.setModel(model);
    }



    @Override
    public void itemStateChanged(ItemEvent e) {


        if (e.getSource().equals(combo)){

            for (Argazkilari argazkilari : list){
                if (argazkilari.getIzena().equals(e.getItem())){
                    ArrayList<Argazkia> a = argazkilari.getList();

                    modelData.clear();
                    model.clear();
                    jlist.clearSelection();

                    for (Argazkia argazkia : a){
                        modelData.add(argazkia.getIzena());
                    }
                    eguneratuLista();

                }
            }

        }

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
}
