package crc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Validate extends JFrame {

	static Validate frame;
	private JPanel contentPane;
	private JTextField textField;
	ButtonGroup btgrp;
	ButtonGroup btgrp1;
	ButtonGroup btgrp2;
	ButtonGroup btgrp3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int sts,cnt=0;
	/**
	 * Launch the application.
	 */
	public static void call(final int x) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Validate(x);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Validate(int x)
	{
		sts=x;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVaildation = new JLabel("Vaildation");
		lblVaildation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVaildation.setBounds(188, 11, 57, 17);
		contentPane.add(lblVaildation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 414, 2);
		contentPane.add(separator);
		
		
		JLabel lblSelectSubmission = new JLabel("Select Submission");
		lblSelectSubmission.setBounds(20, 63, 134, 14);
		contentPane.add(lblSelectSubmission);
		
		JRadioButton rbtnOn = new JRadioButton("Online");			//mode onl
		rbtnOn.setBounds(188, 59, 67, 23);
		contentPane.add(rbtnOn);
		
		rbtnOn.addItemListener(new ItemListener()
		{

			public void itemStateChanged(ItemEvent arg0) 
			{
				JLabel lblUploadYourFile = new JLabel("Upload your documents");		//upload file
				lblUploadYourFile.setBounds(20, 101, 148, 14);
				contentPane.add(lblUploadYourFile);
				
				textField = new JTextField();									//upoald tf
				textField.setBounds(188, 97, 86, 20);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Have you taken loan before?");
				lblNewLabel.setBounds(20, 141, 161, 14);
				contentPane.add(lblNewLabel);
				

				JRadioButton rdbtnYes = new JRadioButton("Yes");			//loan before rb
				rdbtnYes.setBounds(188, 136, 67, 23);
				contentPane.add(rdbtnYes);
				
				rdbtnYes.addItemListener(new ItemListener()
				{

					public void itemStateChanged(ItemEvent arg0) 
					{
						JLabel lblPreviousLoanPaid = new JLabel("Previous Loan Paid");	
						lblPreviousLoanPaid.setBounds(20, 183, 148, 14);
						contentPane.add(lblPreviousLoanPaid);
						
						JRadioButton rdbtnBeforeDue = new JRadioButton("Before due");	//loan paid rb
						rdbtnBeforeDue.setBounds(188, 179, 109, 23);
						contentPane.add(rdbtnBeforeDue);
						rdbtnBeforeDue.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent arg0) 
							{
								cnt++;
							}	
						});
						
						JRadioButton rdbtnOnTime = new JRadioButton("On time");			//loan paid rb
						rdbtnOnTime.setBounds(188, 205, 109, 23);
						contentPane.add(rdbtnOnTime);
						
						JRadioButton rdbtnAfterDue = new JRadioButton("After due");		//loan paid rb
						rdbtnAfterDue.setBounds(188, 231, 109, 23);
						contentPane.add(rdbtnAfterDue);
						rdbtnAfterDue.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent arg0) 
							{
								cnt--;
							}	
						});
						
						btgrp2 = new ButtonGroup();
						btgrp2.add(rdbtnBeforeDue);
						btgrp2.add(rdbtnOnTime);
						btgrp2.add(rdbtnAfterDue);
						
						JLabel lblMortageValue = new JLabel("Mortage Value");
						lblMortageValue.setBounds(20, 265, 134, 14);
						contentPane.add(lblMortageValue);
						
						JRadioButton rdbtnGreaterThanLoan = new JRadioButton("Greater than Loan");	//mor val rb
						rdbtnGreaterThanLoan.setBounds(188, 261, 134, 23);
						contentPane.add(rdbtnGreaterThanLoan);
						rdbtnAfterDue.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent arg0) 
							{
								cnt++;
							}	
						});
						
						JRadioButton rdbtnSameAsLoan = new JRadioButton("Same as Loan");			//mor val rb
						rdbtnSameAsLoan.setBounds(188, 287, 109, 23);
						contentPane.add(rdbtnSameAsLoan);
						
						JRadioButton rdbtnLessThanLoan = new JRadioButton("Less than Loan");		//mor val rb
						rdbtnLessThanLoan.setBounds(188, 313, 120, 23);
						contentPane.add(rdbtnLessThanLoan);
						rdbtnAfterDue.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent arg0) 
							{
								cnt--;
							}	
						});
						btgrp3 = new ButtonGroup();
						btgrp3.add(rdbtnGreaterThanLoan);
						btgrp3.add(rdbtnSameAsLoan);
						btgrp3.add(rdbtnLessThanLoan);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(10, 256, 414, 2);
						contentPane.add(separator_1);
						
						JSeparator separator_2 = new JSeparator();
						separator_2.setBounds(10, 170, 414, 4);
						contentPane.add(separator_2);
						
						frame.repaint();
					}
					
				});
				
				JRadioButton rdbtnNo = new JRadioButton("No");				//loan before no rb
				rdbtnNo.setBounds(253, 136, 57, 23);
				contentPane.add(rdbtnNo);
				
				rdbtnNo.addItemListener(new ItemListener()
				{

					public void itemStateChanged(ItemEvent arg0) 
					{
						JLabel lblPreviousLoanPaid = new JLabel("Upload your Guaranter's documents");	
						lblPreviousLoanPaid.setBounds(20, 183, 220, 14);
						contentPane.add(lblPreviousLoanPaid);
					
						textField_1 = new JTextField();
						textField_1.setBounds(250, 180, 90, 20);
						contentPane.add(textField_1);
						textField_1.setColumns(10);
						
						frame.repaint();
					}
					
				});
				
				btgrp = new ButtonGroup();
				btgrp.add(rdbtnNo);
				btgrp.add(rdbtnYes);
				
				frame.repaint();
			}
			
		});
		
		JRadioButton rbtnOff = new JRadioButton("Offline");			//mode off
		rbtnOff.setBounds(253, 59, 109, 23);
		contentPane.add(rbtnOff);
		
		rbtnOff.addItemListener(new ItemListener()
		{

			public void itemStateChanged(ItemEvent arg0) 
			{
				JLabel lblSelectDateAnd = new JLabel("Select Date and timing of Meeting");
				lblSelectDateAnd.setBounds(20, 109, 189, 14);
				contentPane.add(lblSelectDateAnd);
				
				JLabel lblDate = new JLabel("Date :");
				lblDate.setBounds(20, 145, 46, 14);
				contentPane.add(lblDate);
				
				JLabel lblTime = new JLabel("Time :");
				lblTime.setBounds(20, 173, 46, 14);
				contentPane.add(lblTime);
				
				textField_2 = new JTextField();
				textField_2.setBounds(68, 142, 86, 20);
				contentPane.add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(68, 170, 86, 20);
				contentPane.add(textField_3);
				textField_3.setColumns(10);
				
				frame.repaint();
			}
			
		});
		
		btgrp1 = new ButtonGroup();
		btgrp1.add(rbtnOn);
		btgrp1.add(rbtnOff);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Result.call(sts,cnt);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(172, 346, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
