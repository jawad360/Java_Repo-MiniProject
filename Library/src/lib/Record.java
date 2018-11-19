package lib;

import java.io.Serializable;

class Record implements Serializable
{
	private String name;
	private String author;
	private double price;
	private int quan;
	
	Record()
	{
		
	}
	Record(String n,String a,double p,int q)
	{
		setName(n);
		setAuthor(a);
		setQuan(q);
		setPrice(p);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public void setAuthor(String a)
	{
		author = a;
	}
	public void setPrice(double p)
	{
		price  = p;
	}
	public void setQuan(int q)
	{
		quan = q;
	}
	public String getName()
	{
		return name;
	}
	public String getAuthor()
	{
		return author;
	}
	public double getPrice()
	{
		return price;
	}
	public int getQuan()
	{
		return quan;
	}
	
}

