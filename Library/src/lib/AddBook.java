package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBook extends JFrame {

	private JPanel contentPane;
	static AddBook frame;
	private JTextField namet;
	private JTextField authort;
	private JTextField pricet;
	private JTextField quant;
	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(189, 11, 56, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 414, 2);
		contentPane.add(separator);
		
		JLabel namel = new JLabel("Name");
		namel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		namel.setBounds(34, 63, 46, 14);
		contentPane.add(namel);
		
		JLabel authorl = new JLabel("Author");
		authorl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		authorl.setBounds(34, 118, 46, 14);
		contentPane.add(authorl);
		
		JLabel pricel = new JLabel("Price");
		pricel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pricel.setBounds(34, 173, 46, 14);
		contentPane.add(pricel);
		
		JLabel quanl = new JLabel("Quantity");
		quanl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quanl.setBounds(34, 228, 56, 16);
		contentPane.add(quanl);
		
		namet = new JTextField();
		namet.setBounds(118, 62, 127, 20);
		contentPane.add(namet);
		namet.setColumns(10);
		
		authort = new JTextField();
		authort.setBounds(118, 117, 127, 20);
		contentPane.add(authort);
		authort.setColumns(10);
		
		pricet = new JTextField();
		pricet.setBounds(118, 172, 127, 20);
		contentPane.add(pricet);
		pricet.setColumns(10);
		
		quant = new JTextField();
		quant.setBounds(118, 228, 127, 20);
		contentPane.add(quant);
		quant.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(300, 138, 89, 23);
		contentPane.add(submit);
		
		submit.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try 
						{
							frame.setVisible(false);
							addBk();
						} 
						catch (IOException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
	}
	public void addBk() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(new Library(0).rBook,true);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		
		Record r = new Record(namet.getText(),authort.getText(),Double.parseDouble(pricet.getText()),Integer.parseInt(quant.getText()));
		
		out.writeObject(r);
		out.close();
	}
}
