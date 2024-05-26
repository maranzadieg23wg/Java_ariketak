package GUI.LogIn;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KontuaSortuTest {


    @Test
    void kontuaSort() throws SQLException {

        int sortuta = KontuaSortu.kontuaSort("kaixo@gmail.com"+ Math.random(), "5455215462125456", "Kaixo", "Agur", "kaixo"+Math.random());

        assertEquals(0, sortuta, "[-] Kontua ez da sortu");
    }
}