package hg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JSeparator;
import javax.swing.JButton;

public class Hangman extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton newGame;
	private JButton highScore;
	private JButton exit;
	static Hangman frame;
	String filePath = "D://Database";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Hangman();
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
	public Hangman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HANGMAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(170, 23, 93, 22);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 61, 394, 12);
		contentPane.add(separator);
		
		newGame = new JButton("New Game");
		newGame.setBounds(164, 87, 106, 23);
		contentPane.add(newGame);
		
		newGame.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						Game.main1(null);
						
						frame.setVisible(false);
						frame.dispose();
					}
				});
		
		highScore = new JButton("High Score");
		highScore.setBounds(164, 140, 106, 23);
		contentPane.add(highScore);
		
		highScore.addActionListener(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					
					ObjectInputStream ois = null;
					db.DataBase dba = null;
					try 
					{
						ois = new ObjectInputStream(new FileInputStream(filePath));
						dba = (db.DataBase)ois.readObject();
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"High Score is : "+dba.getScore() );
					
				}
		});
		
		exit = new JButton("Exit");
		exit.setBounds(164, 194, 106, 23);
		contentPane.add(exit);
		
		exit.addActionListener(
		new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
			
		});
		
		
	}
}
