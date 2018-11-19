package crc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;

public class Welcome extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		
		Welcome frame = new Welcome();
		frame.setVisible(true);
		Thread.sleep(2000);
		frame.dispose();
		Login.call();

	}

	

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Welcome() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setForeground(new Color(0, 128, 0));
		lblWelcome.setBackground(Color.LIGHT_GRAY);
		lblWelcome.setBounds(181, 35, 71, 22);
		contentPane.add(lblWelcome);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(211, 78, 29, 14);
		contentPane.add(lblTo);
		
		JLabel lblOnlineCreditCheck = new JLabel("Online Credit Check");
		lblOnlineCreditCheck.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblOnlineCreditCheck.setForeground(Color.BLUE);
		lblOnlineCreditCheck.setBounds(103, 114, 228, 32);
		contentPane.add(lblOnlineCreditCheck);
		
		
	
	}
}
