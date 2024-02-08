import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Langile>> F1 = new ArrayList<>();
        try {
            int z =0;
            while (z!=6){

                System.out.println("1: Erakutsi");
                System.out.println("2: Gehitu talde bat");
                System.out.println("3: Ezabatu talde bat");
                System.out.println("4: Gehitu langile bat");
                System.out.println("5: Aldatu langile bat talde batetik");
                System.out.println("6: Bukatu programa");


                z = sc.nextInt();

                switch (z){
                    case 1:
                        erakutsi(F1);
                        break;
                    case 2:
                        gehituTaldea(F1);
                        break;
                    case 3:
                        borratuTaldea(F1);
                        break;
                    case 4:
                        gehituLangile(F1);
                        break;
                    case 5:
                        aldatuLangile(F1);
                        break;
                    default:
                        System.out.println("Sartutako zenbakiak ez du ezer egiten");
                        break;

                }
            }
            System.out.println("Programa bukatu da.");
        }catch (F1Exception e){
            System.err.println(e.getMessage());
        }







    }

    public static void erakutsi(ArrayList<ArrayList<Langile>> F1) throws F1Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        System.out.println("1- piloto: ");
        System.out.println("2- ingeniari: ");
        System.out.println("3- zuzendari: ");

        int zein = sc.nextInt();

        int txapuza=1;

        if (taldeaExistitu(F1, talde)) {

            for (ArrayList<Langile> taldeak : F1) {

                ArrayList<Langile> proba = taldeak;

                Langile l5 = proba.get(0);
                Langile l1 = new Langile(talde, talde, 0, null);

                if (l5.equals(l1)){
                    for (Langile l : proba) {

                        if (l.getKargu()!=null && txapuza!=1){
                            if (zein == 1 && l.getKargu().equals(Kargu.piloto)) {
                                System.out.println(l);

                            } else if (zein == 2 && l.getKargu().equals(Kargu.ingeniari)) {
                                System.out.println(l);

                            } else if (zein == 3 && l.getKargu().equals(Kargu.zuzendari)) {
                                System.out.println(l);

                            }
                        }
                        txapuza++;


                    }
                }



            }
        }else {
            throw new F1Exception("Sartutako taldea ez dago listan");
        }


    }

    public static ArrayList gehituTaldea(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (!taldeaExistitu(F1, talde)){
            ArrayList<Langile>talde1= new ArrayList<>();
            Langile l1 = new Langile(talde, talde, 0, null);
            talde1.add(l1);
            F1.add(talde1);
            return F1;

        }else {
            throw new F1Exception("Sartutako taldea dagoeneko listan dago");

        }


    }

    public static ArrayList borratuTaldea(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (taldeaExistitu(F1, talde)){

            for (ArrayList<Langile> taldeak:F1) {

                ArrayList<Langile> proba = taldeak;

                Langile l2 = proba.get(0);

                Langile l1 = new Langile(talde, talde, 0, null);

                if (l1.equals(l2)){
                    F1.remove(taldeak);
                    return F1;
                }





            }

        }else {
            throw new F1Exception("Sartutako taldea ez dago listan");
        }




        return F1;

    }


    public static boolean taldeaExistitu(ArrayList<ArrayList<Langile>> F1, String taldea) throws F1Exception {

        Langile l1 = new Langile(taldea, taldea, 0, null);


        for (ArrayList<Langile> taldeak:F1) {

            ArrayList<Langile> proba = taldeak;

            Langile l2 = proba.get(0);

            if (l2.equals(l1)){
                return true;
            }



        }
        return false;
        //throw new F1Exception("Sartutako taldea ez dago listan");

    }

    public static ArrayList gehituLangile(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        int txapuza =1;

        if (taldeaExistitu(F1, talde)) {

            for (ArrayList<Langile> taldeak : F1) {

                ArrayList<Langile> proba = taldeak;
                Langile l1 = new Langile(talde, talde, 0, null);

                if (proba.get(0).equals(l1)){
                    int p=0;
                    int i=0;
                    int z=0;
                    for (Langile l:proba) {
                        if (l!=null && txapuza!=1){
                            if (l.getKargu().equals(Kargu.piloto)) {
                                p++;
                            } else if (l.getKargu().equals(Kargu.ingeniari)) {
                                i++;
                            } else if (l.getKargu().equals(Kargu.zuzendari)) {
                                z++;
                            }
                        }
                        txapuza++;

                    }

                    if (p>3){
                        throw new F1Exception("Piloto geheigi");
                    }
                    if (z>1){
                        throw new F1Exception("Zuzendari geheigi");
                    }

                    System.out.print("Izena: ");
                    String izena = sc.nextLine();
                    System.out.print("Abizena: ");
                    String abizena = sc.nextLine();
                    System.out.print("Adina: ");
                    int adina = sc.nextInt();
                    System.out.print("Kargua: ");
                    String borratu = sc.nextLine();
                    Kargu kargu = Kargu.valueOf(sc.nextLine());

                    Langile l3 = new Langile(izena, abizena, adina, kargu);
                    proba.add(l3);

                    F1.remove(taldeak);
                    F1.add(proba);
                    return F1;
                }


                return F1;





            }
        }else {
            throw new F1Exception("Sartutako taldea ez dago listan");
        }

        return F1;

    }

    public static ArrayList aldatuLangile(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Izena: ");
        String izena = sc.nextLine();
        System.out.print("Abizena: ");
        String abizena = sc.nextLine();
        System.out.print("Adina: ");
        int adina = sc.nextInt();
        System.out.print("Kargua: ");
        String borratu = sc.nextLine();
        Kargu kargu = Kargu.valueOf(sc.nextLine());


        System.out.print("Zein taldetan dago? ");
        String taldea = sc.nextLine();

        System.out.print("Zein taldera mugitu nahi da? ");
        String taldea1 = sc.nextLine();

        Langile l1 = new Langile(taldea, taldea, 0, null);
        Langile l5 = new Langile(taldea1, taldea1, 0, null);

        Langile l2 = new Langile(izena, abizena, adina, kargu);

        if (taldeaExistitu(F1, taldea)&&taldeaExistitu(F1, taldea1)){

            ArrayList<Langile> aldaketak = new ArrayList<>();

            Iterator<ArrayList<Langile>> iterator1 = F1.iterator();

            while (iterator1.hasNext()){
                ArrayList<Langile> proba = iterator1.next();

                if (proba.get(0).equals(l1)){

                    /*for (Langile l: proba){
                        if (l2.equals(l)){
                            proba.remove(l);
                            F1.remove(proba);
                            F1.add(proba);

                        }
                    }*/
                    Iterator<Langile> iterator = proba.iterator();
                    while (iterator.hasNext()) {
                        Langile l = iterator.next();
                        if (l2.equals(l)) {
                            proba.remove(l);
                            F1.remove(proba);
                            F1.add(proba);
                        }
                    }



                }

                if (proba.get(0).equals(l5)){

                    Iterator<Langile> iterator = proba.iterator();
                    while (iterator.hasNext()) {
                        Langile l = iterator.next();
                        if (l2.equals(l)) {
                            proba.add(l);
                            F1.remove(proba);
                            F1.add(proba);
                        }
                    }
                    /*for (Langile l: proba){
                        if (l2.equals(l)){
                            proba.add(l);
                            F1.remove(proba);
                            F1.add(proba);

                        }
                    }*/


                }

            }




        }else {
            throw new F1Exception("Sartutako taldea ez dago listan");
        }

        return F1;

    }



















    }