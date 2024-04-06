package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Pasahitza {


    public Pasahitza() {
        String name = JOptionPane.showInputDialog("Input password");
        if (name.equals("damocles")){
            System.out.println("logeatuta");
            new Leihoa("Manex Aranzadi", 700, 600);
        }

    }


}
