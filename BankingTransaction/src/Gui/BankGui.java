package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import Gui.EditDetails;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Font;
import javax.swing.JPasswordField;

public class BankGui extends JFrame {

	static public String id;
	static public String pass;
	static public double iniBal;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private final Action action = new SwingAction();

	static BankGui frame;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BankGui();
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
	public BankGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("34px"),
				ColumnSpec.decode("108px"),
				ColumnSpec.decode("35px"),
				ColumnSpec.decode("112px"),},
			new RowSpec[] {
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				RowSpec.decode("27px"),
				RowSpec.decode("28px"),
				RowSpec.decode("30px"),
				RowSpec.decode("28px"),
				RowSpec.decode("30px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),}));
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblWelcome, "4, 2, center, fill");
		
		JLabel lblEnterLoginId = new JLabel("Enter Login Id");
		contentPane.add(lblEnterLoginId, "2, 4, left, top");
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		contentPane.add(lblEnterPassword, "2, 6, left, top");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "4, 6, fill, default");
		
		JLabel lblEnterInitialAmount = new JLabel("Enter Initial Amount");
		contentPane.add(lblEnterInitialAmount, "2, 8, right, top");
		
		textField = new JTextField();
		contentPane.add(textField, "4, 4, right, top");
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "4, 8, right, top");
		textField_2.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		contentPane.add(btnOk, "4, 9, fill, top");
		btnOk.addActionListener(action);

		
			
		
	}
	
	private class SwingAction extends AbstractAction {
		
		public void actionPerformed(ActionEvent e) 
		{
			id = textField.getText();
			pass = passwordField.getText();
			iniBal = Double.parseDouble(textField_2.getText());
			frame.setVisible(false);
			//JOptionPane.showMessageDialog(null, pass);
			new EditDetails().call(null);
		}
	}
}
