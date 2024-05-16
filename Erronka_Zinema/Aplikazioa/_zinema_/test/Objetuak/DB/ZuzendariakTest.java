package Objetuak.DB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZuzendariakTest {

    Zuzendariak zuz = new Zuzendariak(10, "Tarantino", "Quentin", 1960, "Man", "https://images.mubicdn.net/images/cast_member/1264/cache-85925-1528261523/image-w856.jpg");

    @Test
    void getIrudia() {
        assertEquals("https://images.mubicdn.net/images/cast_member/1264/cache-85925-1528261523/image-w856.jpg", zuz.getIrudia(), "[-] Lortutako URL-a ez da egokia");
    }

    @Test
    void getIrudiaLokalki() {
        assertEquals("./irudiak/zuzendari/image-w856.jpg", zuz.getIrudiaLokalki());
    }

    @Test
    void setIrudiaLokalki() {
        assertDoesNotThrow(zuz.setIrudiaLokalki("proba"), "[-] Ez da egon arazorik");
    }

    @Test
    void testToString() {

    }

    @Test
    void testEquals() {
        Zuzendariak zuz1 = new Zuzendariak(10, "Tarantino", "Quentin", 1960, "Man", "https://images.mubicdn.net/images/cast_member/1264/cache-85925-1528261523/image-w856.jpg");

        assertNotEquals(zuz, zuz1, "[-] Berberak dira");
    }


    @Test
    void lokalIrudia() {

        assertDoesNotThrow(zuz.lokalIrudia, "[-] Irudia ongi deskargatu egin da");

    }
}