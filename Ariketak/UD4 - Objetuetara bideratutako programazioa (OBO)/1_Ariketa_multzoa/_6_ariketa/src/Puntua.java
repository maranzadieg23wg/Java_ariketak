public class Puntua {


    int zX;

    int zY;

    Puntua(int zX, int zY){
        this.zX=zX;
        this.zY=zY;
    }


    public int koadrantea(){


        boolean X = zX>0;
        boolean Y = zY>0;

        if (X && Y){
            return 1;
        } else if (!X && Y) {
            return 2;
        } else if (!X && !Y) {
            return 3;
        }else {
            return 4;
        }

    }

    public void inprimatuPuntua(){
        System.out.println("X: "+zX);
        System.out.println("Y: "+zY);
        System.out.println("Kuadrantea: "+koadrantea());

    }

    public int getzX(){
        return  zX;
    }

    public int getzY() {
        return zY;
    }
}
