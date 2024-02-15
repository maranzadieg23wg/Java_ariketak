import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.print("Zenbat zenbaki: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int zenbat = Integer.parseInt(bf.readLine());
        //int zenbat =10;



        FileWriter fileWriter = new FileWriter("zenb.bin", false);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        for (int i =0;i<zenbat;i++){
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        bw.close();




        BufferedReader in = new BufferedReader(new FileReader("zenb.bin"));
        FileWriter file1 = new FileWriter("zenb.txt", false);
        BufferedWriter bw1 = new BufferedWriter(file1);

        String line;
        while ((line = in.readLine()) != null) {
            bw1.write(line);
            bw1.newLine();
        }



        System.out.println("Eginda");



    }
}