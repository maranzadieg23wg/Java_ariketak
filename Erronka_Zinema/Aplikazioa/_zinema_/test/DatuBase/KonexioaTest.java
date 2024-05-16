package DatuBase;

import Objetuak.DB.Aktoreak;
import Objetuak.DB.Pelikulak;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class KonexioaTest {

    private static Konexioa conn;




    @BeforeAll
    @DisplayName("Ireki konexioa datu basearekin")
    static void konexioaIreki() throws SQLException {
        conn = new Konexioa();
    }

    @AfterAll
    @DisplayName("Itxi konexioa datu basearekin")
    static void konexioaItxi(){
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


    @ParameterizedTest
    @CsvFileSource(
            resources = {"./test/Film.csv"},
            encoding = "UTF-8",
            lineSeparator = "\n",
            delimiter = ','
    )
    @DisplayName("Jurassic Park Pelikula lortu ID bitartez")
    void jurasicTtestPelikulaLortu(int id, String tituloa, String generoa, long irabaziak, long aurrekontua, String trailera, String irudia, int estrenaldia, int zuzendaria) throws SQLException {

        //System.out.println(id);
        Pelikulak jurassic = new Pelikulak(id, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, estrenaldia, zuzendaria);
        assertEquals(conn.pelikulaLortu(id), jurassic, "[-] Ezin izan da Jurasic Park pelikula lortu");
    }


    @RepeatedTest(3)
    @DisplayName("Jurassic Park Pelikula lortu izenaren bitartez")
    void jurasicTestPelikulaLortu() throws SQLException {
        Pelikulak jurasic = new Pelikulak(3928, "Jurassic Park", "Action;Adventure;Sci-Fi", 1045573035,63000000, "https://www.youtube.com/watch?v=k8k9GeZCb-8", "http://image.tmdb.org/t/p/w500/b1xCNnyrPebIc7EWNZIa6jhb1Ww.jpg", 814, 268);
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

        assertEquals(4, azkeneko, "[-] Lortu den ID-a ez da azkenekoa erabiltzailearena");

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
    @DisplayName("Saioa Hasi")
    void saioaHasi() throws SQLException {
        conn.saioaHasi();

        conn.erabiltzaileaAldatu(1, "1", "1", "1",",",",");

        conn.ezistitzenDaErabiltzailea("sebastopol");

        conn.sortuKontua();

        conn.menua();

        conn.aktorIDRandom();

        conn.zuzendariLortuLista(1);
        conn.aktorIDRandom();

    }


}