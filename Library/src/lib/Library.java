package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Library extends JFrame 
{
	public String rBook="C://Books.ser";
	public String rLog="C://Log.ser";
	Log l = new Log();

	private JPanel contentPane;
	private JTextField textField;
	JButton btnNewButton;
	private JPasswordField passwordField;
	
	static String id;		//static to access it any where
	static String pass;		//demonst in bookinfo using class reference
	static Library frame;
	int chk;

	/**
	 * Launch the application.
	 */
	public static void call(final int x) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Library(x);
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
	public Library(int x) {
		
		chk=x;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibrary = new JLabel("LIBRARY");
		lblLibrary.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLibrary.setBounds(171, 11, 92, 38);
		contentPane.add(lblLibrary);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 60, 403, 2);
		contentPane.add(separator);
		
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLoginId.setBounds(52, 96, 62, 26);
		contentPane.add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(52, 161, 78, 26);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(171, 102, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setBounds(172, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 161, 159, 20);
		contentPane.add(passwordField);
		
		 
		btnNewButton.addActionListener(
				new ActionListener()
				{
		
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						id = (textField.getText());			//static member can be accessed...?
						pass=(passwordField.getText());
						
						l.setId(id);
						l.setPass(pass);
						
						
						try 
						{
							if (chk==0)
								create();
							else
								login();
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
						finally
						{
							frame.setVisible(false);
						}
						
					}
					
				});
		
	}
	
	public void create() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(rLog,true);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		
		out.writeObject(l);
		out.close();
		frame.setVisible(false);
		Book.call();
	}
	public void login() throws IOException
	{
		FileInputStream fis = new FileInputStream(rLog);
		ObjectInputStream in = null;
		
		Log log;
		
		try
		{
			while(true)
			{
				in = new ObjectInputStream(fis);
				log = (Log)in.readObject();
				
				if(l.getId().equals(log.getId()) && l.getPass().equals(log.getPass()))
						{
							frame.setVisible(false);
							Book.call();
						}
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			in.close();
		}
		
		
	}
	public void call()
	{
		new Book().call();
	}
}

