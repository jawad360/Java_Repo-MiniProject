package gui.jd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NestingS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NestingS frame = new NestingS();
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
	public NestingS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 6, 298, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(23, 64, 55, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 52, 122, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(243, 52, 39, 28);
		panel.add(spinner);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			
		{String x = spinner.getParent().getComponent(0).getName();
		JOptionPane.showMessageDialog(null, x);
		
			}
		});
		btnNewButton.setBounds(65, 159, 90, 28);
		panel.add(btnNewButton);
		
		spinner.getParent().getComponent(0).getName();
		
	}
}
