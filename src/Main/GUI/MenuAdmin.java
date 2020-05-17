package Main.GUI;

import Main.Controller.DataDompet;
import Main.Controller.DataUser;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class MenuAdmin {
    JFrame window 		= new JFrame("MENU ADMIN");
    JButton bKuser 	    = new JButton("Kelola User");
    JButton bKproduk 	= new JButton("Kelola Produk");
    JButton bKembali 	= new JButton("Kembali");

    NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));

    public MenuAdmin(){
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
                new KelolaUser();
            }
        });

        bKproduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(true);
                new KelolaProduk();
            }
        });

        bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                new MenuUtama();
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
