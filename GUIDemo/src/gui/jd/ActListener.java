package gui.jd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class ActListener extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar;
	JSpinner spinner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActListener frame = new ActListener();
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
	public ActListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("45px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(28dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(40dlu;default)"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("186px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),}));
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(slider, "4, 2, left, fill");
		
		progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(progressBar, "6, 2");
		
		 spinner = new JSpinner();
		 spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		contentPane.add(spinner, "8, 2");
		spinner.addChangeListener(
				new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent e) 
					{
						progressBar.setValue((int) spinner.getValue());
						
					}
					
				}
				
				);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "10, 2, fill, default");
		
		JToggleButton tglbtnOk = new JToggleButton("Ok");
		contentPane.add(tglbtnOk, "12, 2");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ok");
		contentPane.add(chckbxNewCheckBox, "14, 2");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "8, 4");
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "14, 4");
	}

}
