package GUI;

import DB.Konexioa;

import javax.swing.*;

public class Borratu {

    public Borratu(String izena) {
        menua(izena);
    }

    public static boolean menua(String izena){
        int option = JOptionPane.showConfirmDialog(null, izena+" irudia borratu nahi duzu?", "Saioa hasi", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            return true;


        } else {
            return false;
        }
    }
}
