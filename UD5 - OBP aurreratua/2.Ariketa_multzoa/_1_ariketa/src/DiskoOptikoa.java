public abstract class DiskoOptikoa {

    public double edukiera;
    public String unitatea;
    public int okupatutakoPortz;
    public boolean birgrabagarria;

    public DiskoOptikoa(double edukiera, String unitatea, int okupatutakoPortz, boolean birgrabagarria) {
        this.edukiera = edukiera;
        this.unitatea = unitatea;
        this.okupatutakoPortz = okupatutakoPortz;
        this.birgrabagarria = birgrabagarria;
    }

    public abstract void irakurri();
    public abstract void grabatu(double kantitatea);

}
