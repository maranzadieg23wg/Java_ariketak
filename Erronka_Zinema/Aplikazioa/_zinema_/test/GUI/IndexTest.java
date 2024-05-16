package GUI;

import Objetuak.DB.Aktoreak;
import Objetuak.DB.Pelikulak;
import Objetuak.DB.Zuzendariak;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IndexTest {

    Index index = new Index(0, 0, "Test");

    IndexTest() throws SQLException {
        System.err.println();
    }

    @Test
    void irudiak() {


        assertNotNull(index.irudiak("irudiak/errorIrudia/Image_not_available.png", 10, 10), "[-] Lortutako irudia ez da egokia");

    }

    @Test
    void peliList() {

        ArrayList<Pelikulak> pelList = index.peliList(50);

        assertEquals(50, pelList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void aktoList() {
        ArrayList<Aktoreak> aktoList = index.aktoList(50);

        assertEquals(50, aktoList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void zuzList() {
        ArrayList<Zuzendariak> zuzList = index.zuzList(50);

        assertEquals(50, zuzList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void zuriaZatia() {

        JLabel zuria = new JLabel();
        zuria.setPreferredSize(new Dimension(50, 30));



        assertNotNull(index.zuriaZatia(50).hashCode(), "[-] Lortu egin den JLabela ez da berbera");
    }
}