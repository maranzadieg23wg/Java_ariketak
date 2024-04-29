package Objetuak;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

class IrudiakDeskargatuTest {


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void irudiaDeskargatu() {
        String url = IrudiakDeskargatu.irudiaDeskargatu("https://pics.filmaffinity.com/mad_max_fury_road-429261909-mmed.jpg", "irudiak/pelikula");
        assertEquals("irudiak/pelikula\\mad_max_fury_road-429261909-mmed.jpg", url, "[-]Deskargatu egin den irudia ez dago ongi gordeta");
    }


}