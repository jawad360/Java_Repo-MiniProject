package lib;

import java.io.Serializable;

public class Log implements Serializable
{
	private String id;
	private String pass;
	
	public void setId(String n)
	{
		id = n;
	}
	public String  getId()
	{
		return id;
	}
	public void setPass(String p)
	{
		pass = p;
		
	}
	public String getPass()
	{
		return pass;
	}
	

}
