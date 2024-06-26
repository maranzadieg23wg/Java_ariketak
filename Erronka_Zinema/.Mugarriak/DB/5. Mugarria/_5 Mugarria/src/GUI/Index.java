package GUI;

import DB.Konexioa;
import Objetuak.Argazkia;
import Objetuak.Argazkilari;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Index extends JFrame implements ItemListener{
    ArrayList<String> modelData = new ArrayList<>();
    ArrayList<Argazkia> a;
    DefaultListModel<String> model = new DefaultListModel<>();
    String url = "";
    JLabel irudia;
    boolean bai;


    private int x;
    private int y;
    private String izena;

    JXDatePicker data;

    private ArrayList<Argazkilari> list;


    private JFrame frame;

    private JPanel menua;

    private JList jlist;
    JComboBox<String> combo;

    JButton award, remove;

    public Index(String izena, int x, int y){

        this.x = x;
        this.y = y;
        this.izena = izena;


        bai = false;

        sortuLehioa();
        konexioa();

        menua();



        erakutsi();


    }
    Konexioa conn;
    void konexioa(){
        conn = new Konexioa();
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

        GridLayout l = new GridLayout(3, 2);


        menua.setLayout(l);

        award = new JButton("AWARD");
        award.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                irabazleak();
            }
        });
        menua.add(award);

        remove = new JButton("REMOVE");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    borratu();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });        menua.add(remove);


        combo = new JComboBox<>();
        for (Argazkilari arg : list){
            combo.addItem(arg.getIzena());

        }
        combo.addItemListener(this);

        temp.add(combo);
        menua.add(temp);



        data = new JXDatePicker();


        temp2.add(data);
        menua.add(temp2);



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

                for (Argazkia b : a){
                    if (b.getIzena().equals(url)){

                        try {
                            eguneratu(b);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        Date d = b.getData();

                        //data.setDate(d); //Data eguneratu

                    }
                }
            }
        });




        //temp2.add(jlist);
        menua.add(jlist);

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
                    /*if (a.isEmpty()){
                        a.clear();
                    }*/

                    a = argazkilari.getList();

                    modelData.clear();
                    model.clear();
                    jlist.clearSelection();

                    for (Argazkia argazkia : a){
                        if (data.getDate() != null){
                            int diferentzia = argazkia.getData().compareTo(data.getDate());
                            if (diferentzia>0){
                                modelData.add(argazkia.getIzena());
                            }
                        }

                    }
                    eguneratuLista();

                }
            }

        } else if (e.getSource().equals(award)) {
            System.out.println("AWARD");
        } else if (e.getSource().equals(remove)) {
            System.out.println("REMOVE");
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

    void eguneratu(Argazkia argazkia) throws SQLException {

        Konexioa conn = new Konexioa();
        conn.eguneratu(argazkia.getID());
        conn.konexioaItxi();

    }

    void irabazleak(){
        Konexioa.irabazi();
    }

    void borratu() throws SQLException {
        conn.borratu();
    }
}
