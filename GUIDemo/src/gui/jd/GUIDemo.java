package gui.jd;

import javax.swing.*;

public class GUIDemo 
{
	static String name;
	public static void main(String args[])
	{
		name = JOptionPane.showInputDialog("Jawad\nSonalkar\nC22\n144");
		JOptionPane.showMessageDialog(null, name,"Name",JOptionPane.PLAIN_MESSAGE);
		
		GUIDemo d= new GUIDemo();
		d.display();
	}
	void display()
	{
		Icon bug = new ImageIcon(getClass().getResource("Man.png"));	//imageicon has to be icon i.e refr
	
		JOptionPane.showMessageDialog(null, name, "Demo", JOptionPane.PLAIN_MESSAGE, bug);
	
	}

}
