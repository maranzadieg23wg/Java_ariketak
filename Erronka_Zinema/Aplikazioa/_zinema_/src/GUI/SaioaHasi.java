package GUI;

import DatuBase.Konexioa;
import Objetuak.Bezero;

import javax.swing.*;
import java.sql.SQLException;

public class SaioaHasi {


    public static Bezero saioaHasi() throws SQLException {
        JTextField emaila = new JTextField();
        JTextField pasahitza = new JPasswordField();
        Object[] message = {
                "Email:", emaila,
                "Pasahitza:", pasahitza
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Saioa hasi", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            Konexioa conn = new Konexioa();
            String email = emaila.getText();
            String pas = pasahitza.getText();
            if (conn.saioaHasi(email, pas)) {
                System.out.println("Login successful");

                return conn.getBezero();
            } else {
                System.out.println("login failed");

                return null;
            }
        } else {
            System.out.println("Login canceled");
            return null;
        }
    }



}
