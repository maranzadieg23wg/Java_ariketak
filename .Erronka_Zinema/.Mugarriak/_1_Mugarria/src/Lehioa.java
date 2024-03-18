import javax.swing.*;
import java.awt.*;

public class Lehioa {

private int x;
private int y;
private String izena;

private JFrame frame;
private JButton botoia1, botoia2;
private JRadioButton radio1, radio2, radio3;
private JCheckBox chex1, chex2;
private JPanel behekoPanel, goikoPanel, eskubikoPanel, ezkerrekoPanel;
private ImageIcon irudia;


    public Lehioa(String izena, int x, int y) {
        this.x = x;
        this.y = y;
        this.izena = izena;

        sortuLehoia();

        beheko();
        eskubiko();
        goiko();
        ezkerreko();


        erakutsi();






    }


    void sortuLehoia(){
        frame = new JFrame(izena);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(x, y));
    }
    void erakutsi(){
        frame.add(ezkerrekoPanel, BorderLayout.WEST);

        frame.add(behekoPanel, BorderLayout.SOUTH);
        //frame.add(behekoPanel, BorderLayout.WEST);

        frame.add(eskubikoPanel, BorderLayout.EAST);
        frame.add(goikoPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    void beheko(){
        behekoPanel = new JPanel();
        botoia1 = new JButton("Botoia 1");
        botoia2 = new JButton("Botoia 2");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        behekoPanel.setLayout(flowLayout);
        //behekoPanel.setBackground(Color.blue);

        behekoPanel.add(botoia1);
        behekoPanel.add(botoia2);

    }

    void eskubiko() {
        eskubikoPanel = new JPanel();
        radio1 = new JRadioButton("OPT 1", true);
        radio2 = new JRadioButton("OPT 2", false);
        radio3 = new JRadioButton("OPT 3", false);

        eskubikoPanel.setLayout(new BoxLayout(eskubikoPanel, BoxLayout.Y_AXIS));

        ButtonGroup radio = new ButtonGroup();
        radio.add(radio1);
        radio.add(radio2);
        radio.add(radio3);

        eskubikoPanel.add(Box.createVerticalGlue());

        eskubikoPanel.add(radio1);
        eskubikoPanel.add(radio2);
        eskubikoPanel.add(radio3);

        eskubikoPanel.add(Box.createVerticalGlue());
    }


    void goiko(){
        goikoPanel = new JPanel();

        chex1 = new JCheckBox("Katniss");
        chex2 = new JCheckBox("Peeta");

        goikoPanel.add(chex1);
        goikoPanel.add(chex2);

    }

    void ezkerreko() {
        ezkerrekoPanel = new JPanel();
        ImageIcon originalIcon = new ImageIcon("irudiak/TheDarkSideOfTheMon.png");

        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
        ImageIcon theDark = new ImageIcon(img1);

        GridLayout gridLayout = new GridLayout(2, 4);
        ezkerrekoPanel.setLayout(gridLayout);

        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel();
            label.setIcon(theDark);
            ezkerrekoPanel.add(label);
        }

        // ezkerrekoPanel.setBackground(Color.red);
    }



}
