package GUI;

import DatuBase.Konexioa;
import Objetuak.Bezero;

import javax.swing.*;
import java.sql.SQLException;

public class KontuaSortu {

    public static Bezero kontuaSortu() throws SQLException {
        JTextField emaila = new JTextField();
        JTextField pasahitza = new JPasswordField();
        JTextField izena = new JTextField();
        JTextField abizena = new JTextField();
        JTextField erabiltzailea = new JTextField();



        Object[] message = {
                "Email:", emaila,
                "Pasahitza:", pasahitza,
                "Izena:", izena,
                "Abizena:", abizena,
                "Erabiltzailea:", erabiltzailea
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Kontua sortu", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            Konexioa conn = new Konexioa();
            String email = emaila.getText();
            String pas = pasahitza.getText();
            String ize = izena.getText();
            String abi = abizena.getText();
            String era = erabiltzailea.getText();
            if (conn.sortuKontua(email, pas, ize, abi, era)) {
                System.out.println("Kontu berria egoki sortu egin da.");

                return conn.getBezero();
            } else {
                System.err.println("Arazo bat gertatu egin da sortzean kontua");

                return null;
            }
        } else {
            System.out.println("Kontua sortzea ezestatu egin da.");
            return null;
        }
    }
}
