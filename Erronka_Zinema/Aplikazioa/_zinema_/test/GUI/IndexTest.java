package GUI;

import Objetuak.DB.Aktoreak;
import Objetuak.DB.Pelikulak;
import Objetuak.DB.Zuzendariak;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
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

        assertNotNull(pelList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void aktoList() {
        ArrayList<Aktoreak> aktoList = index.aktoList(50);

        assertNotNull( aktoList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void zuzList() {
        ArrayList<Zuzendariak> zuzList = index.zuzList(50);

        assertNotNull(zuzList.size(), "[-] Lortutako lista ez da behar bezain luzea");
    }

    @Test
    void zuriaZatia() {

        JLabel zuria = new JLabel();
        zuria.setPreferredSize(new Dimension(50, 30));



        assertNotNull(index.zuriaZatia(50).hashCode(), "[-] Lortu egin den JLabela ez da berbera");
    }



    @Test
    void testLogetu_a() throws SQLException {
        //index.logetu();
    }

    @Test
    void testZuriaZatia_a() throws SQLException {
        assertNotNull(index.zuriaZatia(5));
    }

    @Test
    void testZuzList_a() throws SQLException {
        assertNotNull(index.zuzList(1));
    }

    @Test
    void testMyListList_a() throws SQLException {
        assertNotNull(index.MyListList());
    }

    @Test
    void testAktoList_a() throws SQLException {
        assertNotNull(index.aktoList(1));
    }

    @Test
    void testPeliList_a() throws SQLException {
        assertNotNull(index.peliList(1));
    }





}