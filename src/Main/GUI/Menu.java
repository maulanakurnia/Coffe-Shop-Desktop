package Main.GUI;

import Main.Controller.DataProduk;
import Main.Controller.DataUser;
import Main.Controller.UserSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
		DataUser user 		= new DataUser();
		JFrame window 		= new JFrame("Coffee House");
		JLabel halo				= new JLabel();
		JButton bKopi 		= new JButton("Menu");
		JButton bDompet 	= new JButton("Saldo");
		JButton bBayar 		= new JButton("Bayar");
		JButton bPesan 		= new JButton("Daftar Pesanan");
		JButton bExit 		= new JButton("X");
		JButton bLogout 	= new JButton("Log Out");

		String id	 	= UserSession.getId_user();
		int role 		= UserSession.getRole();
		String nama = UserSession.getNama();

		public Menu(){
				initComponents();

				window.setLayout(null);
				window.setSize(500, 370);
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				window.setResizable(false);


				bKopi.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							window.setVisible(false);
							new Pesan();
						}
				});
//				bBayar.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//								setVisible(false);
//								new Bayar();
//						}
//				});
//
//				bDompet.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//								setVisible(false);
//								new Dompet();
//						}
//				});
//
//				bPesan.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//								setVisible(false);
//								new Pesan();
//						}
//				});
        /*bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pesan();
            }
        });
        bDompet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Delete();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        /*bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Edit();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });*/

				bExit.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								System.exit(0);
						}
				});

				bLogout.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							DataProduk produk = new DataProduk();
							produk.setIdPemesanan(null);
							UserSession.setId_user(null);
							window.setVisible(false);
							new Login();
						}
				});
		}

		public void initComponents(){
				window.getContentPane().setBackground(new Color(28, 27, 27));
				window.add(halo);
						halo.setText("Halo, "+nama);
						halo.setFont(new Font("Arial", Font.BOLD,20));
						halo.setForeground(new Color(255,255,255));
						halo.setBounds(150,30,220,30);

				window.add(bKopi);
						bKopi.setBounds(10, 120, 220, 30);
						bKopi.setForeground(new Color(255, 255, 255));
						bKopi.setBackground(new Color(82, 77, 64));

				window.add(bPesan);
						bPesan.setBounds(250, 120, 220, 30);
						bPesan.setForeground(new Color(255,255,255));
						bPesan.setBackground(new Color(82, 77, 64));

				window.add(bBayar);
						bBayar.setBounds(10, 160, 220, 30);
						bBayar.setForeground(new Color(255,255,255));
						bBayar.setBackground(new Color(82, 77, 64));

				window.add(bDompet);
						bDompet.setBounds(250, 160, 220, 30);
						bDompet.setForeground(new Color(255,255,255));
						bDompet.setBackground(new Color(82, 77, 64));

				window.add(bLogout);
						bLogout.setBackground(new Color(102, 55, 51));
						bLogout.setForeground(new Color(255,255,255));
						bLogout.setBounds(380, 200, 90, 30);

				window.add(bExit);
						bExit.setBackground(new Color(102, 55, 51));
						bExit.setForeground(new Color(255,255,255));
						bExit.setBounds(325, 200, 45, 30);

		}
}
