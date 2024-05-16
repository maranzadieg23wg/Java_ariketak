package GUI.LogIn;

import Objetuak.DB.Bezero;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaioaHasiTest {

    @Test
    void saioa() throws SQLException {
        Bezero bezero = SaioaHasi.saioa("topol@gmail.com", "123");

        assertNotNull(bezero, "[-] Saioa ez da asi");

    }

    @Test
    void saioaEra() throws SQLException {
        Bezero bezero = SaioaHasi.saioa("sebastopol", "123");

        assertNotNull(bezero, "[-] Saioa ez da asi");

    }
}