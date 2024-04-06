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

    void irudiakList(){
        File karpeta = new File(karpeta1);

        if (karpeta.exists() && karpeta.isDirectory()){
            lista = karpeta.list();
        }else {
            System.err.println("Sartutako karpeta ez da existitzen");
        }
    }

    void menua(){
        menua = new JPanel();

        //System.out.println(1);
        listaIrudiak = new JComboBox<>();
        for (String izenak : lista){

            //Konprobatu irudi bat den a la ez.
            int z = izenak.length();
            String formatua = izenak.substring(z-4, z);
            //System.out.println("Formatua: "+formatua);
            if (formatua.equals(".jpg") || formatua.equals(".png")){
                listaIrudiak.addItem(izenak);
                //System.out.println("izenak: "+izenak);
            }

        }
        listaIrudiak.addActionListener(this);
        menua.add(listaIrudiak);

        ImageIcon originalIcon = new ImageIcon(karpeta1+"\\"+listaIrudiak);
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
        ImageIcon theDark = new ImageIcon(img1);
        JLabel label = new JLabel();
        label.setIcon(theDark);
        menua.add(label);


    }

    void menua2(){
        menua = new JPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
