package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Leihoa extends JFrame implements ActionListener {

    private int x;
    private int y;
    private String izena;

    private JFrame frame;
    private JPanel menua, menua2;
    private String[] lista;
    private JComboBox<String> listaIrudiak;
    private JTextArea textua;
    private String karpeta1;


    public Leihoa(String izena, int x, int y){

        this.x = x;
        this.y = y;
        this.izena = izena;

        this.karpeta1 = "IMG";

        sortuLehioa();
        irudiakList();

        menua();
        menua2();


        erakutsi();


    }

    void sortuLehioa(){
        frame = new JFrame(izena);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }

    void erakutsi(){

        frame.add(menua, BorderLayout.WEST);

        //frame.add(menua2, BorderLayout.EAST);


        frame.pack();
        frame.setVisible(true);
    }

    void irudiakList(){ //← Irakurtzen dugu dauden fitxategi guztiak IMG karpetan.
        File karpeta = new File(karpeta1);

        if (karpeta.exists() && karpeta.isDirectory()){
            lista = karpeta.list();
        }else {
            System.err.println("Sartutako karpeta ez da existitzen");
        }
    }

    JComboBox<String> irudiakAukeratu(JComboBox<String> list){ //← Aukeratzen ditugu IMG karpetan dauden irudi guztiak bukatzen dutenak .jpg edo .png-en.
        list = new JComboBox<>();


        for (String izenak : lista){

            //Konprobatu irudi bat den a la ez.
            int z = izenak.length();
            String formatua = izenak.substring(z-4, z);
            //System.out.println("Formatua: "+formatua);
            if (formatua.equals(".jpg") || formatua.equals(".png")){
                list.addItem(izenak);
                System.out.println("izenak: "+izenak);
            }

        }

        return list;
    }

    void menua(){ //← Ezkerreko menua sortu egiten dugu.
        menua = new JPanel();

        //↓ Irudien desplegablea sortu egiten dugu.
        listaIrudiak = irudiakAukeratu(listaIrudiak); //← Gehitzen ditugu JComboBox<String>-era aurkitu diren irudi guztiak

        listaIrudiak.addActionListener(this); // ← Aldatzen denean baloreren bat, hemendik lortu al dugu ezarri den balore berria.

        menua.add(listaIrudiak);

        //↓ Irudia
        JLabel irudiak = new JLabel(); //← Irudia hemen exarriko dugu.
        menua.add(irudiak);

        //↓ Lehenengo irudia exartzen dugu
        ImageIcon originalIcon = new ImageIcon(karpeta1+"\\"+listaIrudiak.getItemAt(0));
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
        ImageIcon theDark = new ImageIcon(img1);
        irudiak.setIcon(theDark);

        menua.add(label);*/


    }

    void menua2(){
        menua2 = new JPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaIrudiak){
            irudia_berritu(e);
        } else if (e.getSource() == gorde) {

        }
    }

    void irudia_berritu(ActionEvent e){ //← Ezartzen dugu irudi berria
        JComboBox<String> lista = (JComboBox<String>) e.getSource(); //← Lortzen dugu irudien lista guztia
        String path = (String) lista.getSelectedItem(); //← Lortzen dugu aukeratu egin dugun irudiaren izena.
        ImageIcon originalIcon = new ImageIcon(karpeta1+"\\"+path); //← Irudia aukeratu
        //↓Irudiaren tamaina ezarri
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(125, 100, Image.SCALE_SMOOTH);

        ((JLabel) menua.getComponent(1)).setIcon(new ImageIcon(img1)); //← Ezartzen dugu irudi berria.
    }
}
