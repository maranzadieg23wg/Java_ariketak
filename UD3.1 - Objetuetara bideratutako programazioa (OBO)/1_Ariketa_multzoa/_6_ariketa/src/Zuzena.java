
public class Zuzena {


    float zabalera;

    int zX;
    int zY;

    int zX2;
    int zY2;


    public Zuzena(float zabalera, Puntua puntua){

        this.zabalera = zabalera;

        //Lehenengo puntua
        this.zX = puntua.getzX();
        this.zY=puntua.getzY();



    }

    public void bigarrenPuntua(Puntua puntua){
        //Bigarren puntua
        this.zX2 = puntua.getzX();
        this.zY2=puntua.getzY();
    }

    public boolean horizontalaDa(){

        return zX == zX2;

    }

    public boolean bertikalaDa(){

        return zY == zY2;

    }

    public int altuena(){

        if (zY>zY2){
            return zY;
        }else {
            return  zY2;
        }


    }

    public double getLuzera(){


        int xTotal = zX-zX2;
        int yTotal = zY-zY2;

        float guztira = (yTotal*yTotal)+(xTotal*xTotal);
        return Math.sqrt(guztira);

    }

    public Object luzeena(Zuzena z){
        double luzeera2 = z.getLuzera();

        /*System.out.println("Luzeera: "+this.getLuzera());
        System.out.println("Luzeera2: "+luzeera2);*/

        if (this.getLuzera() > luzeera2){
            //return this.getLuzera();
            return "Zuzena1";
        }else {
            //return luzeera2;
            return "Zuzena2";

        }
    }

    public void erakutsiZuzena(){
        System.out.println("X: "+zX);
        System.out.println("Y: "+zY);
        System.out.println("Luzeera: "+getLuzera());
    }





}
