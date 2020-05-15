package Main.GUI;

import Main.Controller.Koneksi;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daftar extends JFrame{
		ResultSet resultSet;
		Statement statement;

		JFrame window 	= new JFrame("Daftar Akun");
		JLabel lNama		= new JLabel("Nama :");
		JLabel lEmail		= new JLabel("Email : ");
		JLabel lSandi		= new JLabel("Sandi :");
		JLabel lKSandi	= new JLabel("Konfirmasi Sandi : ");

		JTextField fNama  	= new JTextField();
		JTextField fEmail		= new JTextField();
		JTextField fSandi		= new JTextField();
		JTextField fKSandi 	= new JTextField();

		JButton bDaftar 	= new JButton("Daftar");
		JButton bKembali 	= new JButton("Kembali");

		public Daftar(){
				initComponents();

				window.setLayout(null);
				window.setSize(520, 350);
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				window.setResizable(false);

				bDaftar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								Koneksi koneksi = new Koneksi();
								String nama 	= fNama.getText();
								String email 	= fEmail.getText();
								String sandi 	= fSandi.getText();
								String sandiK = fKSandi.getText();
								if(nama.isEmpty() || email.isEmpty() || sandi.isEmpty() || sandiK.isEmpty()){
										if(nama.isEmpty()){
												JOptionPane.showMessageDialog(null, "Nama Tidak boleh kosong!","Peringatan",JOptionPane.WARNING_MESSAGE);
										}else if(email.isEmpty()){
												JOptionPane.showMessageDialog(null, "Email Tidak boleh kosong!","Peringatan",JOptionPane.WARNING_MESSAGE);
										} else if(sandi.isEmpty()){
												JOptionPane.showMessageDialog(null, "Sandi boleh kosong!","Peringatan",JOptionPane.WARNING_MESSAGE);
										} else {
												JOptionPane.showMessageDialog(null, "Konfirmasi Sandi Tidak boleh kosong!","Peringatan",JOptionPane.WARNING_MESSAGE);
										}
								}else if(sandi != sandiK){
										JOptionPane.showMessageDialog(null, "Sandi tidak sama!","Peringatan",JOptionPane.WARNING_MESSAGE);
										fSandi.setText("");
										fKSandi.setText("");
								}else {
										try {

												statement = koneksi.getConnection().createStatement();
												String sql = "SELECT * FROM user a INNER JOIN role b WHERE email='" + email + "' AND sandi='" + sandi + "'";
												resultSet = statement.executeQuery(sql);

												if (resultSet.next()) {
														window.setVisible(false);
														new Menu();
														statement.close();
														window.setVisible(false);
														new Login();

												} else {

														fEmail.setText("");
														fEmail.setText("");
														fSandi.setText("");
												}
										} catch (SQLException sqlError) {
												JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
										} catch (ClassNotFoundException classError) {
												JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
										}
								}
						}
				});

				bKembali.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								window.setVisible(false);
								new Login();
						}
				});
		}

		public void initComponents(){
				window.getContentPane().setBackground(new Color(28, 27, 27));

				window.add(lNama);
						lNama.setBounds(50, 15, 50, 60);
						lNama.setForeground(new Color(255, 255, 255));
								window.add(fNama);
								fNama.setBounds(190, 30,270,30);

				window.add(lEmail);
						lEmail.setBounds(50, 65, 50, 60);
						lEmail.setForeground(new Color(255, 255, 255));
								window.add(fEmail);
								fEmail.setBounds(190, 80, 270, 30);

				window.add(lSandi);
						lSandi.setBounds(50, 115, 50, 60);
						lSandi.setForeground(new Color(255, 255, 255));
								window.add(fSandi);
								fSandi.setBounds(190,130,270,30);

				window.add(lKSandi);
						lKSandi.setBounds(50, 165, 140, 60);
						lKSandi.setForeground(new Color(255, 255, 255));
								window.add(fKSandi);
								fKSandi.setBounds(190,180,270,30);

				window.add(bDaftar);
						bDaftar.setBounds(190, 230, 165, 30);
						bDaftar.setForeground(new Color(255,255,255));
						bDaftar.setBackground(new Color(58, 133, 86));

				window.add(bKembali);
						bKembali.setBounds(370, 230, 90,30);
						bKembali.setForeground(new Color(255,255,255));
						bKembali.setBackground(new Color(58, 119, 133));

		}

}
