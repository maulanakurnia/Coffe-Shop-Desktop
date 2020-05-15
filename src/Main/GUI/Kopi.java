package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Kopi extends JFrame{
		JLabel lTitle,lJumlah,lKopi1,lKopi2,lKopi3,lPilih,lUsername,g1;
		JButton bPesan, bBack;
		JTextField  fJumlah,fPilih,fUsername;

		public Kopi(){

				setTitle("Menu");
				lTitle = new JLabel("Menu");
				lTitle.setFont(new Font("arial black", Font.PLAIN, 20));
				lTitle.setForeground(new Color(247, 252, 255));

				lKopi1 = new JLabel("1. Kopi Item");
				lKopi1.setFont(new Font("arial black", Font.PLAIN, 18));
				lKopi1.setForeground(new Color(247, 252, 255));

				lKopi2 = new JLabel("2. Kopi Cappucino ");
				lKopi2.setFont(new Font("arial black", Font.PLAIN, 18));
				lKopi2.setForeground(new Color(247, 252, 255));

				lKopi3 = new JLabel("3. Kopi Mochacino");
				lKopi3.setFont(new Font("arial black", Font.PLAIN, 18));
				lKopi3.setForeground(new Color(247, 252, 255));

				lPilih = new JLabel("Choose number : ");
				lPilih.setFont(new Font("arial black", Font.PLAIN, 18));
				lPilih.setForeground(new Color(247, 252, 255));
				fPilih = new JTextField();
				fPilih.setFont(new Font("arial black", Font.PLAIN, 16));
				fPilih.setForeground(new Color(0, 0, 0));
				fPilih.setBackground(new Color(247, 252, 255));

				lJumlah = new JLabel("Total order: ");
				lJumlah.setFont(new Font("arial black", Font.PLAIN, 18));
				lJumlah.setForeground(new Color(247, 252, 255));
				fJumlah = new JTextField();
				fJumlah.setFont(new Font("arial black", Font.PLAIN, 16));
				fJumlah.setForeground(new Color(0, 0, 0));
				fJumlah.setBackground(new Color(247, 252, 255));

				lUsername = new JLabel("Username : ");
				lUsername.setFont(new Font("arial black", Font.PLAIN, 18));
				lUsername.setForeground(new Color(247, 252, 255));
				fUsername = new JTextField();
				fUsername.setFont(new Font("arial black", Font.PLAIN, 16));
				fUsername.setForeground(new Color(0, 0, 0));
				fUsername.setBackground(new Color(247, 252, 255));

				g1   = new JLabel(new ImageIcon(getClass().getResource("img/kopi.png")));//icon

				bPesan = new JButton("Order");
				bPesan.setFont(new Font("arial",Font.PLAIN, 14));
				bPesan.setBackground(new Color(247, 252, 255));
				bBack = new JButton("Back");
				bBack.setFont(new Font("arial",Font.PLAIN, 14));
				bBack.setBackground(new Color(247, 252, 255));



				getContentPane().setBackground(new Color(12, 164, 255));

				setLayout(null);
				add(lTitle);
				add(lPilih);
				add(fPilih);
				add(lJumlah);
				add(fJumlah);
				add(lUsername);
				add(fUsername);
				add(lKopi1);
				add(lKopi2);
				add(lKopi3);
				add(bPesan);
				add(bBack);
				add(g1);

				lTitle.setBounds(70, 20, 250, 30);
				lKopi1.setBounds(50, 50, 250, 30);
				lKopi2.setBounds(50, 80, 250, 30);
				lKopi3.setBounds(50, 110, 250, 30);


				lPilih.setBounds(50, 150, 250, 30);
				fPilih.setBounds(50, 180, 50, 30);

				lJumlah.setBounds(50, 210, 250, 30);
				fJumlah.setBounds(50, 240, 50, 30);

				lUsername.setBounds(50, 270, 250, 30);
				fUsername.setBounds(50, 300, 150, 30);

				g1.setBounds(50, 5, 300, 300);
				bPesan.setBounds(50, 340, 90, 30);
				bBack.setBounds(150, 340, 90, 30);

				setSize(400, 430);
				setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				bPesan.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								setVisible(false);
								new Menu();
						}
				});

				bBack.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								setVisible(false);
								new Menu();
						}
				});
		}


}
