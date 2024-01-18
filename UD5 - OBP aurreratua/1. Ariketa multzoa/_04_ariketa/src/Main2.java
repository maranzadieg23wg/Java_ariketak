public class Main2 {
    public static void main(String[] args) {



        Txori[] txoriLista = new Txori[10];


        DatuPertsonal i1 = new DatuPertsonal("Piolin", "Doña Petuñia");
        DatuPertsonal i2 = new DatuPertsonal("Castafiore", "Hadock");
        DatuPertsonal i3 = new DatuPertsonal("Julen", "Manex");
        DatuPertsonal i4 = new DatuPertsonal("Patxi", "Manolo");
        DatuPertsonal i5 = new DatuPertsonal("Hernandez", "Fernandez");
        DatuPertsonal i6 = new DatuPertsonal("Milu", "Tintin");


        txoriLista [1]= new Piolin('M', 4, 5 , 4, i1);
        txoriLista [2]= new Piolin('M', 4, 5 , 4, i3);
        txoriLista [3] = new Piolin('M', 4, 5 , 4, i4);




        txoriLista [4] = new Loro('E', 24, 'I', "Gorria", i2);
        txoriLista [5] = new Loro('E', 24, 'I', "Gorria", i5);
        txoriLista [6] = new Loro('E', 24, 'I', "Gorria", i6);





        System.out.println("Txori Kopurua: "+Txori.getTxoriKop());



    }
}