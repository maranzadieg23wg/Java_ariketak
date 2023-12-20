public class Main {
    public static void main(String[] args) {


        Piolon p1 = new Piolon('M', 4, 5 , 4);
        Loro l1 = new Loro('E', 24, 'I', "Gorria");

        l1.norNaiz();

        p1.neurtu();

        l1.nongoaZara();

        p1.setTamaina(31);
        p1.neurtu();

        l1.setZonaldea('H');
        l1.nongoaZara();

        System.out.println(Txori.getTxoriKop());

    }
}