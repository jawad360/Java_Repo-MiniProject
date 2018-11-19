package scjp;

public class FinalClass	extends Aa			//Cannot extends final class
{									//Cannot override final methods 
	public static void main(String args[])
	{
		Aa a = new Aa();
		a.display();
		Bb b = new Bb();
		b.display();
		
	
	}

	private void display()
	{
		
	}
}

 final class Aa
{
	final void display()
	{
		System.out.println("Displaying...");
	}
}

class Bb  						//classes cannot be static
{
	void display()
	{
		System.out.println("Displaying...");
	}
}