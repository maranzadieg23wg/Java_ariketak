package DatuBase;
import Objetuak.DB.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Datu basearekin konexioa egiteko erabiltzen den objetua.
 * @author Manex Aranzadi Egaña
 */

public class Konexioa {

    //String ipa = "10.14.4.122";
    String ipa = "192.168.1.100";
    String DBIzena = "ORCLCDB";
    String username = "taldea3";
    String pasahitza = "batbihiru";


    Connection conn;
    Scanner sc;


    private static Bezero bezero;
    private static ArrayList<IkusitakoLista> ikusitakoPelikulak = new ArrayList<>();


    public Konexioa() throws SQLException {
        sc = new Scanner(System.in);

        konexiaEgin();


        //menua();
        //konexioaItxi();





    }

    /**
     * Interface graficoa erabili gabe hematen du aukera erabiltzeko programa. Ikusteko zure lista, sortu kontu bat eta abar.
     * @throws SQLException
     */
    /*void menua() throws SQLException {
        int aukera = 1;
        while (aukera !=0){


            System.out.println("1: Saioa hasi");
            System.out.println("2: Sortu kontua");
            System.out.println("3: Pelikula aleatorio bat lortu");
            System.out.println("4: Ikusi ikusitako lista");
            System.out.println("5: Gehitu ikusitako pelikula bat");
            System.out.println("0: Itxi");

            aukera = sc.nextInt();

            switch (aukera){
                case 1:
                    saioaHasi();
                    break;


                case 2:
                    sortuKontua();
                    break;

                case 3:
                    System.out.println(pelikulaLortu());
                    break;


                case 4:
                    ikusitakoPelikulak();

                    for (IkusitakoLista ikusi: ikusitakoPelikulak) {
                        System.out.println(ikusi);
                    }
                    break;

                case 5:

                    //gehituIkusitakoPeli(101, 1, 8.5F, 4);
                    //notaAldatu(101, 1, 9, 6);
                    //listatikanBorratu(101);
                    break;

                case 0:
                    aukera =0;
                    break;
                default:
                    System.out.println("Sartu duzun zenbakiak ez du balio");
                    break;


            }


        }




    }*/

    //*******************************SORTU KONTUA ******************************

    /**
     * Kontua sortzeko erabiltzen den funtzioa da
     * Sartu behar den informazioa da, emaila, pasahitza, izena, abizena, erabiltzailea
     * 0: kontua ongi sortu egin da
     * 1: emaila erabilita dago
     * 2: erabiltzailea erabilita dago
     * 3: beste arazo bat gertatu da
     *      * <blockquote>{@code sortuKontua("taldea3@gmail, 123, taldea3, zubiri, taldea3");}</blockquote>
     * @throws SQLException
     */

    public int sortuKontua(String email, String pasahitza, String izena, String abizena, String erabiltzailea) throws SQLException {


        String pasahitzaHash = sha256(pasahitza);
        pasahitza = null;


        //Begiratu ea existitzen den
        //ezistitzenDa(emaila);

        if (ezistitzenDaEmail(email)){

            System.err.println(email+" erabiltzailearekin kontu bat existitzen da");
            return 1;
        }else {

            if (ezistitzenDaErabiltzailea(erabiltzailea)){
                System.err.println(erabiltzailea+" erabiltzailea dagoenekoa badago.");
                return 2;
            }





            String sql2 = "Insert into ERABILTZAILEAK values (?, ?, ?, ?, ?, ?, null)";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql2);
            kontsulta2.setInt(1, azkenekoID()+1);
            kontsulta2.setString(2, izena);
            kontsulta2.setString(3, abizena);
            kontsulta2.setString(4, email);
            kontsulta2.setString(5, erabiltzailea);
            kontsulta2.setString(6, pasahitzaHash);

            int rowsAffected = kontsulta2.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Erabiltzailea ongi sortu egin da.");
                return 0;

            } else {
                System.err.println("Errore bat gertatu da erabiltzailea sortzean.");
                return 3;
            }

        }



    }
    /*void sortuKontua() throws SQLException {
        sc.nextLine();
        System.out.println("-----------KONTUA SORTU-----------");
        System.out.print("Emaila: ");
        String emaila = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        String pasahitzaHash = sha256(pasahitza);
        pasahitza = null;


        //Begiratu ea existitzen den
        //ezistitzenDa(emaila);

        if (ezistitzenDaEmail(emaila)){
            System.err.println(emaila+" erabiltzailearekin kontu bat existitzen da");
        }else {

            System.out.print("Izena: ");
            String izena = sc.nextLine();
            System.out.print("Abizena: ");
            String abizena = sc.nextLine();
            System.out.print("Erabiltzailea: ");
            String erabiltzailea = sc.nextLine();



            while (ezistitzenDaErabiltzailea(erabiltzailea)){


                System.out.println(erabiltzailea+" ezistitzenda.");

                System.out.print("Erabiltzailea: ");
                erabiltzailea = sc.nextLine();


            }





            String sql2 = "Insert into ERABILTZAILEAK values (?, ?, ?, ?, ?, ?, null)";
            PreparedStatement kontsulta2 = conn.prepareStatement(sql2);
            kontsulta2.setInt(1, azkenekoID()+1);
            kontsulta2.setString(2, izena);
            kontsulta2.setString(3, abizena);
            kontsulta2.setString(4, emaila);
            kontsulta2.setString(5, erabiltzailea);
            kontsulta2.setString(6, pasahitzaHash);

            int rowsAffected = kontsulta2.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Erabiltzailea ongi sortu egin da.");

            } else {
                System.err.println("Errore bat gertatu da erabiltzailea sortzean.");
            }

        }



    }*/

    /**
     * Erabiltzailea borratzeko erabiltzen da
     * @param bezero
     * @return Integer
     * @throws SQLException
     */
    int erabiltzaileaBorratu(Bezero bezero) throws SQLException {
        int id = bezero.getIdErabiltzailea();

        String sql = "Delete from ERABILTZAILEAK where ID_Erabiltzailea = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt (1, id);

        return kontsulta.executeUpdate();
    }

    public void erabiltzaileaAldatu(int id, String email, String pas, String izena, String abizena, String era){
        pas = sha256(pas);

        try {
            String sql = "update ERABILTZAILEAK set izena =?, abizena =?, emaila=?, erabiltzailea=?, pasahitza =? where ID_ERABILTZAILE = ?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setString(1, izena);
            kontsulta.setString(2, abizena);
            kontsulta.setString(3, email);
            kontsulta.setString(4, era);
            kontsulta.setString(5, pas);
            kontsulta.setInt(6, id);

            int rowsAffected = kontsulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Aldatu egin da erabiltzailearen datuak");

            } else {
                System.err.println("Errore bat gertatu da aldatzean informazioa");
            }
        }catch (SQLException e){
            System.err.println("Ezin izan da aldatu erabiltzailearen datuak");
            System.err.println("Message: "+e.getErrorCode());
        }

        try {
            saioaHasi(era, pas);
        }catch (SQLException e){
            System.err.println("Ezin izan da saioa hasi");
            System.err.println(e.getErrorCode());
        }


    }

    //***************************************SAIOA HASI****************************************
    public boolean saioaHasiHash(String email, String pasahitza) throws SQLException {

        String sql = "select * from ERABILTZAILEAK where (emaila = ? or erabiltzailea = ?) and pasahitza = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, email);
        kontsulta.setString(2, email);
        kontsulta.setString(3, pasahitza);

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()) {

            int idErabiltzailea = emaitza.getInt("ID_ERABILTZAILE");
            String izena = emaitza.getString("IZENA");
            String abizena = emaitza.getString("ABIZENA");
            String emaila = emaitza.getString("EMAILA");
            String erabiltzaile = emaitza.getString("ERABILTZAILEA");
            this.bezero = new Bezero(idErabiltzailea, izena, abizena, emaila, erabiltzaile);

            System.out.println("Saioa hasita");
            return true;


        } else {
            System.err.println(email + " datu basean ez dago erabiltzailerik datu hauekin");
            return false;
        }
    }
    public boolean saioaHasi(String email, String pasahitza) throws SQLException {

        try {
            String pasahitzaHash = sha256(pasahitza);

            String sql = "select * from ERABILTZAILEAK where (emaila = ? or erabiltzailea = ?) and pasahitza = ?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setString(1, email);
            kontsulta.setString(2, email);
            kontsulta.setString(3, pasahitzaHash);

            ResultSet emaitza = kontsulta.executeQuery();

            if (emaitza.next()) {

                int idErabiltzailea = emaitza.getInt("ID_ERABILTZAILE");
                String izena = emaitza.getString("IZENA");
                String abizena = emaitza.getString("ABIZENA");
                String emaila = emaitza.getString("EMAILA");
                String erabiltzaile = emaitza.getString("ERABILTZAILEA");
                this.bezero = new Bezero(idErabiltzailea, izena, abizena, emaila, erabiltzaile);

                System.out.println("Saioa hasita");

                try{
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("./fitxategiak/cookies/saioa", false));
                    bw1.write(email+":"+pasahitzaHash);
                    bw1.close();
                }catch (IOException e){
                    System.err.println("Arazo bat egon da cokian idaztean datuak.");
                }

                return true;


            } else {
                System.err.println(email + " datu basean ez dago erabiltzailerik datu hauekin");
                return false;
            }
        }catch (SQLException e){
            System.err.println("Arazo bat gertatu egin da saioa aztean");
            return false;
        }

    }
    /*void saioaHasi() throws SQLException {
        sc.nextLine();
        System.out.println("-----------SAIOA HASI-----------");
        System.out.print("Emaila: ");
        String emaila = sc.nextLine();
        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();
        String pasahitzaHash = sha256(pasahitza);

        String sql = "select * from ERABILTZAILEAK where (emaila = ? or erabiltzailea = ?) and pasahitza = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, emaila);
        kontsulta.setString(2, emaila);
        kontsulta.setString(3, pasahitzaHash);

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()) {

            int idErabiltzailea = emaitza.getInt("ID_ERABILTZAILE");
            String izena = emaitza.getString("IZENA");
            String abizena = emaitza.getString("ABIZENA");
            String email = emaitza.getString("EMAILA");
            String erabiltzaile = emaitza.getString("ERABILTZAILEA");
            this.bezero = new Bezero(idErabiltzailea, izena, abizena, email, erabiltzaile);

            System.out.println("Saioa hasita");



        } else {
            System.err.println(emaila + " erabiltzailearekin kontu bat ez dago existitzen");
        }

    }*/


    /**
     * Email bat sartzen, honek begiratzen ea ezistitu egiten den a la ez.
     * <blockquote>{@code ezistitzenDaEmail("taldea3@gmail.com");}</blockquote>
     * @param email
     * @return true or false
     * @throws SQLException
     */
    public boolean ezistitzenDaEmail(String email) throws SQLException {
        String sql = "select * from ERABILTZAILEAK where (emaila = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, email);


        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Begiratzen du ea ezistitzen den erabiltzailea, eskaera bat eginez datu basera
     * <blockquote>{@code ezistitzenDaErabiltzailea(taldea3);}</blockquote>
     * @param Erabiltzailea
     * @return Boolean
     * @throws SQLException
     */
    public boolean ezistitzenDaErabiltzailea(String Erabiltzailea) throws SQLException {
        String sql = "select * from ERABILTZAILEAK where (erabiltzailea = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, Erabiltzailea);


        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }
    }


    /**
     * Pelikula bate izena sartuta, honek lortzen duena da honen informazio guztia eta pasatzen dio pelikulaObjetuari, honek bueltatzeko pelikula objetua honen datu guztiekin.
     * <blockquote>{@code pelikulaLortu("Beyond the fog");}</blockquote>
     * @param izena
     * @return Pelikula
     * @throws SQLException
     */
    public ArrayList<Pelikulak> pelikulaLortu(String izena) throws SQLException {

        izena = "%"+izena+"%";
        ArrayList<Pelikulak> list = new ArrayList<>();
        String sql = "SELECT * FROM FILMAK WHERE TITULUA like ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);



        ResultSet emaitza = kontsulta.executeQuery();
        while (emaitza.next()){
            list.add(pelikulaObjetua(emaitza));
        }

        return list;
    }

    /**
     * deitzen zaionean funtzioari sartu gabe pelikularen ID-a, -1 ID-a esartzen zaio, esan nahi duela pelikula bat aleatorioki aukeratzea.
     * Orduan deitzen zaio beste funtzioari bai jasotzen duela ID-a eta denez -1, generatu egingo du ID-bat seudoaleatorioki.
     * <blockquote>{@code pelikulaLortu();}</blockquote>
     * @return Pelikula
     * @throws SQLException
     */
    public Pelikulak pelikulaLortu() throws SQLException {
        return pelikulaLortu(-1);
    }

    public ArrayList<Pelikulak> pelikulaListLortu(int zenbat) throws SQLException {

        if (zenbat!=-1){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i =0;i<zenbat;i++){
                list.add(pelikulaIDRandom());
            }

            return pelikulaLortu(list);
        }
        return null;
    }

    /**
     * jasotzen du ID bat eta honekin bilatzen du datu basean bere informazio guztia.
     * Informazioa jaso ondoren, deitzen dio beste funtzio bateri eta honek bilakatzen du informazio hori objetu batean eta au bueltatu egiten du.
     * Sartzen bazaio -1 ID, honek egingo duna izango da, generatu beste ID bat, kontuan artuta zein den lehenengo ID-a eta azkena. Horretarako deitu egiten dio {@code azkenekoPelikula()} eta {@code lehenengoPelikula()}
     * <blockquote>{@code pelikulaLortu(101);}</blockquote>
     * @param aukera
     * @return Pelikula
     * @throws SQLException
     */
    public Pelikulak pelikulaLortu(int aukera) throws SQLException {

        if (aukera == -1){
            aukera = pelikulaIDRandom();
        }

        try{
            String sql = "SELECT * FROM FILMAK WHERE ID_FILMA = ?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, aukera);



            ResultSet emaitza = kontsulta.executeQuery();
            emaitza.next();
            return pelikulaObjetua(emaitza);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ArrayList<Pelikulak> pelikulaLortu(ArrayList<Integer> zenbakiak) throws SQLException {

        ArrayList<Pelikulak> lista = new ArrayList<>();


        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < zenbakiak.size(); i++) {
            placeholders.append("?,");
        }

        placeholders.deleteCharAt(placeholders.length() - 1);

        String sql = "SELECT * FROM FILMAK WHERE ID_FILMA IN (" + placeholders.toString() + ")";
        PreparedStatement kontsulta = conn.prepareStatement(sql);


        for (int i = 0; i < zenbakiak.size(); i++) {
            kontsulta.setInt(i + 1, zenbakiak.get(i));
            //System.out.println(zenbaki.get(i));
        }

        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            lista.add(pelikulaObjetua(emaitza));
        }


        return lista;



    }


    /**
     * Funtzio honen bitartez lortzen duguna da sortzea Pelikula objetu bat jaso ondoren ResultSet bat.
     * Utzi baldin badago bueltatu egingo du null objetua, bestela bueltatu egiten du Pelikula objetua.
     * <blockquote>{@code pelikulaObjetua(emaitza);}</blockquote>
     * @param pel
     * @return
     * @throws SQLException
     */

    Pelikulak pelikulaObjetua(ResultSet pel) throws SQLException {


        int IDPelikula = pel.getInt("ID_FILMA");
        String tituloa = pel.getString("TITULUA");
        String generoa = pel.getString("GENEROA");
        long irabaziak = pel.getLong("IRABAZIAK");
        long aurrekontua = pel.getLong("AURREKONTUAK");
        String trailera = pel.getString("TRAILERRAK");
        String irudia = pel.getString("IRUDIA");
        int idEstrenaldia = pel.getInt("ID_ESTREINALDIA");
        int idZuzendaria = pel.getInt("ID_FILM_ZUZENDARIA");

        return new Pelikulak(IDPelikula, tituloa, generoa, irabaziak, aurrekontua, trailera, irudia, idEstrenaldia, idZuzendaria);


    }

    public ArrayList<Pelikulak> pelikulaList(int zenbat){

        ArrayList <Pelikulak> list = new ArrayList<>();

        for (int i =0;i<zenbat;i++){
            try{
                list.add(pelikulaLortu());
            }catch (SQLException e){
                System.err.println("Ezin izan da listara gehitu pelikula");
            }
        }

        return list;
    }

    public ArrayList<Aktoreak> aktoreList(int zenbat){
        ArrayList <Aktoreak> list = new ArrayList<>();

        for (int i =0;i<zenbat;i++){
            try{
                list.add(aktoreaLortu());
            }catch (SQLException e){
                System.err.println("Ezin izan da listara gehitu aktorea");
            }
        }

        return list;
    }


    private int pelikulaIDRandom() throws SQLException {
        int azkenP = azkenekoPelikula();
        int lehenP = lehenengoPelikula();

        return (int) (Math.random() * (azkenP - lehenP + 1)) + lehenP;
    }


    //***********************************Ikusteko Pelikula Lista****************************************************


    public ArrayList<IkusitakoLista> getIkusitakoPelikulak() {
        return ikusitakoPelikulak;
    }

    /**
     * ArrayList batean sartu egiten dira ikusi egin diren pelikula guztia eta hauen notak.
     * Horretarako, deitzen den bakoitzean ikusteko ez direla errepikatzen, garbitu egiten dira eta ondoren sortu egiten dira objetuak {@code ikusitakoListaLortu(emaitza)} funtzioaren bitartez
     * <blockquote>{@code ikusitakoPelikulak();}</blockquote>
     */
    public void ikusitakoPelikulak(){

        ikusitakoPelikulak.clear();

        try {
            String sql = "select * from IKUSITAKOLISTA where (id_erabiltzaile = ?)";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setString(1, String.valueOf(bezero.getIdErabiltzailea()));

            ResultSet emaitza = kontsulta.executeQuery();

            while (emaitza.next()){
                IkusitakoLista list = ikusitakoListaLortu(emaitza);

                ikusitakoPelikulak.add(list);
            }
        }catch (SQLException e){
            //System.err.println("e: "+e.getErrorCode());
            System.err.println("Ez da saioa hasi, orduan, ezin da ikusi ikusitako lista");

        }

    }


    public ArrayList<IkusitakoLista> ikusitakoPelikulakBilatu(String izena){

        ArrayList<IkusitakoLista> lista = new ArrayList<>();
        izena = "%"+izena+"%";

        try {
            String sql = "SELECT * FROM IKUSITAKOLISTA AS ik INNER JOIN FILMAK AS f ON ik.ID_FILMA = f.ID_FILMA WHERE ik.id_erabiltzaile = ? AND f.TITULUA like '?'";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, bezero.getIdErabiltzailea());
            kontsulta.setString(2, izena);

            ResultSet emaitza = kontsulta.executeQuery();

            while (emaitza.next()){
                IkusitakoLista list = ikusitakoListaLortu(emaitza);

                lista.add(list);
            }

            return lista;
        }catch (SQLException e){
            System.err.println("e: "+e.getMessage());
            System.err.println("Ez da saioa hasi, orduan, ezin da ikusi ikusitako lista");
            return null;
        }

    }


    /**
     * Jaso egiten da Oraclek bidaltzen duen erantzuna eta honek ateratzen dio behar duen informazioa sortzeko objetua eta ondoren bueltatzen du obejtua.
     * <blockquote>{@code ikusitakoListaLortu(emaitza);}</blockquote>
     * @param pel
     * @return IkusitakoLista
     * @throws SQLException
     */
    IkusitakoLista ikusitakoListaLortu(ResultSet pel) throws SQLException {
        int IDPelikula = pel.getInt("ID_filma");
        int ikusita = pel.getInt("ikusita");
        //int ikusteko = pel.getInt("ikusteko");
        float nota = pel.getFloat("nota");
        int ikusKop = pel.getInt("ikus_kop");

        Pelikulak peli = pelikulaLortu(IDPelikula);

        return new IkusitakoLista(bezero, peli, ikusita, nota, ikusKop);

    }


    /**
     * Datu basean gehitzeko ikusi egin duzun pelikula berri bat eta honen nota.
     * Honetarako jaso egiten dira, ikusten diren parametroak.
     * Baina lehenik eta behin begiratzen da {@code listanDago} funtzioaren bitartez, ea sartzen ari den pelikula listan dagoen eta bezeroaren ID-daukan.
     * <blockquote>{@code gehituIkusitakoPeli(101, 1, 9, 4);}</blockquote>
     * @param IDPeli
     * @param ikusita ikusita badago 1 jarriko da, bestela 0;
     * @param nota float modukoa da, zenbakiaren ondoren f jarri behar da;
     * @param ikusKop
     * @throws SQLException
     */
    void gehituIkusitakoPeli(int IDPeli, int ikusita, float nota, int ikusKop) throws SQLException {


        if (!listanDago(IDPeli)){

            String sql = "Insert into IKUSITAKOLISTA values (?, ?, ?, ?, ?)";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, bezero.getIdErabiltzailea());
            kontsulta.setInt(2, IDPeli);
            kontsulta.setInt(3, ikusita);
            kontsulta.setFloat(4, nota);
            kontsulta.setInt(5, ikusKop);

            int rowsAffected = kontsulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gehitu egin da pelikua");

            } else {
                System.err.println("Errore bat gertatu da gehitzean pelikula");
            }



        }else {
            System.err.println(IDPeli+" listan dago");
        }




    }

    /**
     * Begiratzeko ea dagoen listan pelikula bat, begiratzen ea pelikula horrekin eta erabiltzailearen ID-arekin {@code bezero.getIdErabiltzailea()}.
     * Emaitzan daturen bat badago bueltatu egingo du True bestela False
     * <blockquote>{@code listanDago(101);}</blockquote>
     * @param IDPeli
     * @return True False
     * @throws SQLException
     */
    boolean listanDago(int IDPeli) throws SQLException {

        String sql = "select * from IKUSITAKOLISTA where (id_erabiltzaile = ? and ID_FILMA = ?)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, String.valueOf(bezero.getIdErabiltzailea()));
        kontsulta.setString(2, String.valueOf(IDPeli));

        ResultSet emaitza = kontsulta.executeQuery();

        if (emaitza.next()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Ikusitako pelikula bateri nahi bazaio aldatu daturen bat.
     * Lehenik eta behin begiratzen da {@code listanDago(101)} funtzioaren bitartez ea dagoen listan, baldin badago {@code update} bat egiten da datu berriekin.
     * Lortu egiten da bezeroaren ID erabiltzen {@code bezero.getIdErabiltzailea()}
     * <blockquote>{@code notaAldatu(101, 1, 10, 6);}</blockquote>
     * @param IDPeli
     * @param ikusita 1 = ikusita, 0 = ez ikusita
     * @param nota
     * @param ikusKop
     * @throws SQLException
     */
    void notaAldatu(int IDPeli, int ikusita, float nota, int ikusKop) throws SQLException {


        if (listanDago(IDPeli)){

            String sql = "update IKUSITAKOLISTA set IKUSITA =?, nota =?, ikus_kop=? where ID_ERABILTZAILE = ? and ID_FILMA = ?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(4, bezero.getIdErabiltzailea());
            kontsulta.setInt(5, IDPeli);
            kontsulta.setInt(1, ikusita);
            kontsulta.setFloat(2, nota);
            kontsulta.setInt(3, ikusKop);

            int rowsAffected = kontsulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Aldatu egin da zure listako informazioa");

            } else {
                System.err.println("Errore bat gertatu da aldatzean informazioa");
            }



        }else {
            System.err.println(IDPeli+" ez dago listan");
        }




    }


    /**
     * Borratzeko zure listatikan pelikula bat nahiago dena ez egotea bertan.
     * <p>Erabiltzen da {@code listanDago(IDPeli)} funtzioa ikusteko ea dagoen listan</p>
     * Lortzeko bezeroaren ID-a erabiltzen da {@code bezero.getIdErabiltzailea()}
     *<blockquote>{@code listatikanBorratu(101);}</blockquote>
     * @param IDPeli
     * @throws SQLException
     */

    void listatikanBorratu(int IDPeli) throws SQLException {


        if (listanDago(IDPeli)){

            String sql = "delete from IKUSITAKOLISTA where ID_ERABILTZAILE = ? and ID_FILMA = ?";
            PreparedStatement kontsulta = conn.prepareStatement(sql);
            kontsulta.setInt(1, bezero.getIdErabiltzailea());
            kontsulta.setInt(2, IDPeli);


            int rowsAffected = kontsulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Borratu egin da zure listatikan");

            } else {
                System.err.println("Errore bat gertatu da borratzean zure listatikan");
            }



        }else {
            System.err.println(IDPeli+" ez dago listan");
        }




    }

    //************************************AKTOREAK*****************************************************

    /**
     * Lortzeko aktore objetu bat, honen izena eta abizena jasotzen dira.
     * Hauen bitartez, lortzen diren datu guztiak datu basetikan bidaltzen dira {@code aktoreakObjetua(emaitza)} funtziora hauek bueltatzeko objetua.
     * <blockquote>{@code aktoreaLortu("Anya", "Taylor-joy");}</blockquote>
     * @param izena
     * @param abizena
     * @return
     * @throws SQLException
     */
    public ArrayList<Aktoreak> aktoreaLortu(String izena, String abizena) throws SQLException {
        izena = "%"+izena+"%";
        abizena = "%"+abizena+"%";

        ArrayList<Aktoreak> list = new ArrayList<>();
        String sql = "SELECT * FROM AKTOREAK WHERE IZENA like ? " + (izena.equals(abizena) ? "OR" : "AND") + " ABIZENA like ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);
        kontsulta.setString(2, abizena);


        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            list.add(aktoreakObjetua(emaitza));
        }

        return list;
    }

    public ArrayList<Zuzendariak> zuzendariaLortu(String izena, String abizena) throws SQLException {

        izena = "%"+izena+"%";
        abizena = "%"+abizena+"%";

        ArrayList<Zuzendariak> list = new ArrayList<>();
        String sql = "SELECT * FROM FILM_ZUZENDARIA WHERE IZENA like ? " + (izena.equals(abizena) ? "OR" : "AND") + " ABIZENA like ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setString(1, izena);
        kontsulta.setString(2, abizena);




        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            list.add(zuzendariObjetua(emaitza));
        }

        return list;
    }

    /**
     * Lortzeko aktore bat aleatorioki aukeratzen du, deitzen diolako {@code aktoreaLortu(-1)} funtzioari eta honek bueltatu egingo du aktore bat aleatorioki aukeratuta
     * <blockquote>{@code aktoreaLortu();}</blockquote>
     * @return
     * @throws SQLException
     */

    public Aktoreak aktoreaLortu() throws SQLException {
        return aktoreaLortu(-1);
    }

    public ArrayList<Aktoreak> aktoreLortuLista(int zenbat) throws SQLException {

        if (zenbat!=-1){
            ArrayList<Integer> zenbaki = aktoIDRandom(zenbat);
            /*for (int i =0;i<zenbat;i++){
                zenbaki.add(aktorIDRandom());
            }*/


            return aktoreaLortu(zenbaki);
        }
        return null;

    }

    ArrayList<Integer> aktoIDRandom(int zenbat) throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();

        String sql = "select ID_AKTOREA from AKTOREAK ORDER BY DBMS_RANDOM.VALUE fetch first ? rows only";

        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, zenbat);



        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            list.add(emaitza.getInt("ID_AKTOREA"));
        }

        return list;
    }

    int aktorIDRandom() throws SQLException {
        int azkenP = azkenekoAktorea();
        int lehenP = lehenengoAktorea();

        return  (int) (Math.random() * (azkenP - lehenP + 1)) + lehenP;
    }

    int ZuzIDRandom() throws SQLException {
        int azkenP = azkenekoZuzendaria();
        int lehenP = lehenengoZuzendaria();

        return  (int) (Math.random() * (azkenP - lehenP + 1)) + lehenP;
    }


    public ArrayList<Zuzendariak> zuzendariLortuLista(int zenbat) throws SQLException {

        if (zenbat!=-1){
            ArrayList<Integer> zenbaki = new ArrayList<>();
            for (int i =0;i<zenbat;i++){
                zenbaki.add(ZuzIDRandom());
            }


            return zuzendariaLortu(zenbaki);
        }
        return null;

    }

    public ArrayList<Zuzendariak> zuzendariaLortu(ArrayList<Integer> zenbaki) throws SQLException {
        ArrayList<Zuzendariak> lista = new ArrayList<>();


        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < zenbaki.size(); i++) {
            placeholders.append("?,");
        }

        placeholders.deleteCharAt(placeholders.length() - 1);

        String sql = "SELECT * FROM FILM_ZUZENDARIA WHERE ID_FILM_ZUZENDARIA IN (" + placeholders.toString() + ")";
        //String sql = "SELECT * FROM FILM_ZUZENDARIA WHERE ID_FILM_ZUZENDARIA IN (213,223)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);


        for (int i = 0; i < zenbaki.size(); i++) {
            kontsulta.setInt(i + 1, zenbaki.get(i));
            //System.out.println(zenbaki.get(i));
        }


        ResultSet emaitza = kontsulta.executeQuery();



        while (emaitza.next()){

            //System.out.println(zuzendariObjetua(emaitza));
            lista.add(zuzendariObjetua(emaitza));
        }


        return lista;
    }
    /**
     * Aktore baten ID-a erabiltzen lortzen dugu bere informazioa eta hau bidaltzen da {@code aktoreakObjetua(emaitza)} funtziora bueltatzeko Aktoreak objetu bat.
     * Jasotzen badu -1 ID bezala, generatu egingo du ID bat seudoaleatorioki kontuan artzen zein den lehenengo ID-a eta azkenekoa, honetarako erabiltzen dira {@code azkenekoAktorea()} eta {@code lehenengoAktorea()}
     * <blockquote>{@code aktoreaLortu(-1);}</blockquote>
     * @param aukera
     * @return Aktoreak
     * @throws SQLException
     */
    public Aktoreak aktoreaLortu(int aukera) throws SQLException {

        if (aukera == -1){
            aukera = aktorIDRandom();
        }


        String sql = "SELECT * FROM AKTOREAK WHERE ID_AKTOREA = ?";
        PreparedStatement kontsulta = conn.prepareStatement(sql);
        kontsulta.setInt(1, aukera);



        ResultSet emaitza = kontsulta.executeQuery();

        emaitza.next();
        return aktoreakObjetua(emaitza);

    }

    public ArrayList<Aktoreak> aktoreaLortu(ArrayList<Integer> zenbaki) throws SQLException {
        ArrayList<Aktoreak> lista = new ArrayList<>();


        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < zenbaki.size(); i++) {
            placeholders.append("?,");
        }

        placeholders.deleteCharAt(placeholders.length() - 1);

        String sql = "SELECT * FROM AKTOREAK WHERE ID_AKTOREA IN (" + placeholders.toString() + ")";
        PreparedStatement kontsulta = conn.prepareStatement(sql);


        for (int i = 0; i < zenbaki.size(); i++) {
            kontsulta.setInt(i + 1, zenbaki.get(i));
            //System.out.println(zenbaki.get(i));
        }

        ResultSet emaitza = kontsulta.executeQuery();

        while (emaitza.next()){
            lista.add(aktoreakObjetua(emaitza));
        }


        return lista;
    }


    /**
     * Jasotzen ditu beste funtzioek jaso duten Oracle DB-ren erantzuna eta hau analizatu egiten du sortzeko {@code Aktoreak} klase bat eta hau itzuli.
     * <blockquote>{@code aktoreakObjetua(emaitza);}</blockquote>
     * @param pel
     * @return Aktoreak
     * @throws SQLException
     */

    Aktoreak aktoreakObjetua(ResultSet pel) throws SQLException {

        /*if (!pel.next()) {
            return null;
        }*/


        int ID_AKTOREA = pel.getInt("ID_AKTOREA");
        String IZENA = pel.getString("IZENA");
        String ABIZENA = pel.getString("ABIZENA");
        String JAIOTZE_DATA = pel.getString("JAIOTZE_DATA");
        String NAZIONALITATEA = pel.getString("NAZIONALITATEA");
        String EMAILA = pel.getString("EMAILA");
        String TELEFONOA = pel.getString("TELEFONOA");
        String IRUDIA = pel.getString("IRUDIA");


        return new Aktoreak(ID_AKTOREA, IZENA, ABIZENA, JAIOTZE_DATA, NAZIONALITATEA, EMAILA, TELEFONOA, IRUDIA);
    }

    Zuzendariak zuzendariObjetua(ResultSet pel) throws SQLException {

        /*if (!pel.next()) {
            return null;
        }*/


        int ID_AKTOREA = pel.getInt("ID_FILM_ZUZENDARIA");
        String IZENA = pel.getString("IZENA");
        String ABIZENA = pel.getString("ABIZENA");
        int JAIOTZE_DATA = pel.getInt("JAIOTZE_DATA");
        String SEXUA = pel.getString("SEXUA");
        String IRUDIA = pel.getString("IRUDIA");
        //System.out.println(ID_AKTOREA);


        return new Zuzendariak(ID_AKTOREA, IZENA, ABIZENA, JAIOTZE_DATA, SEXUA, IRUDIA);
    }



    //************************************* AZKENEKOAK***********************************************

    /**
     * Erabiltzaileen azkeneko ID-a edo handiena itzultzen du.
     * <blockquote>{@code azkenekoID();}</blockquote>
     * @return azkenekoID;
     * @throws SQLException
     */
    int azkenekoID() throws SQLException {
        String sql = "SELECT ID_ERABILTZAILE FROM ERABILTZAILEAK WHERE ID_ERABILTZAILE = (SELECT MAX(ID_ERABILTZAILE) FROM ERABILTZAILEAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoID = 0;
        if (emaitza.next()) {
            azkenekoID = emaitza.getInt(1);
        }

        return azkenekoID;
    }


    /**
     * Azkeneko pelikularen ID-a edo handiena itzultzen du.
     * <blockquote>{@code azkenekoPelikula();}</blockquote>
     * @return azkenekoID;
     * @throws SQLException
     */
    int azkenekoPelikula() throws SQLException {
        String sql = "SELECT ID_FILMA FROM FILMAK WHERE ID_FILMA = (SELECT MAX(ID_FILMA) FROM FILMAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoPelikula = 0;
        if (emaitza.next()) {
            azkenekoPelikula = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return azkenekoPelikula;
    }

    /**
     * Bueltatu egiten du pelikulen lehenego ID-a edo txikiena.
     * <blockquote>{@code lehenengoPelikula();}</blockquote>
     * @return
     * @throws SQLException
     */
    int lehenengoPelikula() throws SQLException {
        String sql = "SELECT ID_FILMA FROM FILMAK WHERE ID_FILMA = (SELECT MIN(ID_FILMA) FROM FILMAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int lehenengoPeli = 0;
        if (emaitza.next()) {
            lehenengoPeli = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoPelikula);
        return lehenengoPeli;
    }


    /**
     * Azkeneko aktorearen ID-a edo handiena itzultzen du.
     * <blockquote>{@code azkenekoAktorea();}</blockquote>
     * @return
     * @throws SQLException
     */
    int azkenekoAktorea() throws SQLException {
        String sql = "SELECT ID_AKTOREA FROM AKTOREAK WHERE ID_AKTOREA = (SELECT MAX(ID_AKTOREA) FROM AKTOREAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoAktorea = 0;
        if (emaitza.next()) {
            azkenekoAktorea = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+azkenekoAktorea);
        return azkenekoAktorea;
    }

    /**
     * Lehenengo aktorearen ID-a itzultzen edo txikiena.
     * <blockquote>{@code lehenengoAktorea();}</blockquote>
     * @return
     * @throws SQLException
     */

    int lehenengoAktorea() throws SQLException {
        String sql = "SELECT ID_AKTOREA FROM AKTOREAK WHERE ID_FILMA = (SELECT MIN(ID_AKTOREA) FROM AKTOREAK)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int lehenengoAktorea = 0;
        if (emaitza.next()) {
            lehenengoAktorea = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+lehenengoAktorea);
        return lehenengoAktorea;
    }

    int azkenekoZuzendaria() throws SQLException {
        String sql = "SELECT ID_FILM_ZUZENDARIA FROM FILM_ZUZENDARIA WHERE ID_FILM_ZUZENDARIA = (SELECT MAX(ID_FILM_ZUZENDARIA) FROM FILM_ZUZENDARIA)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int lehenengoZuz = 0;
        if (emaitza.next()) {
            lehenengoZuz = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+lehenengoAktorea);
        return lehenengoZuz;
    }

    int lehenengoZuzendaria() throws SQLException {
        String sql = "SELECT ID_FILM_ZUZENDARIA FROM FILM_ZUZENDARIA WHERE ID_FILM_ZUZENDARIA = (SELECT MIN(ID_FILM_ZUZENDARIA) FROM FILM_ZUZENDARIA)";
        PreparedStatement kontsulta = conn.prepareStatement(sql);

        ResultSet emaitza = kontsulta.executeQuery();

        int azkenekoZuz = 0;
        if (emaitza.next()) {
            azkenekoZuz = emaitza.getInt(1);
        }

        //System.out.println("Azkenekoa: "+lehenengoAktorea);
        return azkenekoZuz;
    }


    public static String sha256(String text) {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");
            var hash = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));

            return String.format("%064x", new BigInteger(1, hash));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }



    //************************KONEXIOA*********************************

    /**
     * Datu basera konektatzeko konexioa ireki behar dugu, eta horretarako erabiltzen da funtzio hau.
     * <blockquote>{@code konexioaEgin();}</blockquote>
     */
    void konexiaEgin(){

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ipa + ":1521:" + DBIzena, username, pasahitza);
            System.out.println("Konexioa eginda");
        }catch (SQLException e){

            System.err.println("Ezin izan da konexioa egin");
            //System.out.println(e.getErrorCode());
            if (e.getErrorCode() == 12541){
                System.err.println(e.getErrorCode()+": ez da aurkitu TNS-a");
            }


        }

    }

    /**
     * Datu basearekin izteko konexioa erabiliko genuke funtzio hau.
     * <blockquote>{@code konexioaItxi();}</blockquote>
     */
    public void konexioaItxi(){

        try {
            System.out.println("Konexioa itxita");
            conn.close();
        }catch (SQLException e){
            System.err.println("Ezin izan da konexioa itxi.");
        }

    }


    public Bezero getBezero() {
        return bezero;
    }


    /*public ArrayList<Aktoreak> bilat(String izena, String non){


        try {
            if (non.equals("Pelikulak")){
                return (pelikulaLortu(izena));
            }else if(non.equals("Aktoreak")){
                String[] izenAbizen = izena.split(" ");
                return (aktoreaLortu(izenAbizen[0], izenAbizen[1]));

            }else if (non.equals("Zuzendariak")){
                String[] izenAbizen = izena.split(" ");
                return (zuzendariaLortu(izenAbizen[0], izenAbizen[1]));

            }else if(non.equals("myList")){
                lista.addAll(pelikulaLortu(izena));

                ArrayList<Pelikulak> list = new ArrayList<>();

                for (Object pel : lista){
                    if (listanDago(p))
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }*/
}
