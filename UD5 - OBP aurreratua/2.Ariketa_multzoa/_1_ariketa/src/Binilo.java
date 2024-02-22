public class Binilo extends InformazioaEuskarria implements Diskoa{

    public Binilo(double edukiera) {
        super(edukiera);
    }

    @Override
    public void irakurri() {
        System.out.println("Binilo dispositibo bat irakurtzen");
    }


    @Override
    public void biratu() {
        System.out.println("Binilo dispositiboa 210 rpm abiaduran biratzen du");
    }
}
