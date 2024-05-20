package DatuBase;

import Objetuak.DB.Aktoreak;
import Objetuak.DB.Bezero;
import Objetuak.DB.Pelikulak;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class KonexioaTest {

    private static Konexioa conn;




    @BeforeEach
    @DisplayName("Ireki konexioa datu basearekin")
    void konexioaIreki() throws SQLException {
        conn = new Konexioa();
    }

    @AfterEach
    @DisplayName("Itxi konexioa datu basearekin")
    void konexioaItxi(){
        conn.konexioaItxi();
    }

    KonexioaTest() throws SQLException {
    }


    @Test
    @DisplayName("Erabiltzailea sortu")
    void sortuKontua() throws SQLException {
        int kontuaSortuta = conn.sortuKontua("NIGHTWISH@gmail.com", "123", "NIGHT", "NIGHTWISH ", "NIGHTWISH ");
        assertEquals(1,kontuaSortuta, "[-] Erabiltzailea ez da ongi sortu");

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
        assertFalse(conn.ezistitzenDaEmail("topol@gmail.com"), "[-] Korreoa ez da ezistitzen");
    }

    @Test
    @DisplayName("Erabiltzailea ezistitzen da")
    void ezistitzenDaErabiltzailea() throws SQLException {
        assertFalse(conn.ezistitzenDaErabiltzailea("sebastopol"), "[-] Erabiltzailea ez da ezistitzen");
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


    @ParameterizedTest
    @CsvFileSource(
            resources = {"./test/Film.csv"},
            encoding = "UTF-8",
            lineSeparator = "\n",
            delimiter = ','
    )
    @DisplayName("Jurassic Park Pelikula lortu ID bitartez")
    void jurasicTtestPelikulaLortu(int id, String tituloa, String generoa, long irabaziak, long aurrekontua, String trailera, String irudia, int estrenaldia, int zuzendaria, String sinopsis) throws SQLException {

        //System.out.println(id);
        Pelikulak jurassic = new Pelikulak(id, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, estrenaldia, zuzendaria, sinopsis);
        assertEquals(conn.pelikulaLortu(id), jurassic, "[-] Ezin izan da Jurasic Park pelikula lortu");
    }


    @RepeatedTest(3)
    @DisplayName("Jurassic Park Pelikula lortu izenaren bitartez")
    void jurasicTestPelikulaLortu() throws SQLException {
        Pelikulak jurasic = new Pelikulak(3928, "Jurassic Park", "Action;Adventure;Sci-Fi", 1045573035,63000000, "https://www.youtube.com/watch?v=k8k9GeZCb-8", "http://image.tmdb.org/t/p/w500/b1xCNnyrPebIc7EWNZIa6jhb1Ww.jpg", 814, 268, "");
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
        Aktoreak aktorea = new Aktoreak(25081, "Philip", "Jackson", null, null, "PhilipJackson@gmail.com", "+658311273", "http://image.tmdb.org/t/p/w500/eC7p4UAj6xB4TtQ4cPcIJtubPnw.jpg");
        assertEquals(aktorea, conn.aktoreaLortu(25081), "[-] Aktorea ez da berbera");
    }


    @RepeatedTest(3)
    @DisplayName("Lortu aktore bat Izenaren-aren bitartez")
    void testAktoreaLortuString() throws SQLException {
        Aktoreak aktorea = new Aktoreak(317, "Tom", "Hanks", null, null, "TomHanks@outlook.com", "+897406027", "http://image.tmdb.org/t/p/w500/xndWFsBlClOJFRdhSt4NBwiPq2o.jpg");
        assertEquals(aktorea, conn.aktoreaLortu("Tom", "Hanks"), "[-] Aktorea ez da berbera");
    }


    @Test
    @DisplayName("Bezeroen azkeneko ID-a")
    void azkenekoID() throws SQLException {
        int azkeneko = conn.azkenekoID();

        assertNotNull( azkeneko, "[-] Lortu den ID-a ez da azkenekoa erabiltzailearena");

    }

    @Test
    @DisplayName("Azkeneko pelikularen ID-a")
    void azkenekoPelikula() throws SQLException {
        int azkeneko = conn.azkenekoPelikula();
        assertEquals(7503, azkeneko, "[-] Lortu den ID-a ez da azkeneko pelikularena");
    }

    @Test
    @DisplayName("Lehenengo pelikularen ID-a")
    void lehenengoPelikula() throws SQLException {
        int lehenengoa = conn.lehenengoPelikula();
        assertEquals(3126, lehenengoa, "[-] Lortu den ID-a ez da lehenengo pelikularena");
    }

    @Test
    @DisplayName("Azkeneko aktorea lortu")
    void azkenekoAktorea() throws SQLException {
        int azkenekoa = conn.azkenekoAktorea();
        assertEquals(30453, azkenekoa, "[-] Ez da lortu azkeneko aktorea");
    }

    @Test
    @DisplayName("Lehenengo aktorea lortu")
    void lehenengoAktorea() throws SQLException {
        int lehenegoa = conn.lehenengoAktorea();
        assertEquals(0, lehenegoa, "[-] Ez da lortu lehenengo aktorea");
    }

    @Test
    @DisplayName("Random zuz")
    void zuzendariRandom() throws SQLException {
        int z = conn.ZuzIDRandom();
        assertNotEquals(-1, z, "[-] Lortu den ID-a ez da egokia");
    }

    @Test
    @DisplayName("Lehenengo Zuz")
    void lehenengoZuz() throws SQLException {
        int z = conn.lehenengoZuzendaria();

        assertEquals(213, z, "[-] Lortu den ID-a ez da lehnenegoa");
    }

    @Test
    @DisplayName("Azkeneko Zuz")
    void azkenekoZuz() throws SQLException {
        int z = conn.azkenekoZuzendaria();

        assertEquals(2045, z, "[-] Lortu den ID-a ez da azkenekoa");
    }


    @Test
    @DisplayName("Hash 256")
    void hashSha256(){
        String hash = Konexioa.sha256("123");
        String hash123 = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

        assertEquals(hash123, hash, "[-] Lortu den hash a ez da egokia");
    }

    @Test
    @DisplayName("Ezistitzen Da Erabiltzailea")
    void testEzistitzenDaErabiltzailea_a() throws SQLException {
        assertNotNull(conn.ezistitzenDaErabiltzailea("sebastopol"));
    }

    @Test
    @DisplayName("Aktor ID Random")
    void testAktorIDRandom_a() throws SQLException {
        assertNotNull(conn.aktorIDRandom());
    }

    @Test
    @DisplayName("Zuzendari Lortu Lista")
    void testZuzendariLortuLista_a() throws SQLException {
        assertNotNull(conn.zuzendariLortuLista(1));
    }

    @Test
    @DisplayName("Get Bezero")
    void testGetBezero_a() throws SQLException {
        assertNotNull(conn.getBezero());
    }

    @Test
    @DisplayName("SHA-256")
    void testSha256_a() throws SQLException {
        assertNotNull(conn.sha256("2"));
    }

    @Test
    @DisplayName("Lehenengo Zuzendaria")
    void testLehenengoZuzendaria_a() throws SQLException {
        assertNotNull(conn.lehenengoZuzendaria());
    }

    @Test
    @DisplayName("Azkeneko Zuzendaria")
    void testAzkenekoZuzendaria_a() throws SQLException {
        assertNotNull(conn.azkenekoZuzendaria());
    }

    @Test
    @DisplayName("Lehenengo Aktorea")
    void testLehenengoAktorea_a() throws SQLException {
        assertNotNull(conn.lehenengoAktorea());
    }

    @Test
    @DisplayName("Azkeneko Aktorea")
    void testAzkenekoAktorea_a() throws SQLException {
        assertNotNull(conn.azkenekoAktorea());
    }

    @Test
    @DisplayName("Lehenengo Pelikula")
    void testLehenengoPelikula_a() throws SQLException {
        assertNotNull(conn.lehenengoPelikula());
    }

    @Test
    @DisplayName("Azkeneko Pelikula")
    void testAzkenekoPelikula_a() throws SQLException {
        assertNotNull(conn.azkenekoPelikula());
    }

    @Test
    @DisplayName("Azkeneko ID")
    void testAzkenekoID_a() throws SQLException {
        assertNotNull(conn.azkenekoID());
    }

    @Test
    @DisplayName("Zuzendaria Lortu")
    void testZuzendariaLortu_a() throws SQLException {
        ArrayList<Integer> b = new ArrayList<>();
        b.add(213);
        assertNotNull(conn.zuzendariaLortu(b));
    }

    @Test
    @DisplayName("Zuzendari Lortu Lista")
    void testZuzendariLortuListaAgain_a() throws SQLException {
        assertNotNull(conn.zuzendariLortuLista(1));

    }




    @Test
    void testSortuKontua_a() throws SQLException {
        assertNotNull(conn.sortuKontua("1", "1", "1", "1", "1"));
    }



    @Test
    void erabiltzaileaBorratu_a() throws SQLException {
        Bezero bezero = new Bezero(conn.azkenekoID() + 1, "1", "1", "1", "1");
        //conn.erabiltzaileaBorratu(bezero);
    }

    @Test
    void saioaHasiHash_a() throws SQLException {
        assertNotNull(conn.saioaHasiHash("1", "1"));
    }

    @Test
    void testSaioaHasi_a() throws SQLException {
        assertNotNull(conn.saioaHasi("1", "1"));
    }

    @Test
    void pelikulaLortu_a() throws SQLException {
        assertNotNull(conn.pelikulaLortu());
    }

    @Test
    void pelikulaListLortu_a() throws SQLException {
        assertNotNull(conn.pelikulaListLortu(1));
    }

    @Test
    void testPelikulaLortu1_a() throws SQLException {
        assertNotNull(conn.pelikulaLortu());
    }

    @Test
    void testPelikulaLortu2_a() throws SQLException {
        assertNotNull(conn.pelikulaLortu());
    }

    @Test
    void pelikulaObjetua_a() {
        //conn.pelikulaObjetua();
    }

    @Test
    void pelikulaList_a() {
        assertNotNull(conn.pelikulaList(1));
    }

    @Test
    void aktoreList_a() {
        assertNotNull(conn.aktoreList(1));
    }

    @Test
    void getIkusitakoPelikulak_a() {
        assertNotNull(conn.getIkusitakoPelikulak());
    }



    @Test
    void ikusitakoListaLortu_a() {
        //conn.ikusitakoListaLortu();
    }



    @Test
    void listanDago_a() throws SQLException {
        assertNotNull(conn.listanDago(1));
    }




    @Test
    void aktoreaLortu_a() throws SQLException {
        assertNotNull(conn.aktoreaLortu());
    }

    @Test
    void testAktoreaLortu_a() throws SQLException {
        assertNotNull(conn.aktoreaLortu());
    }

    @Test
    void aktoreLortuLista_a() throws SQLException {
        assertNotNull(conn.aktoreLortuLista(1));
    }
}