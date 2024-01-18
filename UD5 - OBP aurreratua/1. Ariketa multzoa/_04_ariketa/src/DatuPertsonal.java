public class DatuPertsonal {

    private String txoriIzena;
    private String jabeIzena;

    DatuPertsonal(String txorilzena, String jabelzena) {
        this.txoriIzena = txorilzena;
        this.jabeIzena = jabelzena;
    }

    String getTxoriIzena() {
        return txoriIzena;
    }

    void setTxoriIzena(String txoriIzena) {
        this.txoriIzena = txoriIzena;
    }

    String getJabeIzena() {
        return jabeIzena;
    }

    void setJabeIzena(String jabeIzena) {
        this.jabeIzena = jabeIzena;
    }
}
