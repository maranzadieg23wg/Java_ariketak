package GUI.Informazioa;

import DatuBase.Konexioa;
import Objetuak.DB.Pelikulak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PelikulaInformazioa {



    public static JPanel peliInfo(Pelikulak pelikula) throws SQLException {

        JPanel pelikularenInformazia = new JPanel();

        String izenburua = pelikula.getTituloa();
        JLabel izenBuru = new JLabel(izenburua);

        pelikularenInformazia.add(izenBuru);


        JPanel datuak = pelikulaDatu(pelikula);

        pelikularenInformazia.add(datuak);



        return pelikularenInformazia;

    }

    static JPanel pelikulaDatu(Pelikulak pelikulak) throws SQLException {

        JPanel datuak = new JPanel();

        datuak.setLayout(new GridLayout(3, 2)); //↓→

        datuak.add(irudiak(pelikulak.getIrudiaLokalki(), 130, 200));

        JPanel informazioa = informazioa(pelikulak);

        datuak.add(informazioa);


        String sinopsis = pelikulak.getSinopsis();
        JLabel sino = new JLabel(sinopsis);
        datuak.add(sino);


        return  datuak;


    }

    static JPanel informazioa (Pelikulak pelikulak) throws SQLException {
        JPanel informazioa = new JPanel();

        informazioa.setLayout(new GridLayout(5,1));


        String generoa = pelikulak.getGeneroa();
        generoa = generoa.replace(";", " - ");
        JLabel izenBuru = new JLabel(generoa);
        informazioa.add(izenBuru);


        Konexioa conn = new Konexioa();
        ResultSet emaitza = conn.estrenaldia(pelikulak.getIdEstrenaldia());
        emaitza.next();

        String data = String.valueOf(emaitza.getString("ESTREINALDI_DATA"));
        //System.out.println(data);
        conn.konexioaItxi();



        JLabel dat = new JLabel(data);
        informazioa.add(dat);


        JLabel irabaziak = new JLabel(String.valueOf(pelikulak.getIrabaziak()));
        informazioa.add(irabaziak);

        JLabel aurrekontua = new JLabel(String.valueOf(pelikulak.getAurrekontua()));
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

        return informazioa;

    }


    static JLabel irudiak(String url, int x, int y){
        ImageIcon originalIcon = new ImageIcon(url);

        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon thedark = new ImageIcon(img1);

        JLabel label = new JLabel();
        label.setIcon(thedark);
        return label;
    }
}
