package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start extends JFrame {

	private JPanel contentPane;
	static Start frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWelcome.setBounds(162, 40, 109, 27);
		contentPane.add(lblWelcome);
		
		JButton btnCreateNew = new JButton("Create New");
		
		btnCreateNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateNew.setBounds(157, 111, 120, 23);
		contentPane.add(btnCreateNew);
		btnCreateNew.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						Library.call(0);
						frame.setVisible(false);
					}
				});
		
		JButton btnUseExistingOne = new JButton("Use Existing One");
		btnUseExistingOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUseExistingOne.setBounds(136, 181, 162, 23);
		contentPane.add(btnUseExistingOne);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 414, 2);
		contentPane.add(separator);
		
		btnUseExistingOne.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						
						Library.call(1);
						frame.setVisible(false);
					}
					
				});
	}

}
