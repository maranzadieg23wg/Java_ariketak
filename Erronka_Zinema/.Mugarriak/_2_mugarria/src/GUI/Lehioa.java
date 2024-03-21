package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lehioa extends JFrame implements ActionListener {

    private int x;
    private int y;
    private String izena;


    private JFrame frame;
    private JPanel menua;
    private JComboBox<String> lista;
    private JButton garbitu, itzi;
    private JTextArea textua;
    private JScrollPane scrola;

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
            //menua.setLayout(new BorderLayout());

            //GridLayout gridLayout = new GridLayout(1,2);
            //menua.setLayout(gridLayout);

            menua.setBackground(Color.CYAN);


            lista = new JComboBox<String>();
            lista.setBounds(100, 10, 150, 20);
            lista.addItem("Python.txt");
            lista.addItem("C.txt");
            lista.addItem("Java.txt");
            lista.addActionListener(this);


            lista.setPreferredSize(new Dimension(200, 25));
            menua.add(lista);

            garbitu = new JButton("Clear");
            garbitu.addActionListener(this);
            menua.add(garbitu);






            textua = new JTextArea();
            textua.setPreferredSize(new Dimension(400, 600));

            textua.setLineWrap(true);

            scrola = new JScrollPane(textua); //← Scrola sortu
            scrola.setBounds(10,50,400,300);


            //textua.setVerticalAlignment(JTextField.TOP);
            menua.add(scrola);

            itzi = new JButton("Close");
            itzi.addActionListener(this);
            menua.add(itzi);



        }

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == garbitu) {
                textua.setText("");
            } else if (e.getSource() == itzi) {
                System.exit(0);
            }else if (e.getSource() == lista) {
                String selectedOption = (String) lista.getSelectedItem();
                textua.append(selectedOption + "\n");
            }

        }
}
