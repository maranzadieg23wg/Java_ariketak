public class Main {
    public static void main(String[] args) {


        DatuPertsonal i1 = new DatuPertsonal("Piolin", "Doña Petuñia");
        DatuPertsonal i2 = new DatuPertsonal("Castafiore", "Hadock");
        DatuPertsonal i3 = new DatuPertsonal("Julen", "Manex");
        DatuPertsonal i4 = new DatuPertsonal("Patxi", "Manolo");


        Piolin p1 = new Piolin('M', 4, 5 , 4, i1);
        Piolin p2 = new Piolin('M', 4, 5 , 4, i3);
        Piolin p3 = new Piolin('M', 4, 5 , 4, i4);


       p1.norNaiz();
       p2.norNaiz();
       p3.norNaiz();

       p1.setJabeIzena("Lucas");
       p1.setTxoriIzena("Bunny");

       p1.norNaiz();


       Loro l1 = new Loro('E', 24, 'I', "Gorria", i2);

       System.out.println("Txori Kopurua: ");

        p1.abestu();
        l1.abestu();

    }
}