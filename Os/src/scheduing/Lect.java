package scheduing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lect extends JFrame {

	private JPanel contentPane;
	int days,lect;
	JSpinner spinner;
	JSpinner spinner_1;
	/**
	 * Launch the application.
	 */
	public static void comp(final String[][] subT, final int noc) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lect frame = new Lect(subT,noc);
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
	public Lect(final String[][] subT, final int noc) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDaysPerWeek = new JLabel("Days per Week");
		lblDaysPerWeek.setBounds(104, 77, 133, 16);
		contentPane.add(lblDaysPerWeek);
		
		JLabel lblLecturePerDay = new JLabel("Lecture per Day");
		lblLecturePerDay.setBounds(101, 146, 136, 16);
		contentPane.add(lblLecturePerDay);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner.setBounds(291, 71, 39, 28);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(288, 140, 43, 28);
		contentPane.add(spinner_1);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				days = (int) spinner.getValue();
				lect = (int) spinner_1.getValue();
				
				new Algo().comp(subT, noc,days,lect);
			}
		});
		btnNext.setBounds(172, 215, 90, 28);
		contentPane.add(btnNext);
	}

	public Lect() {
	}
}
