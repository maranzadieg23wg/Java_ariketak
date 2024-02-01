import java.util.Scanner;

public class ZenbakienBatura {




    static void main(String[] proba){
        int guztira =0;

        try {

            for (String z: proba) {
                guztira+= Integer.parseInt(z);
            }
            System.out.println(guztira);

        }catch (Exception e){
            System.err.println("Zenbakiak sartu behar dira, ez letrak");
        }
    }




}
