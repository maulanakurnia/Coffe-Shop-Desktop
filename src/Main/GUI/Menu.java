package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
		JFrame window 		= new JFrame("Coffee House");
		JButton bKopi 		= new JButton("Menu");
		JButton bDompet 	= new JButton("Saldo");
		JButton bBayar 		= new JButton("Bayar");
		JButton bPesan 		= new JButton("Daftar Pesanan");
		JButton bExit 		= new JButton("Keluar");
		JButton bLogout 	= new JButton("Log Out");


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
								setVisible(false);
								new Kopi();
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
								setVisible(false);
								new Login();
						}
				});
		}

		public void initComponents(){
				window.getContentPane().setBackground(new Color(28, 27, 27));

				window.add(bKopi);
						bKopi.setBounds(10, 120, 220, 30);
						bKopi.setForeground(new Color(255,255,255));
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
						bLogout.setBounds(140, 200, 90, 30);

				window.add(bExit);
						bExit.setBackground(new Color(102, 55, 51));
						bExit.setForeground(new Color(255,255,255));
						bExit.setBounds(250, 200, 90, 30);

		}
}
