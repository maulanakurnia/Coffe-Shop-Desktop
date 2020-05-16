package Main.GUI;

import Main.Controller.Koneksi;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TabelProduk {
    JFrame window 	        = new JFrame("Tabel Produk");
    String[][] datas        = new String[100][3];
    String[] kolom          = {"Nama Kopi","Harga", "Stok"};
    JTable tTable           = new JTable(datas,kolom);
    JScrollPane scrollPane  = new JScrollPane(tTable);
    ResultSet resultSet;
    Statement statement;

    public TabelProduk() {
        initComponents();
        loadData();

        window.setSize(470, 420);
        window.setVisible(true);
//        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

    }

    private void initComponents(){
        window.getContentPane().setBackground(new Color(28, 27, 27));

        window.add(scrollPane);
        scrollPane.setBounds(70, 70, 400, 400);

    }

    private void loadData(){
        Koneksi koneksi = new Koneksi();
        try{
            statement = koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM produk";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                datas[row][0] = resultSet.getString("nama_kopi");
                datas[row][1] = resultSet.getString("harga");
                datas[row][2] = resultSet.getString("stok");
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
