package GUI.Informazioa;

import DatuBase.Konexioa;
import GUI.Informazioa.notak.GehituListara;
import GUI.Informazioa.notak.NotaAldatu;
import Objetuak.DB.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AktoreInformazioa {
    private static HashMap<JLabel, Pelikulak> peliLista;


    private static JPanel aktorearenInformazioa;

    public static JPanel aktoInfo(Aktoreak aktore) throws SQLException {

        peliLista = new HashMap<>();


        aktorearenInformazioa = new JPanel();
        aktorearenInformazioa.setLayout(new BoxLayout(aktorearenInformazioa, BoxLayout.Y_AXIS));

        String izab = aktore.getIzena()+" "+aktore.getAbizena();
        JLabel izenBuru = new JLabel(izab);

        aktorearenInformazioa.add(izenBuru);
        aktorearenInformazioa.add(zuriaZatia(30, 50));


        JPanel datuak = aktoreDatuak(aktore);

        aktorearenInformazioa.add(datuak, BorderLayout.CENTER);

        aktorearenInformazioa.add(pelikulak(aktore), BorderLayout.SOUTH);



        return aktorearenInformazioa;
    }

    private static JPanel aktoreDatuak(Aktoreak aktoreDatuak) throws SQLException {
        JPanel datuak = new JPanel();
        datuak.setLayout(new BorderLayout());

        JPanel irudiak = new JPanel();
        irudiak.setLayout(new BoxLayout(irudiak, BoxLayout.Y_AXIS));
        irudiak.add(irudiak(aktoreDatuak.getIrudiaLokalki(), 130, 200));

        JPanel informazioaPanel = new JPanel();
        informazioaPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alineación al centro
        JLabel informazioa = zuriaZatia(60, 90);
        informazioaPanel.add(informazioa);

        datuak.add(irudiak, BorderLayout.CENTER);
        datuak.add(informazioaPanel, BorderLayout.SOUTH);

        return datuak;
    }



    private static JScrollPane pelikulak(Aktoreak akt) throws SQLException {
        int id = akt.getId_aktora();

        Konexioa conn = new Konexioa();

        ArrayList<Pelikulak> list = conn.pelikuletanLanEgin(id);

        JPanel pelPanela = new JPanel();
        pelPanela.setLayout(new FlowLayout(FlowLayout.LEFT));

        int panelWidth = 800;
        int panelHeight = 212;
        int totalImageWidth = list.size() * 140;

        for (Pelikulak pel : list) {
            JLabel irudi = irudiak(pel.getIrudiaLokalki(), 130, 200);
            peliLista.put(irudi, pel);

            irudi.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Object source = e.getSource();
                    Pelikulak peli = peliLista.get(source);
                    System.out.println(peli);

                    try {
                        aktorearenInformazioa.removeAll();
                        aktorearenInformazioa.add(PelikulaInformazioa.peliInfo(peli));
                        aktorearenInformazioa.revalidate();
                        aktorearenInformazioa.repaint();


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            pelPanela.add(irudi);
        }

        pelPanela.setPreferredSize(new Dimension(totalImageWidth, panelHeight));

        JScrollPane scrollPane = new JScrollPane(pelPanela);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(panelWidth, panelHeight));

        return scrollPane;
    }




    private static JLabel irudiak(String url, int x, int y) {
        ImageIcon originalIcon = new ImageIcon(url);
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img1);

        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        return label;
    }

    private static JLabel zuriaZatia(int luzeera, int altuera){
        JLabel zuria = new JLabel();
        zuria.setPreferredSize(new Dimension(luzeera, altuera));
        zuria.setMaximumSize(new Dimension(luzeera, altuera));
        zuria.setMinimumSize(new Dimension(luzeera, altuera));
        zuria.setOpaque(true);
        //zuria.setBackground(Color.WHITE);
        return zuria;
    }
}
