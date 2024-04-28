package Objetuak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelikulakTest {

    Pelikulak jurasic = new Pelikulak(101, "Jurassic Park", "Acci�n/Aventura", 900000000,63000000, "https://www.youtube.com/watch?v=lc0UehYemQA", "https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", 19930611, 201);




    @Test
    @DisplayName("Ezarri lokalki irudiaren URL-a")
    void setirudiaLokalki() {
        jurasic.setirudiaLokalki("Park.jpg");

        getIrudiaLokalki();
    }

    @Test
    @DisplayName("Ikusi ea lokalki dagoen irudiaren URl egokia den")
    void getIrudiaLokalki() {



        assertEquals("Park.jpg", jurasic.getIrudiaLokalki(), "[-]Lokalki dagoen gordetako URL-a ez da egokia");
    }

    @Test
    @DisplayName("Interneko URL-a ez da berbera.")
    void getIrudia() {
        String url = jurasic.getIrudia();
        assertEquals("https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", url, "[-]Irudiaren URL-a ez da egokia");
    }

    @Test
    @DisplayName("Konprobatu ea ongi begiratzen dituen objetuak")
    void testEquals() {
        Pelikulak jurasic1 = new Pelikulak(101, "Jurassic Park", "Acci�n/Aventura", 900000000,63000000, "https://www.youtube.com/watch?v=lc0UehYemQA", "https://hips.hearstapps.com/hmg-prod/images/1202186-copia-64f056b7a8612.jpg", 19930611, 201);

        assertEquals(jurasic1, jurasic, "[-]Pelikula objetua ez da egokia");
    }


}