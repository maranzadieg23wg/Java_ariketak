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
        JPanel pelikularenInformazia = new JPanel(new BorderLayout());

        // Título de la película
        String izenburua = pelikula.getTituloa();
        JLabel izenBuru = new JLabel(izenburua, SwingConstants.CENTER);
        izenBuru.setFont(new Font("Arial", Font.BOLD, 20));
        pelikularenInformazia.add(izenBuru, BorderLayout.NORTH);

        // Panel de datos
        JPanel datuak = pelikulaDatu(pelikula);
        pelikularenInformazia.add(datuak, BorderLayout.CENTER);

        return pelikularenInformazia;
    }

    static JPanel pelikulaDatu(Pelikulak pelikulak) throws SQLException {
        JPanel datuak = new JPanel(new BorderLayout());

        // Panel izquierdo: Imagen
        JLabel irudia = irudiak(pelikulak.getIrudiaLokalki(), 130, 200);
        datuak.add(irudia, BorderLayout.WEST);

        // Panel derecho: Información y Sinopsis
        JPanel infoYSinopsis = new JPanel(new BorderLayout());

        // Panel de información
        JPanel informazioa = informazioa(pelikulak);
        infoYSinopsis.add(informazioa, BorderLayout.NORTH);

        // Sinopsis
        String sinopsis = pelikulak.getSinopsis();
        JLabel sino = new JLabel("<html><body style='width: 300px'>" + sinopsis + "</body></html>");
        infoYSinopsis.add(sino, BorderLayout.CENTER);

        datuak.add(infoYSinopsis, BorderLayout.CENTER);

        // Panel inferior: Director y Nota
        JPanel zuzendariEtaNota = new JPanel(new GridLayout(1, 2));

        // Director
        //String zuzendaria = pelikulak.getZuzendaria();
        //JLabel zuzendariLabel = new JLabel("Zuzendaria: " + zuzendaria, SwingConstants.CENTER);
        //zuzendariEtaNota.add(zuzendariLabel);

        // Nota y añadir a lista
        //JPanel notaGehitu = new JPanel(new BorderLayout());
        //JLabel nota = new JLabel("Nota: " + pelikulak.getNota(), SwingConstants.CENTER);
        JButton gehituLista = new JButton("Gehitu Lista");
        //notaGehitu.add(nota, BorderLayout.CENTER);
        //notaGehitu.add(gehituLista, BorderLayout.SOUTH);

        //zuzendariEtaNota.add(notaGehitu);

        //datuak.add(zuzendariEtaNota, BorderLayout.SOUTH);

        // Panel inferior con actores
       /* JPanel aktoreakPanel = new JPanel(new GridLayout(1, 7));
        String[] aktoreak = pelikulak.getAktoreak().split(";"); // Asumiendo que los actores están separados por ";"
        for (String aktore : aktoreak) {
            aktoreakPanel.add(new JLabel(aktore, SwingConstants.CENTER));
        }

        datuak.add(aktoreakPanel, BorderLayout.SOUTH);*/

        return datuak;
    }

    static JPanel informazioa(Pelikulak pelikulak) throws SQLException {
        JPanel informazioa = new JPanel(new GridLayout(5, 1));

        // Genero
        String generoa = pelikulak.getGeneroa().replace(";", " - ");
        JLabel generoLabel = new JLabel("Generoa: " + generoa);
        informazioa.add(generoLabel);

        // Estreno
        Konexioa conn = new Konexioa();
        ResultSet emaitza = conn.estrenaldia(pelikulak.getIdEstrenaldia());
        emaitza.next();
        String data = emaitza.getString("ESTREINALDI_DATA");
        conn.konexioaItxi();
        JLabel dataLabel = new JLabel("Estrenaldia: " + data);
        informazioa.add(dataLabel);

        // Irabaziak
        JLabel irabaziakLabel = new JLabel("Irabaziak: " + pelikulak.getIrabaziak());
        informazioa.add(irabaziakLabel);

        // Aurrekontua
        JLabel aurrekontuaLabel = new JLabel("Aurrekontua: " + pelikulak.getAurrekontua());
        informazioa.add(aurrekontuaLabel);

        // Trailer
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

    static JLabel irudiak(String url, int x, int y) {
        ImageIcon originalIcon = new ImageIcon(url);
        Image img = originalIcon.getImage();
        Image img1 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img1);
        return new JLabel(scaledIcon);
    }
}
