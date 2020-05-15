package Main.GUI;

import Main.Controller.DataUser;
import Main.Controller.Koneksi;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {
		ResultSet resultSet;
		Statement statement;
		String id = null;
		int role	= 0;
		String nama	= null;

		JFrame window 	= new JFrame("Login");
		JLabel lEmail		= new JLabel("Email : ");
		JLabel lsandi		= new JLabel("Sandi :");

		JTextField fEmail	= new JTextField();
		JTextField fSandi	= new JTextField();

		JButton bMasuk = new JButton("Masuk");
		JButton bDaftar = new JButton("Daftar");



		public Login(){
				initComponents();

				window.setLayout(null);
				window.setSize(460, 250);
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				window.setResizable(false);

				bMasuk.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								Koneksi koneksi = new Koneksi();
								String email = fEmail.getText();
								String sandi = fSandi.getText();

								try {
										statement = koneksi.getConnection().createStatement();
										String sql = "SELECT * FROM user a INNER JOIN role b WHERE email='"+ email + "' AND sandi='"+ sandi +"'";
										resultSet = statement.executeQuery(sql);

										if(resultSet.next()){
												id 		= resultSet.getString("id");
												UserSession.setId_user(id);
												nama 	= resultSet.getString("nama");
												UserSession.setNama(nama);
												role 	= resultSet.getInt("id_role");
												UserSession.setRole(role);

												window.setVisible(false);
												new Menu();
												statement.close();

										}else {
												JOptionPane.showMessageDialog(null, "Email atau sandi salah!");
												fEmail.setText("");
												fSandi.setText("");
										}
								} catch (SQLException sqlError) {
										JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
								} catch (ClassNotFoundException classError) {
										JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
								}

						}
				});
				bDaftar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								window.setVisible(false);
								new Daftar();
						}
				});

		}

		public void initComponents(){
				window.getContentPane().setBackground(new Color(28, 27, 27));
				window.add(lEmail);
				lEmail.setBounds(50, 15, 50, 60);
				lEmail.setForeground(new Color(255, 255, 255));
					window.add(fEmail);
					fEmail.setBounds(130, 30,270,30);

				window.add(lsandi);
				lsandi.setBounds(50, 65, 50, 60);
				lsandi.setForeground(new Color(255, 255, 255));
					window.add(fSandi);
					fSandi.setBounds(130, 80, 270, 30);

				window.add(bMasuk);
				bMasuk.setBounds(130, 130, 165, 30);
				bMasuk.setForeground(new Color(255,255,255));
				bMasuk.setBackground(new Color(58, 133, 86));

				window.add(bDaftar);
				bDaftar.setBounds(310, 130, 90,30);
				bDaftar.setForeground(new Color(255,255,255));
				bDaftar.setBackground(new Color(58, 119, 133));

		}


}
