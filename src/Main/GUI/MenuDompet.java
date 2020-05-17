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

public class MenuDompet {
    DataUser user 		= new DataUser();
    JFrame window 		= new JFrame("MENU DOMPET");
    JLabel saldo		= new JLabel();
    JButton bIsiSaldo 	= new JButton("Isi Saldo");
    JButton bRiwayat 	= new JButton("Riwayat Saldo");
    JButton bKembali 	= new JButton("Kembali");

    NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));

    public MenuDompet(){
        if(UserSession.getId_user() == null){
            JOptionPane.showMessageDialog(null, "Silahkan login terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            window.setVisible(false);
            new Login();
        }else {
            initComponents();

            window.setLayout(null);
            window.setSize(300, 300);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setResizable(false);


            bIsiSaldo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.setVisible(false);
                    new Pesan();
                }
            });

            bRiwayat.addActionListener(new ActionListener() {
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
                    new MenuUtama();
                }
            });
        }
    }

    public void initComponents(){
        window.getContentPane().setBackground(new Color(28, 27, 27));

        window.add(saldo);
        saldo.setText("Saldo anda Rp."+ nf.format(DataDompet.getSaldo()));
        saldo.setFont(new Font("Courier",Font.PLAIN,14));
        saldo.setForeground(new Color(255,255,255));
        saldo.setBounds(47,30,220,30);

        window.add(bIsiSaldo);
        bIsiSaldo.setBounds(47, 80, 200, 30);
        bIsiSaldo.setForeground(new Color(255, 255, 255));
        bIsiSaldo.setBackground(new Color(82, 77, 64));

        window.add(bRiwayat);
        bRiwayat.setBounds(47, 120, 200, 30);
        bRiwayat.setForeground(new Color(255,255,255));
        bRiwayat.setBackground(new Color(82, 77, 64));

        window.add(bKembali);
        bKembali.setBounds(47, 160, 200, 30);
        bKembali.setForeground(new Color(255,255,255));
        bKembali.setBackground(new Color(82, 77, 64));

    }
}
