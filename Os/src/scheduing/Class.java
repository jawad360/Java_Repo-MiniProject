package scheduing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Class extends JFrame {

	private JPanel contentPane;
	private JTable[] cl1t;
	private JPanel[] cl1p;
	private JScrollPane[] cl1sr;
	private JTabbedPane tabbedPane;
	DefaultTableModel[] tm;
	private JTable table;
	String[] title ;
	/**
	 * Launch the application.
	 */
	public  void start(final String[][][] tt, final int lect) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class frame = new Class(tt,lect);
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
	public Class(final String[][][] tt, int lect) 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTimeTable = new JLabel("<html><body><u>Time Table</u></body></html>");
		lblTimeTable.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTimeTable.setForeground(Color.RED);
		lblTimeTable.setBounds(181, 6, 71, 19);
		getContentPane().add(lblTimeTable);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 30, 513, 281);
		contentPane.add(tabbedPane);
		
		cl1t = new JTable[tt.length];
		cl1p = new JPanel[tt.length];
		cl1sr = new JScrollPane[tt.length];
		tm = new DefaultTableModel[tt.length];
		title = new String[lect];
		
		for(int i=0;i<lect;i++)
			title[i] = "Lect "+(i+1);
		
		
				for(int i=0;i<tt.length;i++)
				{
					cl1p[i] = new JPanel();
					tabbedPane.addTab("Class "+(i+1), null, cl1p[i], null);
					cl1p[i].setLayout(null);
					
					cl1sr[i] = new JScrollPane();
					cl1sr[i].setBounds(0, 0, 508, 253);
					cl1p[i].add(cl1sr[i]);
					
					cl1t[i] = new JTable();
					cl1t[i].setModel(new DefaultTableModel(
							tt[i],title));
					cl1sr[i].setViewportView(cl1t[i]);		
				}	
	}

	public Class() {

	}
}
