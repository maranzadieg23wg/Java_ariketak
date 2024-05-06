package Objetuak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BezeroTest {

    Bezero bezero =new Bezero(1,"NIGHT", "WISH", "NIGHTWISH@gmail.com", "NIGHTWISH");

    @Test
    @DisplayName("Erabiltzailearen ID-a egokia den konprobatu egiten da.")
    void getIdErabiltzailea() {
        assertEquals(1, bezero.getIdErabiltzailea(), "[-]Lortu egin den ID-ak ez da berbera");
    }

    @Test
    @DisplayName("Erabiltzailearen izena egokia den konprobatu egiten da.")
    void getErabiltzaileIzena() {
        assertEquals("NIGHTWISH", bezero.getErabiltzaileIzena().toString(), "[-]Lortu egin den izena ez da berbera");
    }


}