import java.util.Arrays;

public class Streamer {

    private String izena;
    private int adina; //← urtea
    private String jaiotzeData; //← UUUU/HH/EE
    private int harpideKop;
    private String[] bideojoak;

    public Streamer(String izena, String jaiotzeData) {
        this.izena = izena;
        this.jaiotzeData = jaiotzeData;

        String urtea = jaiotzeData.substring(0,4);

        this.adina = 2024 - Integer.parseInt(urtea);

        this.harpideKop =0;
        this.bideojoak = new String[15];
    }

    Streamer(String izena, String jaiotzeData, int harpideKop, String[] bideojoak) {
        this.izena = izena;
        this.jaiotzeData = jaiotzeData;

        String urtea = jaiotzeData.substring(0,5);

        this.adina = 2023 - Integer.parseInt(urtea);

        this.harpideKop = harpideKop;
        this.bideojoak = bideojoak;
    }



    void gehituBideojokoa(String game){
        for (int i =0;i<bideojoak.length;i++){

            try {
                if (bideojoak[i]!=null && bideojoak[i].equals(game)){
                    throw new Exception(game+" bideojokoa listan dago");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

            if (bideojoak[i]==null){
                bideojoak[i]= game;
                i = bideojoak.length+2;
            }


        }
    }


    @Override
    public String toString() {
        String jolasak ="[";
        for (int i=0;i<bideojoak.length;i++){
            if (bideojoak[i]==null){
                i = bideojoak.length+2;
            }else if (bideojoak[i]!=null){
                jolasak+=bideojoak[i];

                if (i != bideojoak.length-1){
                    if (bideojoak[i+1]!=null){
                        jolasak+=", ";
                    }

                }
            }

        }

        jolasak+="]";
        return "["+izena+", "+adina+", "+harpideKop+", "+jolasak+"]";
    }

    String getIzena() {
        return izena;
    }

    String[] getBideojoak() {
        return bideojoak;
    }
}
