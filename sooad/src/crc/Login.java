package crc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import org.jdesktop.swingx.prompt.PromptSupport;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel error;
	static Login frame;
	String[] user = new String[]{"123456","A789456","S741852","J963852"}; 
	String[] pw = new String[]{"123456","A789456","S741852","J963852"};
	int[] sts = new int[]{1,0,1,0}; 
	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogIn.setBounds(194, 34, 46, 20);
		contentPane.add(lblLogIn);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("UserName");
		txtUsername.setBounds(175, 85, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 143, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblAccountNumber = new JLabel("Account Number :");
		lblAccountNumber.setBounds(60, 91, 122, 14);
		contentPane.add(lblAccountNumber);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(60, 149, 101, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(175, 198, 89, 23);
		contentPane.add(btnLogIn);
		
		error = new JLabel("Invalid Account Number or Password");
		error.setForeground(Color.RED);
		error.setBounds(129, 176, 231, 14);
		contentPane.add(error);
		error.setVisible(false);
		
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String un = txtUsername.getText();
				String pass = passwordField.getText();
				
				for(int i=0;i<user.length;i++)
					if(user[i].equals(un))
					{
						if(pw[i].equals(pass))
						{
							Validate.call(sts[i]);
							frame.dispose();
						}
						else
							error.setVisible(true);
					}
				error.setVisible(true);
				
			}
		});
		
		
		
	}
}
