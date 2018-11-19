package scjp;

public class Object1 
{
	public static void main(String args[])
	{
		X a= new X();
		new X();					//They are pointing to different objects
		new X();
		new X();
	    System.out.println(new X().c);
	    System.out.println(new X().c);
	    
	}

}
class X
{
	int c=0;
	X()
	{
		c++;
	}
}
