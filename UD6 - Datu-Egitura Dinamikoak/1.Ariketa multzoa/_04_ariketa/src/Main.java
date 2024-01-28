public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda(6);


        int[] telefono1 = {12345678, 87654321, 19283746};
        int[] telefono2 = {98765432, 13579246, 24681357};
        int[] telefono3 = {11112222, 33334444, 55556666};
        int[] telefono4 = {99998888, 77776666, 44445555};
        int[] telefono5 = {88887777, 22221111, 66669999};
        int[] telefono6 = {44443333, 66665555, 66669999};
        int[] telefono7 = {11111111, 22222222, 33333333};



        agenda.gehituSarrera("Manolo",telefono1);
        agenda.gehituSarrera("Julen",telefono2);
        agenda.gehituSarrera("Ivan",telefono3);
        agenda.gehituSarrera("Ibai",telefono4);
        agenda.gehituSarrera("Castafiore",telefono5);
        agenda.gehituSarrera("Xuban",telefono6);
        //agenda.gehituSarrera("Xuban2",telefono6);



        agenda.erakutsi();
        //agenda.bilatuIzena("Xuban");
        //agenda.bilatuIzena("Xuban");
        //System.out.println(agenda.zenbakiKopurua(66669999));

        agenda.gehituSarrera("Xuban",telefono7);
        agenda.bilatuIzena("Xuban");







    }
}