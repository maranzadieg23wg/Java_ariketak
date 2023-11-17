public class Main {
    public static void main(String[] args) {

    //Estadistika klase bat sortzen
    Estatistika p1 = new Estatistika();

    //Gehitu zenbaki bat klasera
    p1.gehituZenbaki(1);
    p1.gehituZenbaki(2);
    p1.gehituZenbaki(3);
    p1.gehituZenbaki(4);
    p1.gehituZenbaki(5);

    //Deitzen diogu zenbat Zenbaki funtzioari gehitzeko gehitu ditugun.
    p1.zenbatZenbaki();

    //Deitzen diogu funtzioari erakusteko zein da sartu diren zenbakien media.
    p1.media();



    }
}