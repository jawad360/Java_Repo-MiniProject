package hg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton ok;
	private Canvas canvas;
	String imPath = "D://eclipse-java-juno-SR1-win32//MiniProject//Hangman//HMImages";
	String filePath = "D://Database";
	ObjectInputStream ois;
	db.DataBase dba;
	private JRadioButton animalsRb;
	private JRadioButton sportsRb;
	private JRadioButton citiesRb;
	private ButtonGroup opt = new ButtonGroup();
	int chk = 2;
	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public Game() throws FileNotFoundException, IOException, ClassNotFoundException  , FileNotFoundException, IOException, ClassNotFoundException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlay = new JLabel("Play");
		lblPlay.setForeground(new Color(30, 144, 255));
		lblPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlay.setBounds(197, 15, 40, 22);
		contentPane.add(lblPlay);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 414, 12);
		contentPane.add(separator);
		
		canvas = new Canvas();
		canvas.setBounds(293, 118, 143, 184);
		contentPane.add(canvas);
		
		ok = new JButton("OK");
		ok.setBounds(91, 279, 89, 23);
		contentPane.add(ok);
		
		JLabel lblEnterAlphabet = new JLabel("Enter Alphabet");
		lblEnterAlphabet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterAlphabet.setBounds(35, 249, 97, 14);
		contentPane.add(lblEnterAlphabet);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F","G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		comboBox.setBounds(35, 277, 44, 26);
		contentPane.add(comboBox);
		
		animalsRb = new JRadioButton("Animals");
		opt.add(animalsRb);
		animalsRb.setBounds(28, 72, 89, 18);
		contentPane.add(animalsRb);
		
		sportsRb = new JRadioButton("Sports");
		opt.add(sportsRb);
		sportsRb.setBounds(171, 72, 76, 18);
		contentPane.add(sportsRb);
		
		citiesRb = new JRadioButton("Cities");
		citiesRb.setSelected(true);
		opt.add(citiesRb);
		citiesRb.setBounds(314, 72, 76, 18);
		contentPane.add(citiesRb);
	
		animalsRb.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							genWord(0);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
		sportsRb.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							genWord(1);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
		citiesRb.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							genWord(2);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
		
		genWord(2);
	}
	void genWord(int c) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Random rand = new Random();
		ois = new ObjectInputStream(new FileInputStream(filePath));		//
		dba = (db.DataBase)ois.readObject();
		
		int r;
		r = rand.nextInt(dba.v[c].length);
		
		System.out.println(dba.v[c][r]);
	}
}
