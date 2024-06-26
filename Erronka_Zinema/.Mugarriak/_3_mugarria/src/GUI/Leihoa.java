package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private JCheckBox gorde;
    private JButton save;


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

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                itxi();
            }
        });

        //this.setVisible(true);
        frame.pack();

        frame.setPreferredSize(new Dimension(x, y));
    }

    void itxi(){
        JOptionPane.showMessageDialog(null, "Agur!", "Manex Aranzadi Egaña", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    void erakutsi(){

        frame.add(menua, BorderLayout.WEST);

        frame.add(menua2, BorderLayout.EAST);


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
        //menua.setBackground(Color.red);
        menua.setPreferredSize(new Dimension(300, 500));

        //↓ Irudien desplegablea sortu egiten dugu.
        listaIrudiak = irudiakAukeratu(listaIrudiak); //← Gehitzen ditugu JComboBox<String>-era aurkitu diren irudi guztiak

        listaIrudiak.addActionListener(this); // ← Aldatzen denean baloreren bat, hemendik lortu al dugu ezarri den balore berria.

        //listaIrudiak.setAlignmentX(Component.CENTER_ALIGNMENT);
        listaIrudiak.setPreferredSize(new Dimension(200, 25));
        menua.add(listaIrudiak);

        //↓ Irudia
        JLabel irudiak = new JLabel(); //← Irudia hemen exarriko dugu.
        //irudiak.setAlignmentX(Component.CENTER_ALIGNMENT);
        menua.add(irudiak);

        //↓ Lehenengo irudia exartzen dugu
        ImageIcon originalIcon = new ImageIcon(karpeta1+"\\"+listaIrudiak.getItemAt(0));
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(200, 225, Image.SCALE_SMOOTH);
        ImageIcon theDark = new ImageIcon(img1);
        irudiak.setIcon(theDark);

        //↓ Check Box a gehitu.
        gorde = new JCheckBox("Save your comment", true);
        //gorde.setAlignmentX(Component.CENTER_ALIGNMENT);
        menua.add(gorde);


        //↓Zonalde txuri bat gehitu
        JPanel txuria = new JPanel();
        txuria.setPreferredSize(new Dimension(250, 30));
        menua.add(txuria);

        //↓Gorde botoia gehitu
        save = new JButton("SAVE");
        save.addActionListener(this);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        //save.setAlignmentY(Component.RIGHT_ALIGNMENT);

        menua.add(save);



    }

    void menua2(){
        menua2 = new JPanel();
        menua2.setPreferredSize(new Dimension(300, 500));

        JPanel txuria = new JPanel();
        txuria.setPreferredSize(new Dimension(250, 250));
        menua2.add(txuria);



        //menua2.setBackground(Color.blue);

        JTextArea textua = new JTextArea();
        textua.setLineWrap(true);
        textua.setPreferredSize(new Dimension(165, 32));
        textua.setAlignmentX(Component.CENTER_ALIGNMENT);

        menua2.add(textua);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaIrudiak){
            irudia_berritu(e);
        } else if (e.getSource() == save) {
            boolean egia = gorde.isSelected();
            if (egia){
                try {
                    gehituMezua(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    void irudia_berritu(ActionEvent e){ //← Ezartzen dugu irudi berria
        JComboBox<String> lista = (JComboBox<String>) e.getSource(); //← Lortzen dugu irudien lista guztia
        String path = (String) lista.getSelectedItem(); //← Lortzen dugu aukeratu egin dugun irudiaren izena.
        ImageIcon originalIcon = new ImageIcon(karpeta1+"\\"+path); //← Irudia aukeratu
        //↓Irudiaren tamaina ezarri
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(200, 225, Image.SCALE_SMOOTH);

        ((JLabel) menua.getComponent(1)).setIcon(new ImageIcon(img1)); //← Ezartzen dugu irudi berria.
    }

    void gehituMezua(ActionEvent e) throws IOException {
        JTextArea te = (JTextArea) menua2.getComponent(1);
        String textua = te.getText();
        System.out.println(textua);

        BufferedWriter w1 = null;

        JComboBox<String> lista = (JComboBox<String>) menua.getComponent(0);
        String path = (String) lista.getSelectedItem();
        //System.out.println(path);
        String izena = path.substring(0, path.length()-4);
        System.out.println(izena);


        try{


            w1 = new BufferedWriter(new FileWriter("Comments\\"+izena+".txt", true));
            w1.newLine();

            w1.write(path+": "+textua);
            w1.close();


        }catch (IOException a){
            System.err.println("Arazo bat egon da idaztean fitxategian");
        }finally {
            w1.close();
        }
    }
}
