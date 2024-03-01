import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        DataInputStream dis = new DataInputStream(new FileInputStream("./img/guts.jpg"));
        DataOutputStream dos = new DataOutputStream((new FileOutputStream("./img/guts2.jpg")));


        int zenbat = dis.available();

        for (int i =0;i<zenbat;i++){
            //System.out.println(dis.readByte());
            dos.writeByte(dis.readByte());
        }
        System.out.println("Gordeta");

    }
}