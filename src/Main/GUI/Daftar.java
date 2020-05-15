package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Daftar extends JFrame{
		JLabel lTitle, lUsername,lPassword;
		JButton bSignUp, bBack,bExit;
		JTextField fUsername, fPassword;

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
								window.setVisible(false);
								new Login();
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
