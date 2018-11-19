package scheduing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TimeTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static TimeTable frame;
	int not,noc,durh,durm,nos;
	private JSpinner nots;
	private JSpinner nocs;
	private JSpinner dur1s;
	private JSpinner dur2s;
	private JSpinner noss;
	private JButton btnOk;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TimeTable();
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
	public TimeTable() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTimeTableScheduling = new JLabel("Time Table Scheduling");
		lblTimeTableScheduling.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTimeTableScheduling.setBounds(146, 10, 137, 19);
		contentPane.add(lblTimeTableScheduling);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 36, 410, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("No of Teachers");
		lblNewLabel.setBounds(45, 62, 138, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No of classes");
		lblNewLabel_1.setBounds(45, 108, 138, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time duration");
		lblNewLabel_2.setBounds(45, 154, 138, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No of Subjects");
		lblNewLabel_3.setBounds(45, 200, 138, 16);
		contentPane.add(lblNewLabel_3);
		
		noss = new JSpinner();
		noss.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		noss.setBounds(195, 188, 39, 28);
		contentPane.add(noss);
		
		dur1s = new JSpinner();
		dur1s.setBounds(195, 142, 39, 28);
		contentPane.add(dur1s);
		
		nocs = new JSpinner();
		nocs.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		nocs.setBounds(195, 96, 39, 28);
		contentPane.add(nocs);
		
		nots = new JSpinner();
		nots.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		nots.setBounds(195, 50, 39, 28);
		contentPane.add(nots);
		
		JLabel lblHrs = new JLabel("Hrs");
		lblHrs.setBounds(235, 154, 20, 16);
		contentPane.add(lblHrs);
		
		dur2s = new JSpinner();
		dur2s.setBounds(257, 142, 39, 28);
		contentPane.add(dur2s);
		
		JLabel lblMins = new JLabel("mins");
		lblMins.setBounds(295, 154, 28, 16);
		contentPane.add(lblMins);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(179, 228, 76, 28);
		contentPane.add(btnOk);
		
		btnOk.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				not = (int) nots.getValue();
				noc = (int) nocs.getValue();
				nos = (int) noss.getValue();
				durh = (int) dur1s.getValue();
				durm = (int) dur2s.getValue();

				frame.setVisible(false);
				frame.dispose();
				Subject.start(not, noc, nos, durh, durm);
				
			}
			
		});	
	}
}