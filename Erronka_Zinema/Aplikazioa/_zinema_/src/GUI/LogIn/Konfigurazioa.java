package GUI.LogIn;

import DatuBase.Konexioa;
import Objetuak.DB.Bezero;

import javax.swing.*;

public class Konfigurazioa {


    public static void datuakAldatu(Bezero bezero) {
        try {
            Konexioa conn = new Konexioa();

            while (true) {
                JTextField emaila = new JTextField(bezero.getEmaila());
                JTextField pasahitza = new JPasswordField();
                JTextField izena = new JTextField(bezero.getIzena());
                JTextField abizena = new JTextField(bezero.getAbizena());
                JTextField erabiltzailea = new JTextField(bezero.getErabiltzaileIzena());


                Object[] message = {
                        "Email:", emaila,
                        "Pasahitza:", pasahitza,
                        "Izena:", izena,
                        "Abizena:", abizena,
                        "Erabiltzailea:", erabiltzailea
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Kontuko datuak aldatu", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    String email = emaila.getText();
                    String pas = pasahitza.getText();
                    String ize = izena.getText();
                    String abi = abizena.getText();
                    String era = erabiltzailea.getText();
                    boolean emailEzis = conn.ezistitzenDaEmail(email);
                    boolean erabiltzaileEzis = conn.ezistitzenDaErabiltzailea(era);


                    if ((!emailEzis && !erabiltzaileEzis) || email.equals(bezero.getEmaila()) && era.equals(bezero.getErabiltzaileIzena())) {
                        conn.erabiltzaileaAldatu(bezero.getIdErabiltzailea(), email, pas, ize, abi, era);
                        break;

                    } else if (emailEzis) {
                        JOptionPane.showMessageDialog(null, email+" :emaila ezistitzen da.", "Emaila ezistitzen da", JOptionPane.ERROR_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, era+" :erabiltailea ezistitzen da.", "Erabiltzailea ezistitzen da", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Kontuko datuak aldatzea ezestatu egin da.");
                    break;
                }

                conn.konexioaItxi();
            }
        }catch (Exception e){
            System.err.println("Arazo general bat gertatu da datuak aldatzean");
            System.err.println(e.getMessage());

        }

    }
}
