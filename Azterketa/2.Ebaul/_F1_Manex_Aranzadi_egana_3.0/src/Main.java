import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            HashMap<String, HashMap<Integer, Langile>> F1 = new HashMap<>();

            int z =0;

            while (z !=6){


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
                        F1=gehituTaldea(F1);
                        break;
                    case 3:
                        F1=borratuTaldea(F1);
                        break;
                    case 4:
                        F1=gehituLangile(F1);
                        break;
                    case 5:
                        F1=aldatuLangile(F1);
                        break;
                    default:
                        System.out.println("Sartutako zenbakiak ez du ezer egiten");
                        break;

                }

            }
        }catch (F1Exception e){
            System.err.println(e.getMessage());
        }


    }

    public static HashMap<String, HashMap<Integer, Langile>> erakutsi(HashMap<String, HashMap<Integer, Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (F1.containsKey(talde)){

            System.out.println("1- piloto: ");
            System.out.println("2- ingeniari: ");
            System.out.println("3- zuzendari: ");

            int zein = sc.nextInt();


            HashMap<Integer, Langile> langileList=F1.get(talde);


            for (Integer integer : langileList.keySet()) {
                Langile l = langileList.get(integer);

                if (zein == 1 && l.getKargua().equals(Langile.kargua.piloto)) {
                    System.out.println(l);

                } else if (zein == 2 && l.getKargua().equals(Langile.kargua.ingeniaria)) {
                    System.out.println(l);

                } else if (zein == 3 && l.getKargua().equals(Langile.kargua.zuzendari)) {
                    System.out.println(l);

                }


            }



        }else {
            throw new F1Exception(talde+ "taldea ez dago listan");
        }

        return F1;

    }

    public static HashMap<String, HashMap<Integer, Langile>> gehituTaldea(HashMap<String, HashMap<Integer, Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (!F1.containsKey(talde)){
            HashMap<Integer, Langile> langileHashMap = new HashMap<>();
            F1.put(talde, langileHashMap);
        }else {
            throw new F1Exception(talde+ " taldea dagoeneko listan dago");
        }

        return F1;

    }

    public static HashMap<String, HashMap<Integer, Langile>> borratuTaldea(HashMap<String, HashMap<Integer, Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (F1.containsKey(talde)){
            F1.remove(talde);
        }else {
            throw new F1Exception(talde+ " taldea ez dago listan");
        }

        return F1;

    }

    public static HashMap<String, HashMap<Integer, Langile>> gehituLangile(HashMap<String, HashMap<Integer, Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        System.out.print("Izena: ");
        String izena = sc.nextLine();
        System.out.print("Abizena: ");
        String abizena = sc.nextLine();
        System.out.print("Adina: ");
        int adina = sc.nextInt();
        System.out.print("Kargua: ");
        String borratu = sc.nextLine();
        Langile.kargua kargu = Langile.kargua.valueOf(sc.nextLine());

        Langile l = new Langile(izena, abizena, adina, kargu);

        int p=0;
        int z=0;

        if (F1.containsKey(talde)){

            HashMap<Integer, Langile> langileList=F1.get(talde);

            Iterator<Integer> it = langileList.keySet().iterator();

            while (it.hasNext()){
                Langile l1 = langileList.get(it.next());

                if (l1.getKargua().equals(Langile.kargua.piloto)){
                    p++;
                }
                if (l1.getKargua().equals(Langile.kargua.zuzendari)){
                    z++;
                }
            }

            if (z>1 && l.getKargua().equals(Langile.kargua.zuzendari)){
                throw new F1Exception("Zuzendari nahikoa daude: "+z);
            }

            if (p>3 && l.getKargua().equals(Langile.kargua.piloto)){
                throw new F1Exception("Piloto nahikoak daude: "+p);
            }

            Integer kodea = langileList.size();
            langileList.put(kodea, l);

        }else {
            throw new F1Exception(talde+ " taldea ez dago listan");
        }

        return F1;

    }

    public static HashMap<String, HashMap<Integer, Langile>> aldatuLangile(HashMap<String, HashMap<Integer, Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        System.out.println("Zein taldearen nahi da aldatu: ");
        String talde1 = sc.nextLine();

        if (F1.containsKey(talde) && F1.containsKey(talde1)){

            System.out.print("Izena: ");
            String izena = sc.nextLine();
            System.out.print("Abizena: ");
            String abizena = sc.nextLine();
            System.out.print("Adina: ");
            int adina = sc.nextInt();
            System.out.print("Kargua: ");
            String borratu = sc.nextLine();
            Langile.kargua kargu = Langile.kargua.valueOf(sc.nextLine());

            Langile l = new Langile(izena, abizena, adina, kargu);

            HashMap<Integer, Langile> langileList=F1.get(talde);

            HashMap<Integer, Langile> langileList1=F1.get(talde1);

            Integer kodea1 = langileList1.size();
            langileList1.put(kodea1, l);


            for (Integer integer : langileList.keySet()) {
                Langile l1 = langileList.get(integer);

                if (l1.equals(l));

                langileList.remove(integer);
            }





        }else {
            if (!F1.containsKey(talde)){
                throw new F1Exception(talde+ " taldea ez dago listan");

            } else if (!F1.containsKey(talde1)) {
                throw new F1Exception(talde1+ " taldea ez dago listan");
            }else {
                throw new F1Exception("Sartutako bi taldeak ez daude listan");
            }

        }

        return F1;

    }





}