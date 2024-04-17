import java.sql.Date;
import java.util.Scanner;


public class Ikasle {

    private String id;
    private String izena;
    private String herria;
    private long telefonoa;
    private java.sql.Date jaiotzeData;
    private int ikastaroKodea;


    public Ikasle(String id, String izena, String herria, long telefonoa, java.sql.Date jaiotzeData, int ikastaroKodea) {
        this.id = id;
        this.izena = izena;
        this.herria = herria;
        this.telefonoa = telefonoa;
        this.jaiotzeData = jaiotzeData;
        this.ikastaroKodea = ikastaroKodea;
    }

    public Ikasle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        this.id = sc.nextLine();
        sc.nextInt();

        System.out.print("Izena: ");
        this.izena = sc.nextLine();

        System.out.print("Herria: ");
        this.herria = sc.nextLine();

        System.out.print("Telefonoa: ");
        this.telefonoa = sc.nextInt();
        sc.nextInt();

        System.out.print("Jaiotze Data: ");
        jaiotzeData = Date.valueOf(sc.nextLine());

        System.out.print("Ikastaro Kodea: ");
        this.ikastaroKodea = sc.nextInt();
    }

    public Ikasle(Ikasle ikasle) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID["+ikasle.getId()+"]: ");
        this.id = sc.nextLine();
        sc.nextInt();

        System.out.print("Izena["+ikasle.getIzena()+"]: ");
        this.izena = sc.nextLine();

        System.out.print("Herria["+ikasle.getHerria()+"]: ");
        this.herria = sc.nextLine();

        System.out.print("Telefonoa["+ikasle.getTelefonoa()+"]: ");
        this.telefonoa = sc.nextInt();
        sc.nextInt();

        System.out.print("Jaiotze Data["+ikasle.getJaiotzeData()+"]: ");
        jaiotzeData = Date.valueOf(sc.nextLine());

        System.out.print("Ikastaro Kodea["+ikasle.getIkastaroKodea()+"]: ");
        this.ikastaroKodea = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Ikasle{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", herria='" + herria + '\'' +
                ", telefonoa=" + telefonoa +
                ", JaiotzeData='" + jaiotzeData + '\'' +
                ", ikastaroKodea=" + ikastaroKodea +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getIzena() {
        return izena;
    }

    public String getHerria() {
        return herria;
    }

    public long getTelefonoa() {
        return telefonoa;
    }

    public Date getJaiotzeData() {
        return jaiotzeData;
    }

    public int getIkastaroKodea() {
        return ikastaroKodea;
    }
}
