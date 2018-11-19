package crc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Result extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void call(final int sts, final int cnt) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result(sts,cnt);
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
	public Result(int sts, int cnt) 
	{
		getContentPane().setLayout(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(sts==1 && cnt>=0)
		{
			JLabel lblCongratulation = new JLabel("Congratulation.....");
			lblCongratulation.setForeground(Color.RED);
			lblCongratulation.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblCongratulation.setBounds(133, 58, 215, 26);
			contentPane.add(lblCongratulation);
			
			JLabel lblYourLoanIs = new JLabel("Your Loan is granted.");
			lblYourLoanIs.setForeground(Color.BLUE);
			lblYourLoanIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblYourLoanIs.setBounds(140, 124, 208, 20);
			contentPane.add(lblYourLoanIs);
		}
		else
		{
			JLabel lblSorryYourLoan = new JLabel("Sorry... Your Loan is not granted");
			lblSorryYourLoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblSorryYourLoan.setBounds(97, 120, 240, 21);
			getContentPane().add(lblSorryYourLoan);
		}
	}

}
