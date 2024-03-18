public class PuntuSistema {





    public void puntuakIkusi(Erabiltzaileak erabiltzaileak){
        double puntuak = erabiltzaileak.getPuntuak();



        System.out.println("Puntuak: "+puntuak);
    }


    public double puntuakLortu(float distantzia, String bidaiMota){
        double puntuak=0;

        double km = distantzia*0.01;

        if (bidaiMota.equals("luzea")){
            puntuak += 3;
        } else if (bidaiMota.equals("hertaina")) {
            puntuak+=2;
        }else {
            puntuak+=1;
        }


        puntuak +=km;
        return puntuak;
    }


}
