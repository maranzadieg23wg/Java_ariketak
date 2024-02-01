public class ZenbakienBatura {


    private static int guztira =0;

    static void main(int z){
        try {
            guztira+=z;
        }catch (NumberFormatException e){
            System.out.println("ERROREA. Zati zero");
        }
    }




}
