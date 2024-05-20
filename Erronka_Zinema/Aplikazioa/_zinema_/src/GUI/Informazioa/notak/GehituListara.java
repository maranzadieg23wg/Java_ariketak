package GUI.Informazioa.notak;

import DatuBase.Konexioa;
import Objetuak.DB.Bezero;

import javax.swing.*;
import java.util.Objects;

public class GehituListara {

    public static boolean gehituListara(int id) {
        Konexioa conn = null;
        try {
            conn = new Konexioa();

            while (true) {
                JTextField nota = new JTextField();
                JTextField ikusKop = new JTextField();


                Object[] message = {
                        "Nota:", nota,
                        "Ikusitako Kopurua:", ikusKop,
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Gehitu pelikula listara", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    float notaa = Float.parseFloat(nota.getText());
                    int kop = Integer.parseInt(ikusKop.getText());


                    conn.gehituIkusitakoPeli(id, 1, notaa, kop);
                    return true;


                } else {
                    System.out.println("Pelikula gehitu egin da listara.");
                    return false;
                }

            }
        } catch (Exception e) {
            System.err.println("Arazo general bat gertatu da gehitzean pelikula listara");
            System.err.println(e.getMessage());
            return false;
        } finally {
            conn.konexioaItxi();
        }

    }
}
