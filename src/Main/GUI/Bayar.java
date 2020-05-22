package Main.GUI;

import Main.Controller.DataProduk;
import Main.Controller.DataDompet;
import Main.Controller.Koneksi;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Bayar {
    Koneksi koneksi = new Koneksi();
    Statement statement;

    private static final SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));

    // Label
    JFrame window         = new JFrame("PEMBAYARAN");
    JLabel lIdPesanan     = new JLabel("ID Pesanan");
    JLabel lTotal         = new JLabel("Total");
    JLabel lKursi         = new JLabel("KURSI");
    // Text Field
    JTextField fIdPesanan = new JTextField();
    JTextField fTotal     = new JTextField();
    // Button
    JButton bBayar        = new JButton("Bayar");
    JButton bKembali      = new JButton("Kembali");
    // Combo Box
    JComboBox<String> cKursi = new JComboBox<>();


    public Bayar(){
        if(UserSession.getId_user() == null){
            JOptionPane.showMessageDialog(null, "Silahkan login terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            window.setVisible(true);
            new Login();
        }else if(UserSession.getIdPemesanan() == null){
            JOptionPane.showMessageDialog(null, "Maaf anda belum memesan", "Peringatan", JOptionPane.WARNING_MESSAGE);
            window.setVisible(true);
            new Login();
        }else {
            initComponents();
            initListeners();
        }
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
            fTotal.setText(" Rp."+nf.format(DataProduk.getTotal()));
            fTotal.setEditable(false);

        window.add(lKursi);
        lKursi.setBounds(50,95,120,25);
        lKursi.setForeground(new Color(255, 255, 255));
            window.add(cKursi);
            cKursi.setBounds(140,95,210,25);
            cKursi.addItem(" --- PILIH NOMOR KURSI ---");
            for(int i=1; i<25; i++) {
                cKursi.addItem("00"+i);
            }
        window.add(bBayar);
            bBayar.setBounds(140,130,110,25);
            bBayar.setForeground(new Color(255,255,255));
            bBayar.setBackground(new Color(58, 133, 86));

        window.add(bKembali);
            bKembali.setBounds(260,130,90,25);
            bKembali.setForeground(new Color(255,255,255));
            bKembali.setBackground(new Color(145, 141, 58));

        window.setLayout(null);
        window.setSize(420, 210);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }

    private void initListeners(){
        TabelPesanan tabelPesanan = new TabelPesanan();
        bBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bayar();
                tabelPesanan.window.setVisible(false);
                window.setVisible(false);
                new MenuUtama();
            }
        });

        bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelPesanan.window.setVisible(false);
                window.setVisible(false);
                new MenuUtama();
            }
        });
    }

    private void bayar(){
        try{
            statement = koneksi.getConnection().createStatement();
            if(DataDompet.getSaldo() <= DataProduk.getTotal()){
                JOptionPane.showMessageDialog(null, "Mohon maaf saldo anda tidak mencukupi!","Informasi",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "Silahkan isi saldo anda!","Informasi",JOptionPane.WARNING_MESSAGE);
            }else {
                DataDompet.kurangSaldo(DataProduk.getTotal());
                String bayar = "INSERT INTO detail_pesanan VALUES(default,'" + UserSession.getIdPemesanan() + "','" + cKursi.getSelectedItem() + "','" + time.format(timestamp) + "','" + DataProduk.getTotal() + "','TELAH DIBAYAR')";
                String saldo = "UPDATE dompet set jumlah = '" + DataDompet.getSaldo() + "' WHERE id_user='" + UserSession.getId_user() + "'";
                String Rsaldo = "INSERT INTO riwayat_saldo VALUES(default,'" + DataDompet.getIdDompet() + "','" + ("- " + DataProduk.getTotal()) + "','" + time.format(timestamp) + "','PEMBELIAN')";
                int disimpan = statement.executeUpdate(bayar);
                int diUpdate = statement.executeUpdate(saldo);
                int riwayatSaldo = statement.executeUpdate(Rsaldo);
                if (disimpan == 1 && diUpdate == 1 && riwayatSaldo == 1) {
                    JOptionPane.showMessageDialog(null, "Terimakasih telah membayar pesanan!", "Informasi", JOptionPane.WARNING_MESSAGE);
                    UserSession.setIdPemesanan(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Pembayaran gagal!", "Informasi", JOptionPane.WARNING_MESSAGE);
                }
                statement.close();
            }
        }catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan !!");
        }
    }
}
