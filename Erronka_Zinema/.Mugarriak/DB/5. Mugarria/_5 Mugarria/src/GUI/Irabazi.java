package GUI;

import javax.swing.*;

public class Irabazi {

    public static int menua (){
        JTextField emaila = new JTextField();
        Object[] message = {
                "Minimum no of visits for getting a prize:", emaila

        };

        int option = JOptionPane.showConfirmDialog(null, message, "AWARD", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                System.out.println("ongi");
                int z = Integer.parseInt(emaila.getText());
                //System.out.println(z);
                return z;
            }catch (Exception e){
                System.out.println("gaizki");
                return -1;
            }

        } else {
            return -1;
        }
    }
}
