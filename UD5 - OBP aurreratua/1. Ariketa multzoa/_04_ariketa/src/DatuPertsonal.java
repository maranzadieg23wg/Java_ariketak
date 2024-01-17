public class DatuPertsonal {

    private String txorilzena;
    private String jabelzena;

    DatuPertsonal(String txorilzena, String jabelzena) {
        this.txorilzena = txorilzena;
        this.jabelzena = jabelzena;
    }

    String getTxorilzena() {
        return txorilzena;
    }

    void setTxorilzena(String txorilzena) {
        this.txorilzena = txorilzena;
    }

    String getJabelzena() {
        return jabelzena;
    }

    void setJabelzena(String jabelzena) {
        this.jabelzena = jabelzena;
    }
}
