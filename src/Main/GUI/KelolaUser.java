package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class KelolaUser {
    JFrame window 		= new JFrame("Kelola User");
    JButton bKuser 	    = new JButton("Lihat User");
    JButton bKproduk 	= new JButton("Tambah User");
    JButton bKembali 	= new JButton("Kembali");

    NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));

    public KelolaUser(){
        initComponents();

        window.setLayout(null);
        window.setSize(300, 300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);


        bKuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                new Pesan();
            }
        });

        bKproduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(true);
                new TabelRiwayatSaldo();
            }
        });

        bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                new MenuAdmin();
            }
        });
    }

    public void initComponents(){
        window.getContentPane().setBackground(new Color(28, 27, 27));

        window.add(bKuser);
        bKuser.setBounds(47, 80, 200, 30);
        bKuser.setForeground(new Color(255, 255, 255));
        bKuser.setBackground(new Color(82, 77, 64));

        window.add(bKproduk);
        bKproduk.setBounds(47, 120, 200, 30);
        bKproduk.setForeground(new Color(255,255,255));
        bKproduk.setBackground(new Color(82, 77, 64));

        window.add(bKembali);
        bKembali.setBounds(47, 160, 200, 30);
        bKembali.setForeground(new Color(255,255,255));
        bKembali.setBackground(new Color(82, 77, 64));
    }
}
