package scheduing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Subject extends JFrame {

	private JPanel contentPane;
	private JTextField[][] sub;
	private JTextField[] name;
	private JLabel[] srno;
	private JSpinner[] no;
	private JTextField textField;
	int x=0;
	int i;
	String subT[][];
	static Subject frame;
	
	/**
	 * Launch the application.
	 */
	public static void start(final int not, final int noc, final int nos, final int durh, final int durm) 
	{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Subject(not, noc, nos, durh, durm);
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
	public Subject(final int not, final int noc, int nos, int durh, int durm) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(55, 10, 34, 16);
		getContentPane().add(lblName);
		
		JLabel lblSubjects = new JLabel("Subjects");
		lblSubjects.setBounds(230, 10, 55, 16);
		getContentPane().add(lblSubjects);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBounds(177, 232, 80, 24);
		contentPane.add(btnNewButton);
		
		sub = new JTextField[not][];
		name = new JTextField[not];
		srno = new JLabel[not];
		no = new JSpinner[not];
		sub = new JTextField[not][nos];
		
		for(i=0 ; i<not ; i++)
		{
			final int index = i;
			
			srno[i] = new JLabel("T"+(i+1));
			srno[i].setBounds(10, 46+i*40, 14, 16);
			contentPane.add(srno[i]);
			
			no[i] = new JSpinner();
			no[i].setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(nos), new Integer(1)));
			no[i].setBounds(127, 40+i*40, 43, 28);
			contentPane.add(no[i]);
			
			name[i] = new JTextField();
			name[i].setBounds(43, 40+i*40, 74, 28);
			contentPane.add(name[i]);
			name[i].setColumns(10);
			
			sub[i][0] = new JTextField();
			sub[i][0].setBounds(185, 40+i*40, 74, 28);
			contentPane.add(sub[i][0]);
			sub[i][0].setColumns(10);
			
			no[i].addChangeListener(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent arg0) 
				{
					sub[index][((int) no[index].getValue())-1] = new JTextField();
					sub[index][((int) no[index].getValue())-1].setBounds(185+(((int) no[index].getValue())-1)*85, 40+index*40, 74, 28);
					contentPane.add(sub[index][((int) no[index].getValue())-1]);
					sub[index][((int) no[index].getValue())-1].setColumns(10);
					
					frame.repaint();
				}
				
			});
		}
		
		subT = new String[not][];
			
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				for(int i=0;i<sub.length;i++)
				{
					subT[i] = new String[sub[i].length];
					
					for(int j=0; j<sub[i].length && sub[i][j]!=null;j++)
					{
						
						subT[i][j] = sub[i][j].getText()+"("+name[i].getText()+")";
					}
				}
				
				//frame.dispose();
				new Lect().comp(subT,noc);
			}
		});
			
	}
	public Subject() 
	{		
			
	}
}
