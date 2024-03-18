public abstract class Grabatzeko extends InformazioaEuskarria{

    public String unitatea;
    public int okupatutakoPortz;

    public Grabatzeko(double edukiera, String unitatea, int okupatutakoPortz) {
        super(edukiera);
        this.unitatea = unitatea;
        this.okupatutakoPortz = okupatutakoPortz;
    }

    public abstract void grabatu(double kantitatea);
}
