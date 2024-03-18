import java.util.Scanner;

public class ZenbakienBatura {




    static void main(String[] proba){
        int guztira =0;
        int erroreKop =0;
        for (String z: proba) {
            try {

                guztira+= Integer.parseInt(z);


            }catch (Exception e){
                System.err.println("Zenbakiak sartu behar dira, ez letrak: "+ z);

                erroreKop++;
            }
        }


        System.out.println(guztira);
        System.out.println("Errore kopurua: " +erroreKop);

    }




}
