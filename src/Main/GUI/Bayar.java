package Main.GUI;

import Main.Controller.DataProduk;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;

public class Bayar {
    JFrame window         = new JFrame("PEMBAYARAN");
    DataProduk produk     = new DataProduk();
    JLabel lIdPesanan     = new JLabel("ID Pesanan");
    JTextField fIdPesanan = new JTextField();
    JLabel lTotal         = new JLabel("Total");
    JTextField fTotal     = new JTextField();
    JLabel lKursi         = new JLabel("KURSI");
    JComboBox cKursi      = new JComboBox();


    public Bayar(){
        new TabelPesanan();
        initComponents();

        window.setLayout(null);
        window.setSize(420, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }

    private void initComponents() {
        window.getContentPane().setBackground(new Color(28, 27, 27));

        window.add(lIdPesanan);
        lIdPesanan.setBounds(50,25,120,25);
        lIdPesanan.setForeground(new Color(255, 255, 255));
            window.add(fIdPesanan);
            fIdPesanan.setBounds(140,25,210,25);
            fIdPesanan.setText(UserSession.getIdPemesanan());
            fIdPesanan.setEditable(false);

        window.add(lTotal);
        lTotal.setBounds(50,60,120,25);
        lTotal.setForeground(new Color(255, 255, 255));
            window.add(fTotal);
            fTotal.setBounds(140,60,210,25);
            fTotal.setText(String.valueOf(produk.getTotal()));
            fTotal.setEditable(false);

        window.add(lKursi);
        lKursi.setBounds(50,95,120,25);
        lKursi.setForeground(new Color(255, 255, 255));
            window.add(cKursi);
            cKursi.setBounds(140,95,210,25);

    }
}
