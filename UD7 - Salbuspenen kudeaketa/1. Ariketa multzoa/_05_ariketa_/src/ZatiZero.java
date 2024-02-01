public class ZatiZero {



    static float main(int z1, int z2){
        try {
            return z1/z2;
        }catch (ArithmeticException e){
            System.out.println("ERROREA. Zati zero");
        }
        return 0;
    }
}
