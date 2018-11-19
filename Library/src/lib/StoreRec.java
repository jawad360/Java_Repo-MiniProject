package lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StoreRec 
{
	
	Record[] r1 = new Record[10];
	
	public StoreRec() throws IOException
	{
		FileInputStream fis = new FileInputStream(new Library(0).rBook);
		ObjectInputStream in = null;
		
		try
		{
			int i=0;
			while(true)
			{
				in = new ObjectInputStream(fis);
				r1[i] = new Record();
				
				r1[i] = (Record)in.readObject();
				i++;
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			in.close();
		}
		
	}

}
