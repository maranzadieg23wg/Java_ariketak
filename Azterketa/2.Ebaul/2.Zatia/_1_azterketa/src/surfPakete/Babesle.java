package surfPakete;

import java.util.Objects;

public class Babesle {


    private String izena;
    private String sorreraData; //← UUUU/HH/EE
    private boolean multinazionalaDa;

    public Babesle(String izena, String sorreraData, boolean multinazionalaDa) {
        this.izena = izena;
        this.sorreraData = sorreraData;
        this.multinazionalaDa = multinazionalaDa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Babesle babesle = (Babesle) o;
        return multinazionalaDa == babesle.multinazionalaDa && Objects.equals(izena, babesle.izena) && Objects.equals(sorreraData, babesle.sorreraData);
    }

   String erakutsi (){

        String baiEz ="";

        if (this.multinazionalaDa){
            baiEz = "bai";
        }else {
            baiEz ="ez";
        }

       //System.out.println("["+izena+", "+sorreraData+", "+baiEz+"]");
        return "["+izena+", "+sorreraData+", "+baiEz+"]";


   }


}
