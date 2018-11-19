package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class AddData
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();
		String s = "";
		int fl = 0;
		File f = new File("D://Wordlist.txt");
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		while((s = br.readLine()) != null)
		{
			if(s.equalsIgnoreCase("Animals:"))
				fl = 1;
			else if(s.equalsIgnoreCase("Sports:"))
				fl = 2;	
			else if(s.equalsIgnoreCase("Cities:"))
				fl = 3;
			else if(fl == 1)
				v1.add(s);
			else if(fl == 2)
				v2.add(s);
			else if(fl == 3)
				v3.add(s);
			
		}
		br.close();
		DataBase db = new DataBase(v1,v2,v3);
		db.setScore(12);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://Database"));
		try
		{
			oos.writeObject((DataBase)db);
		}
		catch(Exception e)
		{
			
		}
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://Database"));
		DataBase dba = (DataBase)ois.readObject();
		System.out.println(dba.getScore());
		ois.close();
	}
}

