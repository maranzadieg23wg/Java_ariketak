package GUI.LogIn;

import Objetuak.DB.Bezero;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class KonfigurazioaTest {

    @Test
    void aldatuInformazioa() throws SQLException {

        Bezero bezero = new Bezero(0, "proba", "abizena", "proba@gmail.com", "proba");

        boolean aldatuta =Konfigurazioa.aldatuInformazioa(bezero, "proba@wg.com", "123", "proba", "proba", "proba");

        assertFalse(aldatuta, "[-] Bezeroaren informazioa aldatu egin da");
    }
}