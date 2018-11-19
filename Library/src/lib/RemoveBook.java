package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import lib.Library;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RemoveBook extends JFrame {

	private JPanel contentPane;
	String[] s = new  String[10] ;
	JComboBox comboBox;
	JSpinner spinner;
	int[] q = new int[10];
	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveBook frame = new RemoveBook();
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
	 */
	public RemoveBook() throws IOException 
	{
		FileInputStream fis = new FileInputStream(new Library(9).rBook);
		ObjectInputStream in = null;
		Record r ;
		
		try
		{
			int i=0;
			while(true)
			{
				in = new ObjectInputStream(fis);
				r = (Record)in.readObject();
				
				s[i] = new String();
				s[i]=r.getName();
				q[i]=r.getQuan();
				i++;
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			in.close();
		}
		
		//String[] g = new String[]{"m","j","l"}; 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveBooks = new JLabel("Remove Books");
		lblRemoveBooks.setBounds(142, 11, 149, 38);
		lblRemoveBooks.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblRemoveBooks);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 414, 2);
		contentPane.add(separator);
		
		comboBox = new JComboBox();
		comboBox.setBounds(162, 93, 110, 20);
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(s));
		contentPane.add(comboBox);
		
		

		
		spinner= new JSpinner();
		//spinner.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spinner.setBounds(193, 156, 47, 20);
		contentPane.add(spinner);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(172, 217, 89, 23);
		contentPane.add(btnDone);
		
		comboBox.addItemListener(
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						spinner.setModel(new SpinnerNumberModel(0, 0, q[comboBox.getSelectedIndex()], 1));
						spinner.setValue(q[comboBox.getSelectedIndex()]);
					}
					
				});
		
		
	}
}
