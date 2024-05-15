package Objetuak;

import Objetuak.DB.Aktoreak;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AktoreakTest {

    Aktoreak aktorea = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");

    @Test
    @DisplayName("Ezarri irudiaren ULR-a")
    void setirudiaLokalki() {
        aktorea.setirudiaLokalki("proba.jpg");
        getIrudiaLokalki();
    }


    @DisplayName("Konprobatu ea irudiak berberak diren")
    void getIrudiaLokalki() {
        String url = aktorea.getIrudiaLokalki();
        assertEquals("proba.jpg", url, "[-]Lortu egin den URL-a ez da berbera");
    }

    @Test
    @DisplayName("Konprobatu ea irudiak berberak diren")
    void getIrudia() {
        String url = aktorea.getIrudia();
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg", url, "[-] Lortu egin den irudia ez da berbera");
    }


    @Test
    @DisplayName("Komprobatu ea berberak diren")
    void testEquals() {
        Aktoreak aktorea2 = new Aktoreak(110, "Tom", "Hanks", "1956-07-09 00:00:00", "Estadounidense", "tom@example.com", "123456789", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Tom_Hanks_2014.jpg/475px-Tom_Hanks_2014.jpg");
        assertEquals(aktorea, aktorea2, "[-]Bi aktoreak ez dira berberak");
    }


}