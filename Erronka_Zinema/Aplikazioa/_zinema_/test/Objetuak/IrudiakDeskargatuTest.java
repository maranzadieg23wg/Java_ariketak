package Objetuak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IrudiakDeskargatuTest {


    @Test
    void irudiaDeskargatu() {
        String url = IrudiakDeskargatu.irudiaDeskargatu("https://pics.filmaffinity.com/mad_max_fury_road-429261909-mmed.jpg", "./irudiak/pelikulak");
        assertEquals("./irudiak/pelikulak/mad_max_fury_road-429261909-mmed.jpg", url, "[-]Deskargatu egin den irudia ez dago ongi gordeta");
    }


}