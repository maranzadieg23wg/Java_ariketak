import java.util.Scanner;

public class Ikastaro {

    private int id;
    private String izena;
    private int orduak;


    public Ikastaro(int id, String izena, int orduak) {
        this.id = id;
        this.izena = izena;
        this.orduak = orduak;
    }

    public Ikastaro() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        this.id = sc.nextInt();
        sc.nextInt();

        System.out.print("Izena: ");
        this.izena = sc.nextLine();

        System.out.print("Orduak: ");
        this.orduak = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Ikastaro{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", orduak=" + orduak +
                '}';
    }

    public int getId() {
        return id;
    }
}
