package Objetuak;

import Objetuak.DB.Bezero;
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

    @Test
    @DisplayName("Erabiltzailearen Izena egokia den a la ez ikusten da.")
    void getIzena() {
        assertEquals("NIGHT", bezero.getIzena(), "[-]Lortu egin den ID-ak ez da berbera");
    }

    @Test
    @DisplayName("Erabiltzailearen abizena egokia den a la ez ikusten da.")
    void getAbizena() {
        assertEquals("WISH", bezero.getAbizena(), "[-]Lortu egin den izena ez da berbera");
    }

    @Test
    @DisplayName("Erabiltzailearen Emaila egokia den a la ez ikusten da.")
    void getEmaila() {
        assertEquals("NIGHTWISH@gmail.com", bezero.getEmaila(), "[-]Lortu egin den ID-ak ez da berbera");
    }

    @Test
    @DisplayName("Erabiltzailea berbera da")
    void equals() {
        assertEquals(bezero, bezero, "[-]Lortu egin den izena ez da berbera");
    }

    @Test
    @DisplayName("Erabiltzailea Hash a egokia da")
    void hashCode1() {

        assertEquals(-384564386, bezero.hashCode(), "[-]Lortu egin den izena ez da berbera");
    }


}