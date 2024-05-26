package Objetuak.cookies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {


    @Test
    @DisplayName("Cachea borratu")
    void CacheBorratu() throws SQLException, IOException {
        assertTimeout(Duration.ofMillis(1000), () -> Cookie.borratuCache());
    }

    @Test
    @DisplayName("Saioa hasi")
    void SaioaHasi() throws SQLException, IOException {
        assertEquals(null, Cookie.saioCookie(), "[-] Saioa asi egin da, ez zenean egin behar");
    }

    @Test
    @DisplayName("Saioa hasi True")
    void SaioaHasiTrue() throws SQLException, IOException {
        assertEquals(null, Cookie.saioCookie(), "[-] Saioa ez da hasi");
    }

}