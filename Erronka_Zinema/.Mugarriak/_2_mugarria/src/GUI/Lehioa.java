package GUI;
import javax.swing.*;
import java.awt.*;

public class Lehioa {

    private int x;
    private int y;
    private String izena;


    private JFrame frame;
    private JPanel menua;
    private JComboBox<String> lista;
    private JButton garbitu;
    
        public Lehioa(String izena, int x, int y){

            this.x = x;
            this.y = y;
            this.izena = izena;

            sortuLehioa();

            menua();

            erakutsi();

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

            //GridLayout gridLayout = new GridLayout(2,1);
            //menua.setLayout(gridLayout);

            menua.setBackground(Color.CYAN);


            lista = new JComboBox<String>();
            lista.setBounds(100, 10, 150, 20);
            lista.addItem("Gorria");
            lista.addItem("Berdea");
            lista.addItem("Horia");

            menua.add(lista);

            garbitu = new JButton("Clear");
            menua.add(garbitu);




        }
    
}
