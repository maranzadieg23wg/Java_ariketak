import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Langile>> F1 = new ArrayList<>();
        try {
            int z =0;
            while (z!=6){
                z = sc.nextInt();

                switch (z){
                    case 1:
                        erakutsi(F1);
                    case 2:
                        gehituTaldea(F1);
                    case 3:
                        borratuTaldea(F1);
                    case 4:
                        gehituLangile(F1);
                    default:
                        z = sc.nextInt();
                }
            }
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

        if (taldeaExistitu(F1, talde)) {

            for (ArrayList<Langile> taldeak : F1) {

                ArrayList<Langile> proba = taldeak;

                for (Langile l : proba) {

                    if (zein == 1 && l.getKargu().equals(Kargu.piloto)) {
                        System.out.println(l);

                    } else if (zein == 2 && l.getKargu().equals(Kargu.ingeniari)) {
                        System.out.println(l);

                    } else if (zein == 3 && l.getKargu().equals(Kargu.zuzendari)) {
                        System.out.println(l);

                    }

                }

            }
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

        }


        return F1;

    }

    public static ArrayList borratuTaldea(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (taldeaExistitu(F1, talde)){

            for (ArrayList<Langile> taldeak:F1) {

                ArrayList<Langile> proba = taldeak;

                Langile l2 = proba.get(0);

                F1.remove(taldeak);
                return F1;



            }

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
        throw new F1Exception("Sartutako taldea ez dago listan");

    }

    public static ArrayList gehituLangile(ArrayList<ArrayList<Langile>> F1) throws F1Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Taldearen izena: ");
        String talde = sc.nextLine();

        if (taldeaExistitu(F1, talde)) {

            for (ArrayList<Langile> taldeak : F1) {

                ArrayList<Langile> proba = taldeak;

                int p=0;
                int i=0;
                int z=0;
                for (Langile l:proba) {
                    if (l.getKargu().equals(Kargu.piloto)) {
                        p++;
                    } else if (l.getKargu().equals(Kargu.ingeniari)) {
i++;
                    } else if (l.getKargu().equals(Kargu.zuzendari)) {
z++;
                    }
                }

                if (p>3){
                    throw new F1Exception("Piloto geheigi");
                }
                if (z>1){
                    throw new F1Exception("Zuzendari geheigi");
                }

                String izena = sc.nextLine();
                String abizena = sc.nextLine();
                int adina = sc.nextInt();
                Kargu kargu = Kargu.valueOf(sc.nextLine());

                Langile l3 = new Langile(izena, abizena, adina, kargu);
                proba.add(l3);

                F1.remove(taldeak);
                F1.add(proba);
                return F1;





            }
        }

        return F1;

    }



















    }