package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

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
								window.setVisible(false);
								new Menu();
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
