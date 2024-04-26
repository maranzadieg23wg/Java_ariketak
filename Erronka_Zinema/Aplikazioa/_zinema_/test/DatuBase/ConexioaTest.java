package DatuBase;

import Objetuak.Aktoreak;
import Objetuak.Pelikulak;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


import static org.junit.jupiter.api.Assertions.*;

class ConexioaTest {

    Conexioa conn = new Conexioa();

    ConexioaTest() throws SQLException {
    }


    @Test
    void sortuKontua() {
    }



    @Test
    @DisplayName("Saioa hasten dela")
    void saioaHasi() throws SQLException {
        assertTrue(conn.saioaHasi("wg31@zubirimanteo.com", "123"), "[-] Saioa ez da hasi, zerbait gaizki sartuta, pasahitza edo emaila");
    }

    @Test
    @DisplayName("Saioa ez dela hasten dela")
    void saioaEzHasi() throws SQLException {
        assertTrue(conn.saioaHasi("wg31@zubirimanteo.com", "123"), "[-] Saioa hasi egin da");
    }



    @Test
    @DisplayName("Korreoa ez da ezistitzen probatzen")
    void ezistitzenDaEmailEz() throws SQLException {
        assertFalse(conn.ezistitzenDaEmail("zubiri@gmail.com"), "[-] Korreoa ezistitzen da");
    }

    @Test
    @DisplayName("Korreoa ezistitzen dela probatzen")
    void ezistitzenDaEmail() throws SQLException {
        assertTrue(conn.ezistitzenDaEmail("topol@gmail.com"), "[-] Korreoa ez da ezistitzen");
    }

    @Test
    @DisplayName("Erabiltzailea ezistitzen da")
    void ezistitzenDaErabiltzailea() throws SQLException {
        assertTrue(conn.ezistitzenDaErabiltzailea("sebastopol"), "[-] Erabiltzailea ez da ezistitzen");
    }

    @Test
    @DisplayName("Erabiltzailea ez da ezistitzen")
    void ezEzistitzenDaErabiltzailea() throws SQLException {
        assertFalse(conn.ezistitzenDaErabiltzailea("Muse"), "[-] Erabiltzailea ezistitzen da");
    }


    @Test
    @RepeatedTest(3)
    @DisplayName("Pelikula lortu")
    void testPelikulaLortu() throws SQLException {
        assertNotNull(conn.pelikulaLortu(), "[-] Ezin izan da pelikula bat lortu");
    }

    @Test
    @RepeatedTest(3)
    @DisplayName("Jurasic Park Pelikula lortu ID bitartez")
    void jurasicTtestPelikulaLortu() throws SQLException {
        Pelikulak jurasic = new Pelikulak(101, "Jurassic Park", "Acci�n/Aventura", 900000000,63000000, "https://www.youtube.com/watch?v=lc0UehYemQA", "https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", 19930611, 201);
        assertEquals(conn.pelikulaLortu(101), jurasic, "[-] Ezin izan da Jurasic Park pelikula lortu");
    }

    @Test
    @RepeatedTest(3)
    @DisplayName("Jurasic Park Pelikula lortu izenaren bitartez")
    void jurasicTestPelikulaLortu() throws SQLException {
        Pelikulak jurasic = new Pelikulak(101, "Jurassic Park", "Acci�n/Aventura", 900000000,63000000, "https://www.youtube.com/watch?v=lc0UehYemQA", "https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", 19930611, 201);
        assertEquals(conn.pelikulaLortu("Jurassic Park"), jurasic, "[-] Ezin izan da Jurasic Park pelikula lortu");
    }


    @Test
    void ikusitakoPelikulak() {
    }


    @Test
    void gehituIkusitakoPeli() {
    }

    @Test
    void listanDago() throws SQLException {
        assertFalse(conn.listanDago(101), "[-] Pelikula listan dago");
    }

    @Test
    void notaAldatu() {
    }

    @Test
    void listatikanBorratu() {
    }

    @Test
    @RepeatedTest(3)
    @DisplayName("Aktore bat aleatorioko lortu")
    void aktoreaLortu() throws SQLException {
        assertNotNull(conn.aktoreaLortu(), "[-] Ezin izan da akto bat lortu");
    }

    @Test
    @RepeatedTest(3)
    @DisplayName("Lortu aktore bat ID-aren bitartez")
    void testAktoreaLortu() throws SQLException {
        Aktoreak aktorea = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");
        assertEquals(aktorea, conn.aktoreaLortu(110), "[-] Aktorea ez da berbera");
    }

    @Test
    @RepeatedTest(3)
    @DisplayName("Lortu aktore bat Izenaren-aren bitartez")
    void testAktoreaLortuString() throws SQLException {
        Aktoreak aktorea = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");
        assertEquals(aktorea, conn.aktoreaLortu("Tom", "Hanks"), "[-] Aktorea ez da berbera");
    }


    @Test
    void azkenekoID() {
    }

    @Test
    void azkenekoPelikula() {
    }

    @Test
    void lehenengoPelikula() {
    }

    @Test
    void azkenekoAktorea() {
    }

    @Test
    void lehenengoAktorea() {
    }

    @Test
    void konexiaEgin() {
    }

    @Test
    void konexioaItxi() {
    }

    @Test
    void getBezero() {
    }
}