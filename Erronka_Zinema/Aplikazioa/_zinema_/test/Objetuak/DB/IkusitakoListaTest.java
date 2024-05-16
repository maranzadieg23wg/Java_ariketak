package Objetuak.DB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IkusitakoListaTest {


    IkusitakoLista lista = new IkusitakoLista();
    @Test
    void testToString() {
        assertNotNull(lista.toString(), "[-] Lista uztzik dago");
    }
}