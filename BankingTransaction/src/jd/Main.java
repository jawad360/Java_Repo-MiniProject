package jd;


import java.io.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Main 
{
	public static void main(String args[]) throws Exception
	{
		Details d = new Details();
		d.getOption();
		
	}

}



class Record  implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String id,password;
	private double iniBal;
	
	Record(String id1,String pass,double iniBal)
	{
		setId(id1);
		setPass(pass);
		setIniBal(iniBal);
	}
	void setId(String id1)
	{
		id=id1;
		
	}
	void setPass(String pass)
	{
		password=pass;
		
	}
	String getId()
	{
		return id;
	}
	String getPass()
	{
		return password;
	}
	void setIniBal(double bal)
	{
		iniBal=bal;
	}
	double getIniBal()
	{
		return iniBal;
	}
	void deposit(double bal)
	{
		iniBal=iniBal+bal;
	}
	void withdraw(double bal)
	{
		iniBal=iniBal-bal;
	}
	
}



class Details
{
	int opt;
	Details()
	{
		//Icon bank = new ImageIcon(getClass().getResource("Welcome.png"));
		
		//JOptionPane.showMessageDialog(null, null,"Welcome",JOptionPane.PLAIN_MESSAGE,bank);
		
	}
	void getOption() throws Exception
	{
		String s=JOptionPane.showInputDialog("1.Login In\n2.Create new Account");
		opt = Integer.parseInt(s);
		
		if(opt==1)
		{
			new Login();
		}
		if(opt==2)
		{
			new CreateNew();
		}
	}
}
class CreateNew 
{
	String id,pass;
	double iniBal;
	String  filePath="C://AccountDetails";

	
	
	CreateNew()throws Exception
	{
		
		FileOutputStream fos = new FileOutputStream(filePath,true);
		ObjectOutputStream output = new ObjectOutputStream(fos);
		
		
		id=JOptionPane.showInputDialog("Enter new Id");
		pass=JOptionPane.showInputDialog("Enter password");
		iniBal = Double.parseDouble(JOptionPane.showInputDialog("Enter initial Balance"));
		
		Record record = new Record(id,pass,iniBal);
		
		output.writeObject(record);
		output.flush();
	
		output.close();
		
		JOptionPane.showMessageDialog(null, "Account Created Successfully....");
		
	
	}
}

class Login
{
	String id,pass;
	String  filePath = "C://AccountDetails";
	Record[] record;
	int i;
	
	Login() throws Exception
	{
		id=JOptionPane.showInputDialog("Enter Login Id");
		pass=JOptionPane.showInputDialog("Enter Password");
		
		modify();
	}
	
	
	void modify()throws Exception
	{
		i=0;
		
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream input = null;
		
		
		
		record = new Record[20];
		
		try
		{
			//input = new ObjectInputStream(fis);
		while(true)
		{
			input = new ObjectInputStream(fis);				//dont know.....
			
			record[i] = (Record)input.readObject();
			
			if(record[i].getId().equals(id) && record[i].getPass().equals(pass))
			{
				String s=JOptionPane.showInputDialog("1.Deposit\n2.Withdraw\n3.Display Info\n4.Exit");
				int opt = Integer.parseInt(s);
				
				switch(opt)
				{
				case 1:double dep = Double.parseDouble(JOptionPane.showInputDialog("Enter amount"));
					record[i].deposit(dep);
					JOptionPane.showMessageDialog(null, "Amount Depsited Successfully....");
					
					break;
					
					case 2: double wit =  Double.parseDouble(JOptionPane.showInputDialog("Enter amount"));
					record[i].withdraw(wit);
					JOptionPane.showMessageDialog(null, "Amount Withdrawn Successfully....");
					break;
					
					case 3:JOptionPane.showMessageDialog(null, "Login Id: "+record[i].getId()+"\nPassword: "+record[i].getPass()+"\nCurrent Balance: "+record[i].getIniBal());
					break;
					
					case 4:System.exit(1);
					
				}
				
			}
			
			i++;

		}
			
		
		
	}
	catch(Exception e)
	{
		
	}
		finally
		{
			
			input.close();
			writeContents();
		}
		
	}
	
	void writeContents()throws Exception
	{
		File f = new File(filePath);
		f.delete();
		
		FileOutputStream fos = new FileOutputStream(filePath,true);
		ObjectOutputStream output = null;
		
		try
		{
			for(int j=0;j<i;j++)
			{
				output = new ObjectOutputStream(fos);			//dont know.....
				output.writeObject(record[j]);
				output.flush();
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			output.close();
		}
	}
}
