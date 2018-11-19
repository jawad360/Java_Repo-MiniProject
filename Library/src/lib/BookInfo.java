package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Dictionary;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class BookInfo extends JFrame {
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JRadioButton byAut;
	private JRadioButton byName;
	private JRadioButton byPrice;
	private JList list;
	private JButton select;
	StoreRec rec;
	String[] values = new String[10];
	private JTextArea textArea;
	private JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfo frame = new BookInfo();
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
	public BookInfo() throws IOException 
	{
		rec = new StoreRec();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBooksInfo = new JLabel("Books Info");
		lblBooksInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBooksInfo.setBounds(166, 11, 101, 25);
		contentPane.add(lblBooksInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 414, 2);
		contentPane.add(separator);
		
		byName = new JRadioButton("By Name");
		buttonGroup.add(byName);
		byName.setBounds(26, 60, 109, 23);
		contentPane.add(byName);
		byName.addItemListener(
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) 
					{
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
						catch(Exception ei)
						{
							
						}
						list.setModel(new AbstractListModel() {
							 
							
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
					}
					
				});
		
		byAut = new JRadioButton("By Author");
		buttonGroup.add(byAut);
		byAut.setBounds(161, 60, 109, 23);
		contentPane.add(byAut);
		byAut.addItemListener(
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						try
						{
							int i=0;
							while(true)
							{
								values[i] = new String();
								values[i] = rec.r1[i].getAuthor();
								i++;
							}
						}
						catch(Exception ei)
						{
							
						}
						list.setModel(new AbstractListModel() {
							 
							
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
					}
					
				});
		
		
		byPrice = new JRadioButton("By Price");
		buttonGroup.add(byPrice);
		byPrice.setBounds(296, 60, 109, 23);
		contentPane.add(byPrice);
		byPrice.addItemListener(
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						list.setModel(new AbstractListModel() {
							 
							String[] s = new String[]{""}; 
							public int getSize() {
								return s.length;
							}
							public Object getElementAt(int index) {
								return s[index];
							}
					});
						slider.setEnabled(true);
					}
					
				});
		
		
		slider = new JSlider();
		slider.setEnabled(false);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(250);
		slider.setMaximum(350);
		slider.setMinimum(150);
		slider.setMajorTickSpacing(100);
		slider.setBounds(255, 90, 150, 45);
		contentPane.add(slider);
		slider.addChangeListener(
				new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent e) 
					{

						progressBar.setValue(slider.getValue());
						try
						{
							int i=0;
							while(true)
							{
				
								
								if((int)rec.r1[i].getPrice() < slider.getValue())
								{
									values[i] = new String();
									values[i] = rec.r1[i].getName();
								}
								i++;
							}
						}
						catch(Exception ei)
						{
							
						}
						list.setModel(new AbstractListModel() {
							 
							
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
					});
					
				}
				});
		
		
		
		list = new JList();
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(26, 106, 109, 128);
		contentPane.add(list);
		
		textArea = new JTextArea();
		textArea.setBounds(234, 146, 129, 93);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		select = new JButton("Select");
		select.setBounds(151, 167, 61, 23);
		contentPane.add(select);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(SystemColor.textHighlight);
		progressBar.setMaximum(350);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(388, 146, 17, 118);
		contentPane.add(progressBar);
		select.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						int in=list.getSelectedIndex();
						textArea.setText("Name: "+rec.r1[in].getName()+"\nAuthor: "+rec.r1[in].getAuthor()+"\nPrice: "
						+rec.r1[in].getPrice()+"\nQuantity: "+rec.r1[in].getQuan()+"\nOn id: "+Library.id);
					}
					
				}
				);
	}
}
