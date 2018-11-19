package Gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDetails extends JFrame {

	private JPanel contentPane;
	
	static EditDetails frame ;
	private JTextField textField;
	JLabel lbl;
	private JTextField textField_1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public  void call(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EditDetails();
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
	public EditDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("137px"),
				ColumnSpec.decode("121px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("31px"),
				RowSpec.decode("24px"),
				RowSpec.decode("26px"),
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		

		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Deposit", "Withdraw", "Info", "Change PIN"}));
		contentPane.add(comboBox, "2, 2, fill, top");
		
		lbl = new JLabel("");
		lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
		contentPane.add(lbl, "2, 4, center, center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "2, 6, fill, default");
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("OK");
		contentPane.add(btnNewButton, "2, 10");

		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getSelectedItem().equals("Withdraw"))
				{
					BankGui.iniBal -= Double.parseDouble(textField_1.getText());
					frame.setVisible(false);
					new EditDetails().call(null);
				}
				
				if(comboBox.getSelectedItem().equals("Deposit"))
				{
					
					BankGui.iniBal += Double.parseDouble(textField_1.getText());
					frame.setVisible(false);
					new EditDetails().call(null);
					
				}
				if(comboBox.getSelectedItem().equals("Info"))
				{
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null,"Login: "+BankGui.id+"\nPassword: "+BankGui.pass+"\nBalance: "+BankGui.iniBal);
					
				}
				if(comboBox.getSelectedItem().equals("Change PIN"))
				{
					BankGui.pass = textField_1.getText();
					frame.setVisible(false);
					new EditDetails().call(null);
					
				}
			}
		});
		
		
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				
				if(comboBox.getSelectedItem().equals("Deposit"))
				{
					lbl.setText("Enter Amount to Deposit");
					textField_1.setVisible(true);

				}
				
				if(comboBox.getSelectedItem().equals("Withdraw"))
				{
					lbl.setText("Enter Amount to Withdraw");
					textField_1.setVisible(true);
					
				}
				if(comboBox.getSelectedItem().equals("Info"))
				{
					lbl.setText("No info available");
					textField_1.setVisible(false);
					
				}
				if(comboBox.getSelectedItem().equals("Change PIN"))
				{
					lbl.setText("Enter new PIN");
					textField_1.setVisible(true);
				}
			
					
			}
		});
		
		
		
		
		
	}
}
