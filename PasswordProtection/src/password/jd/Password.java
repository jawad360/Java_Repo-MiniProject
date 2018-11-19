package password.jd;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import javax.swing.JOptionPane;


public class Password 
{
	public static void main(String args[]) throws Exception
	{
		Details d = new Details();
		d.getOption();
		
	}

}



//class Record
class Record  implements Serializable
{

	
	String id,password;
	double iniBal;
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



//class Details
class Details
{
	
	String filePath="C://LoginDetails";
	void getOption() throws IOException, ClassNotFoundException,StreamCorruptedException
	{
		int opt=Integer.parseInt(JOptionPane.showInputDialog("1.Login\n2.Create New"));
		if(opt==1)
			checkRecord();
		if(opt==2)
			enterRecord();
		
	}
	
	
	
	void enterRecord() throws IOException, ClassNotFoundException
	{
		String id,pass;
		double iniBal;

		String t="0";
		

		FileOutputStream fs = new FileOutputStream(filePath,true);
		ObjectOutputStream output = new ObjectOutputStream(fs);
		
		
		
		do{
			
		
		id=JOptionPane.showInputDialog("Enter New Id");
		pass=JOptionPane.showInputDialog("Enter New Password");
		iniBal=(double)Double.parseDouble(JOptionPane.showInputDialog("Enter Initial Balance"));
		
		
		Record record = new Record(id,pass,iniBal);
		
		
		String opt=JOptionPane.showInputDialog("1.Deposit\n2.Withdraw\n3.Check Info\n4.Exit");
		
		if(opt.equals("1"))
		{
			double bal = (double)Double.parseDouble(JOptionPane.showInputDialog("Enter Balance"));
			record.deposit(bal);
		}
		if(opt.equals("2"))
		{
			double bal = (double)Double.parseDouble(JOptionPane.showInputDialog("Enter Balance to withdraw"));
			record.withdraw(bal);
		}
		if(opt.equals("3"))
		{
			JOptionPane.showInternalMessageDialog(null,"Login:"+record.getId()+"\nPassword:"+record.getPass()+"\nBalance:"+record.getIniBal(), "Info", JOptionPane.PLAIN_MESSAGE);
		}
		if(opt.equals("4"))
			t="4";
	
		output.writeObject(record);
		
		output.flush();
		
		}
		while(t!="4");
		
		output.close();
	}
	
	
	
	
	void checkRecord() throws IOException, ClassNotFoundException,StreamCorruptedException
	{
		String id,pass;
		
		id=JOptionPane.showInputDialog("Enter Login Id");
		pass=JOptionPane.showInputDialog("Enter Password");
		
		FileInputStream fs = new FileInputStream(filePath);
		ObjectInputStream input = null;
		
		
		Record record;
		
		
		try
		{
			
			//input = new ObjectInputStream(fs);			//Exception....

		while(true)
		{
			input = new ObjectInputStream(fs);				//working properly

			
			record =  (Record) input.readObject();			//Actual problem.....
			
			if(record.getPass().equals(pass) && record.getId().equals(id))	
			{
				JOptionPane.showMessageDialog(null, record.getIniBal(),"Output",JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		}
		catch(EOFException e)
		{
			return;
		}
		catch(ClassNotFoundException c)
		{
			return;
		}
		finally
		{
			input.close();
		}
	}
	
	
}