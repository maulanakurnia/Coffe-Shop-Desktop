package Main.GUI;

import Main.Controller.DataProduk;
import Main.Controller.Koneksi;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaftarPesanan {
    JFrame window 	        = new JFrame("Daftar Pesanan");
    String[][] datas        = new String[500][4];
    String[] kolom          = {"ID", "Nama Kopi", "Jumlah", "Harga"};
    JTable tTable           = new JTable(datas, kolom);
    JScrollPane scrollPane  = new JScrollPane(tTable);
    JButton bKembali        = new JButton("Kembali");
    JButton bBayar          = new JButton("Bayar");
    JLabel lTotal            = new JLabel();

    ResultSet resultSet;
    Statement statement;

    public DaftarPesanan(){
        initComponents();
        loadData();
        window.setLayout(null);
        window.setSize(570, 620);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                new Menu();
            }
        });

        bBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
//                new Bayar();
            }
        });

    }

    private void initComponents() {
        window.getContentPane().setBackground(new Color(28, 27, 27));
        tTable.setBackground(new Color(247, 252, 255));
            window.add(scrollPane);
            scrollPane.setBounds(70, 70, 400, 400);
            scrollPane.setBackground(new Color(247, 252, 255));

        window.add(bBayar);
        bBayar.setBounds(170, 490, 90, 30);

        window.add(bKembali);
        bKembali.setBounds(270, 490, 90, 30);
    }

    private void loadData(){
        Koneksi koneksi = new Koneksi();
        UserSession session = new UserSession();
        try{
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM pemesanan a INNER JOIN produk b ON a.id_kopi = b.id_kopi WHERE a.id_pemesanan='" + session.getIdPemesanan() + "' AND a.id_user='" + session.getId_user() + "'";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                datas[row][0] = resultSet.getString("id_pemesanan");
                datas[row][1] = resultSet.getString("nama_kopi");
                datas[row][2] = resultSet.getString("jumlah");
                datas[row][3] = resultSet.getString("harga");
                row++;
            }
            statement.close();

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan !!");
        }
    }
}
