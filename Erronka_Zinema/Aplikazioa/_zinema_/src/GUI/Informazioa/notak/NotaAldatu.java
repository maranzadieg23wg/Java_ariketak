package GUI.Informazioa.notak;

import DatuBase.Konexioa;

import javax.swing.*;

public class NotaAldatu {

    public static boolean notaAldatu(int id, float notaaa, int kopa) {
        Konexioa conn = null;
        try {
            conn = new Konexioa();

            while (true) {
                JTextField notab = new JTextField(String.valueOf(notaaa));
                JTextField ikusKop = new JTextField(String.valueOf(kopa));


                Object[] message = {
                        "Nota:", notab,
                        "Ikusitako Kopurua:", ikusKop,
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Pelikulari nota aldatu", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    float notaa = Float.parseFloat(notab.getText());
                    int kop = Integer.parseInt(ikusKop.getText());


                    conn.notaAldatu(id, 1, notaa, kop);
                    return true;


                } else {
                    System.out.println("Pelikularen nota aldatuta.");
                    return false;
                }

            }
        } catch (Exception e) {
            System.err.println("Arazo general bat gertatu da nota aldatzean pelikula listara");
            System.err.println(e.getMessage());
            return false;
        } finally {
            conn.konexioaItxi();
        }

    }
}
