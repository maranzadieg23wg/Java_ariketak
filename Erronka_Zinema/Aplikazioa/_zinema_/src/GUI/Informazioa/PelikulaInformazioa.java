package GUI.Informazioa;

import DatuBase.Konexioa;
import GUI.Index;
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

public class PelikulaInformazioa {

    private static HashMap <JLabel, Aktoreak> aktoreList;
    private static HashMap <JLabel, Zuzendariak> zuzendariList;

    private static JPanel pelikularenInformazia;

    public static JPanel peliInfo(Pelikulak pelikula) throws SQLException {

        aktoreList = new HashMap<>();
        zuzendariList = new HashMap<>();

        pelikularenInformazia = new JPanel();
        pelikularenInformazia.setLayout(new BoxLayout(pelikularenInformazia, BoxLayout.Y_AXIS));

        String izenburua = pelikula.getTituloa();
        JLabel izenBuru = new JLabel(izenburua);

        pelikularenInformazia.add(izenBuru);
        pelikularenInformazia.add(zuriaZatia(30, 50));


        JPanel datuak = pelikulaDatu(pelikula);

        pelikularenInformazia.add(datuak);

        pelikularenInformazia.add(aktoreak(pelikula), BorderLayout.SOUTH);



        return pelikularenInformazia;
    }

    static JPanel pelikulaDatu(Pelikulak pelikulak) throws SQLException {
        Konexioa conn = new Konexioa();
        int id = pelikulak.getIDPelikula();
        Zuzendariak zuzendariak = conn.pelikulaZuzendaria(id);

        JPanel datuak = new JPanel();
        datuak.setLayout(new BorderLayout());

        JPanel irudiak = new JPanel();
        irudiak.setLayout(new BoxLayout(irudiak, BoxLayout.Y_AXIS));

        JLabel irudia = irudiak(pelikulak.getIrudiaLokalki(), 130, 200);



        irudiak.add(irudia);
        irudiak.add(zuriaZatia(30, 60));
        if (zuzendariak!=null){
            JLabel zuzendaria = irudiak(zuzendariak.getIrudiaLokalki(), 130, 200);

            zuzendaria.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Object source = e.getSource();
                    Zuzendariak zuz = zuzendariList.get(source);
                    System.out.println(zuz);
                }
            });

            irudiak.add(zuzendaria);

            zuzendariList.put(zuzendaria, zuzendariak);
        }

        datuak.add(irudiak, BorderLayout.WEST);

        JPanel informazioa = informazioa(pelikulak);
        //informazioa.setBorder(BorderFactory.createEmptyBorder(0, 45, 0, 0)); //← Gehitzeko zuriune bat
        //informazioa.add(zuriaZatia(45, 50));
        datuak.add(informazioa, BorderLayout.CENTER);

        JTextArea sinopsisArea = new JTextArea(pelikulak.getSinopsis());
        sinopsisArea.setLineWrap(true);
        sinopsisArea.setWrapStyleWord(true);
        sinopsisArea.setEditable(false);
        sinopsisArea.setColumns(30);
        //informazioa.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45)); //← Gehitzeko zuriune bat
        //informazioa.add(zuriaZatia(45, 50));

        datuak.add(new JScrollPane(sinopsisArea), BorderLayout.EAST);

        return datuak;

    }

    static JPanel informazioa(Pelikulak pelikulak) throws SQLException {
        JPanel informazioa = new JPanel();
        informazioa.setLayout(new GridLayout(6, 1)); // Cambiado a 6 filas para acomodar la sinopsis

        String generoa = pelikulak.getGeneroa();
        generoa = "Generoak: " + generoa.replace(";", " - ");
        JLabel izenBuru = new JLabel(generoa);
        informazioa.add(izenBuru);

        Konexioa conn = new Konexioa();
        ResultSet emaitza = conn.estrenaldia(pelikulak.getIdEstrenaldia());
        String data = "";
        if (emaitza.next()) {
            data = "Estrenaldi data: " + String.valueOf(emaitza.getString("ESTREINALDI_DATA"));
        }
        conn.konexioaItxi();

        JLabel dat = new JLabel(data);
        informazioa.add(dat);

        JLabel irabaziak = new JLabel("Irabaziak: " + String.valueOf(pelikulak.getIrabaziak()));
        informazioa.add(irabaziak);

        JLabel aurrekontua = new JLabel("Aurrekontuak: " + String.valueOf(pelikulak.getAurrekontua()));
        informazioa.add(aurrekontua);



        JButton trailera = new JButton("Trailera");
        trailera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI uri = new URI(pelikulak.getTrailera());
                    Desktop.getDesktop().browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        informazioa.add(trailera);
        
        Konexioa con = new Konexioa();
        Bezero bezer = con.getBezero();
        con.konexioaItxi();
        
        if (bezer==null){
            JLabel text = new JLabel("Ez duzu saioa hasi");
            informazioa.add(text);
        } else {
            Konexioa co = new Konexioa();
            IkusitakoLista lista = co.listanDago(pelikulak.getIDPelikula());
            System.out.println(lista);
            if (lista !=null){
                JLabel nota = new JLabel("Nota: "+lista.getNota());
                JLabel ikusitakoKopurua = new JLabel("Ikusitako kopurua: "+lista.getIkus_kop());
                informazioa.add(nota);
                informazioa.add(ikusitakoKopurua);

                JButton notaAldatu = new JButton("Nota aldatu");
                notaAldatu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        NotaAldatu.notaAldatu(pelikulak.getIDPelikula(), lista.getNota(), lista.getIkus_kop());

                        pelikularenInformazia.revalidate();
                        pelikularenInformazia.repaint();
                    }
                });


                informazioa.add(notaAldatu);

            }else {
                JButton listaraGehitu = new JButton("Listara gehitu");
                listaraGehitu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GehituListara.gehituListara(pelikulak.getIDPelikula());
                        pelikularenInformazia.setVisible(false);
                        pelikularenInformazia.revalidate();
                        pelikularenInformazia.repaint();
                        pelikularenInformazia.setVisible(true);



                    }
                });
                informazioa.add(listaraGehitu);
            }

            co.konexioaItxi();
        }

        /*
        * 
        * Hemen gehitu notak edo gehitzeko.
        * */

        return informazioa;
    }

    static JPanel aktoreak(Pelikulak pel) throws SQLException {
        int id = pel.getIDPelikula();

        Konexioa conn = new Konexioa();

        ArrayList<Aktoreak> list = conn.pelikulakoAktoreak(id);

        JPanel panelAktoreak = new JPanel();
        panelAktoreak.setLayout(new FlowLayout());

        for (Aktoreak akt : list) {
            JLabel irudi = irudiak(akt.getIrudiaLokalki(), 130, 200);
            aktoreList.put(irudi, akt);

            irudi.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Object source = e.getSource();
                    Aktoreak akt = aktoreList.get(source);
                    System.out.println(akt);
                }
            });

            panelAktoreak.add(irudi);
        }

        return panelAktoreak;
    }


    static JLabel irudiak(String url, int x, int y) {
        ImageIcon originalIcon = new ImageIcon(url);
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img1);

        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        return label;
    }

    static JLabel zuriaZatia(int luzeera, int altuera){
        JLabel zuria = new JLabel();
        zuria.setPreferredSize(new Dimension(luzeera, altuera));
        zuria.setMaximumSize(new Dimension(luzeera, altuera));
        zuria.setMinimumSize(new Dimension(luzeera, altuera));
        zuria.setOpaque(true);
        //zuria.setBackground(Color.WHITE);
        return zuria;
    }
}
