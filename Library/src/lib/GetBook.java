package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JButton;

public class GetBook extends JFrame {
	
	private JList list;
	StoreRec rec;
	String[] values = new String[10];

	private JPanel contentPane;
	private JButton btnIssue;
	static GetBook frame;
	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GetBook();
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
	@SuppressWarnings("unchecked")
	public GetBook() throws IOException {
		rec = new StoreRec();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select A Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(150, 11, 133, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 414, 2);
		contentPane.add(separator);
		
		try
		{
			int i=0;
			while(true)
			{
				values[i] = new String();
				values[i] = rec.r1[i].getName();
				i++;
			}
		}
		catch(Exception e)
		{
			
		}
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			 
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(54, 88, 109, 122);
		contentPane.add(list);
		
		btnIssue = new JButton("Issue");
		btnIssue.setBounds(239, 136, 89, 23);
		contentPane.add(btnIssue);
		btnIssue.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						Date d = new Date();
						d.setTime(d.getTime()+(15*24*60*60*1000));
						DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
						String t = list.getSelectedValue().toString();
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Book Issued...\nBook Name: "+t+"\nLogin Id: "+Library.id+"\nReturn date:\n"+df.format(d));
						
					}
					
				});
		
		
	}

}
