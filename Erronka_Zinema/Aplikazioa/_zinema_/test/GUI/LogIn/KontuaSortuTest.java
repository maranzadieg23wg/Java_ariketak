package GUI.LogIn;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class KontuaSortuTest {


    @Test
    void kontuaSort() throws SQLException {

        int sortuta = KontuaSortu.kontuaSort("kaixo@gmail.com", "5455215462125456", "Kaixo", "Agur", "kaixo");

        assertEquals(0, sortuta, "[-] Kontua ez da sortu");
    }
}