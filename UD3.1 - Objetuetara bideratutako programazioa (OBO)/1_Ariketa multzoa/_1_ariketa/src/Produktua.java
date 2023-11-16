public class Produktua {

    String izena;
    double prezioa;
    int kopurua;


    //eraikitzailea da
    public Produktua(String i, double p, int k){
        //deitzen dugunean funtzioari izena balioan gehitzean i izenarekin deituko diogu beste fitxategitik.
        //i deitzen dio aldagai lokalari, eta izena aldagai generalari
        //Ezin dute izen berberak eduki.
        //.this erabili behar da aldagai generarali deitzeko bi baloreek izen berbera badaukate
        this.izena = i;
        this.prezioa = p;
        this.kopurua = k;
    }

    //imprimatzeko produktuen datuak
    public void erakutsiProduktuak(){
        System.out.println(izena + " - "+prezioa+"€ - "+kopurua);
    }

}
