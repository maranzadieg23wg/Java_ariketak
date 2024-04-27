package DatuBase;

import Objetuak.Aktoreak;
import Objetuak.Bezero;
import Objetuak.Pelikulak;
import org.junit.jupiter.api.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


import static org.junit.jupiter.api.Assertions.*;

class ConexioaTest {

    private static Conexioa conn;




    @BeforeAll
    @DisplayName("Ireki konexioa datu basearekin")
    static void konexioaIreki() throws SQLException {
        conn = new Conexioa();
    }

    @AfterAll
    @DisplayName("Itxi konexioa datu basearekin")
    static void konexioaItxi(){
        conn.konexioaItxi();
    }

    ConexioaTest() throws SQLException {
    }


    @Test
    @DisplayName("Erabiltzailea sortu")
    void sortuKontua() throws SQLException {
        boolean kontuaSortuta = conn.sortuKontua("NIGHTWISH@gmail.com", "123", "NIGHT", "NIGHTWISH ", "NIGHTWISH ");
        assertTrue(kontuaSortuta, "[-] Erabiltzailea ez da ongi sortu");

        erabiltzaileaBorratu();
    }

    @Test
    @DisplayName("Erabiltzailea borratu")
    void erabiltzaileaBorratu() throws SQLException {
        Bezero bezero = conn.getBezero();
        int borratuta = conn.erabiltzaileaBorratu(bezero);
        assertEquals(1, borratuta, "[-] Erabiltzailea ezin izan da borratu");
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


    @RepeatedTest(3)
    @DisplayName("Pelikula lortu")
    void testPelikulaLortu() throws SQLException {
        assertNotNull(conn.pelikulaLortu(), "[-] Ezin izan da pelikula bat lortu");
    }


    @RepeatedTest(3)
    @DisplayName("Jurasic Park Pelikula lortu ID bitartez")
    void jurasicTtestPelikulaLortu() throws SQLException {
        Pelikulak jurasic = new Pelikulak(101, "Jurassic Park", "Acci�n/Aventura", 900000000,63000000, "https://www.youtube.com/watch?v=lc0UehYemQA", "https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", 19930611, 201);
        assertEquals(conn.pelikulaLortu(101), jurasic, "[-] Ezin izan da Jurasic Park pelikula lortu");
    }


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


    @RepeatedTest(3)
    @DisplayName("Aktore bat aleatorioko lortu")
    void aktoreaLortu() throws SQLException {
        assertNotNull(conn.aktoreaLortu(), "[-] Ezin izan da akto bat lortu");
    }


    @RepeatedTest(3)
    @DisplayName("Lortu aktore bat ID-aren bitartez")
    void testAktoreaLortu() throws SQLException {
        Aktoreak aktorea = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");
        assertEquals(aktorea, conn.aktoreaLortu(110), "[-] Aktorea ez da berbera");
    }


    @RepeatedTest(3)
    @DisplayName("Lortu aktore bat Izenaren-aren bitartez")
    void testAktoreaLortuString() throws SQLException {
        Aktoreak aktorea = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");
        assertEquals(aktorea, conn.aktoreaLortu("Tom", "Hanks"), "[-] Aktorea ez da berbera");
    }


    @Test
    @DisplayName("Bezeroen azkeneko ID-a")
    void azkenekoID() throws SQLException {
        int azkeneko = conn.azkenekoID();

        assertEquals(3, azkeneko, "[-] Lortu den ID-a ez da azkenekoa erabiltzailearena");

    }

    @Test
    @DisplayName("Azkeneko pelikularen ID-a")
    void azkenekoPelikula() throws SQLException {
        int azkeneko = conn.azkenekoPelikula();
        assertEquals(120, azkeneko, "[-] Lortu den ID-a ez da azkeneko pelikularena");
    }

    @Test
    @DisplayName("Lehenengo pelikularen ID-a")
    void lehenengoPelikula() throws SQLException {
        int lehenengoa = conn.lehenengoPelikula();
        assertEquals(101, lehenengoa, "[-] Lortu den ID-a ez da lehenengo pelikularena");
    }

    @Test
    @DisplayName("Azkeneko aktorea lortu")
    void azkenekoAktorea() throws SQLException {
        int azkenekoa = conn.azkenekoAktorea();
        assertEquals(110, azkenekoa, "[-] Ez da lortu azkeneko aktorea");
    }

    @Test
    @DisplayName("Lehenengo aktorea lortu")
    void lehenengoAktorea() throws SQLException {
        int lehenegoa = conn.lehenengoAktorea();
        assertEquals(101, lehenegoa, "[-] Ez da lortu lehenengo aktorea");
    }


}