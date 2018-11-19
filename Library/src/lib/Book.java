package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JSeparator;

public class Book extends JFrame {

	static Book frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void call() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					frame= new Book();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.setBounds(166, 92, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						AddBook.call();
					}
					
				});
		
		
		JButton btnNewButton_1 = new JButton("Remove Books");
		btnNewButton_1.setBounds(155, 154, 111, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						RemoveBook.call();
					}
					
				});
		
		JButton btnNewButton_2 = new JButton("Get Book Info");
		btnNewButton_2.setBounds(161, 216, 99, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try {
							frame.setVisible(false);
							new BookInfo().call();
							//BookInfo frame1 = new BookInfo();
							//frame1.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
		
		JButton btnNewButton_3 = new JButton("Get a Book");
		btnNewButton_3.setBounds(166, 278, 89, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						GetBook.call();
					}
					
				});
		
		JLabel lblNewLabel = new JLabel("TSEC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(180, 11, 60, 33);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 401, 2);
		contentPane.add(separator);
	}
}
